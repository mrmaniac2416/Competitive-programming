public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Collections.sort(A);
        generateSubsets(A,B,temp,ans,0);
        return ans;
    }
    
    
    public void generateSubsets(ArrayList<Integer> a,int target,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans,int index)
    {
        if(target==0)
        {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=index;i<a.size();i++)
        {
           
            if(i!=0 && a.get(i-1)==a.get(i))
               continue;
            temp.add(a.get(i));
            if(target-a.get(i)>=0)
           {  
              generateSubsets(a,target-a.get(i),temp,ans,i);
              temp.remove(temp.size()-1);
           }
           else
           {
               temp.remove(temp.size()-1);
               generateSubsets(a,target,temp,ans,i+1);
           }
           
        }
    }
    
}
