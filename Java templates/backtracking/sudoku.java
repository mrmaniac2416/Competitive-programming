public class Solution {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
       
           solve(a);

    }
    
    public boolean solve(ArrayList<ArrayList<Character>> a)
    {
         int emptyCell[]=findEmptyCell(a);
         if(emptyCell==null)
           return true;
     
              
            int i=emptyCell[0];
            int j=emptyCell[1];
                 for(char k='1';k<='9';k++)
                  {
                     if(!isUsed(a,i,j,k))
                     {
                         a.get(i).set(j,k);
                         if(solve(a))
                           return true;
                         a.get(i).set(j,'.');
                       
                     }
                   }
                 
         return false;
    }
    
    public int[] findEmptyCell(ArrayList<ArrayList<Character>> a)
    {
        int result[]=new int[2];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(a.get(i).get(j)=='.')
                {
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return null;
    }
    
    public boolean isUsed(ArrayList<ArrayList<Character>> a,int i,int j,char k)
    {
        //row check 
        for(int col=0;col<9;col++)
        {
            if(a.get(i).get(col)==k )
                 return true;
        }
        //col check
        
        for(int row=0; row<9; row++)
        {
            if(a.get(row).get(j)==k)
                 return true;
        }
        
        // box check
        for(int row=3*(i/3); row<(3*(i/3)+3);row++)
        {
            for(int col=3*(j/3);col<(3*(j/3)+3);col++)
            {
                if(a.get(row).get(col)==k)
                   return true;
            }
        }
        return false;
        
        
    }
}
