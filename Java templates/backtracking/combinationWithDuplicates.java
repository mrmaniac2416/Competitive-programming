public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        
        generateSubset(A,temp,ans,0);
        return ans;
    }
    
    public void generateSubset(ArrayList<Integer> A,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans,int index)
    {
        for(int i=index;i<A.size();i++)
        {
            temp.add(A.get(i));
            if(!ans.contains(temp))
               ans.add(new ArrayList<Integer>(temp));
               
             generateSubset(A,temp,ans,i+1);
             temp.remove(temp.size()-1);
               
        }
    }
}
