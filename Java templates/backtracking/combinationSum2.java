public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Collections.sort(a);
        generateCombinations(a,b,temp,ans,0);
        return ans;
    }
    
    
    void generateCombinations(ArrayList<Integer> a ,int target,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans,int index)
    {
        if(target==0 && !ans.contains(temp))
        {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        int i=index;
       
        while(i<a.size())
        {
         //   if(i!=0 && a.get(i)==a.get(i-1))
          //   continue;
             if(target-a.get(i)<0)
           return;
            temp.add(a.get(i));
           
            generateCombinations(a,target-a.get(i),temp,ans,i+1);
            
            temp.remove(temp.size()-1);
            i++;
        }
        
    }
}
