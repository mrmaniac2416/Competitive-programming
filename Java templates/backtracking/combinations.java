public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<Integer> temp=new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        generateCombinations(A,B,temp,ans,1);
        return ans;
    }
    
    public void generateCombinations(int n,int k, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans,int index)
    {
        if(k==0)
        {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=index;i<=n;i++)
        {
            temp.add(i);
            generateCombinations(n,k-1,temp,ans,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
