/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        
        if(A==null)
           return new ArrayList<ArrayList<Integer>>();
        TreeMap<Integer,LinkedHashSet<TreeNode>> levelInfo=new TreeMap<>();
        HashMap<TreeNode,Integer> levels=new HashMap<>();
        Queue<TreeNode> neighbours=new ArrayDeque<>();
        levels.put(A,0);
        neighbours.add(A);
        levelInfo.put(0,new LinkedHashSet<>());
        levelInfo.get(0).add(A);
        
        while(!neighbours.isEmpty())
        {
            TreeNode visiting=neighbours.poll();
            
            if(visiting.left!=null)
             {
                neighbours.add(visiting.left);
                int newLevel=levels.get(visiting)-1;
                levels.put(visiting.left,newLevel);
                if(!levelInfo.containsKey(newLevel))
                {
                    levelInfo.put(newLevel,new LinkedHashSet<>());
                    levelInfo.get(newLevel).add(visiting.left);
                }
                else
                {
                    levelInfo.get(newLevel).add(visiting.left);
                 }
             }
                if(visiting.right!=null)
             {
                neighbours.add(visiting.right);
                int newLevel=levels.get(visiting)+1;
                levels.put(visiting.right,newLevel);
                if(!levelInfo.containsKey(newLevel))
                {
                    levelInfo.put(newLevel,new LinkedHashSet<>());
                    levelInfo.get(newLevel).add(visiting.right);
                }
                else
                {
                    levelInfo.get(newLevel).add(visiting.right);
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        for(int level: levelInfo.keySet())
        {
            ans.add(new ArrayList<Integer>());
            
            for(TreeNode n: levelInfo.get(level))
            {
                ans.get(ans.size()-1).add(n.val);
            }
        }
        return ans;
    }
}
