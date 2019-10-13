public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        
        ArrayList<String> ans=new ArrayList<>();
        StringBuilder s=new StringBuilder();
        
        generateBrackets(2*A,s,ans,0);
        return ans;
        
    }
    
    public void generateBrackets(int n,StringBuilder s,ArrayList<String> ans,int depth)
    {
        if(depth==n)
        {
            if(isValidExpression(s,n))
           {   
              ans.add(s.toString());
              
           }
           return;
        }
            s.append('(');
    
            generateBrackets(n,s,ans,depth+1);
            s.deleteCharAt(s.length()-1);
            s.append(')');
            generateBrackets(n,s,ans,depth+1);
            s.deleteCharAt(s.length()-1);
    
       
    }
    
    public boolean isValidExpression(StringBuilder s,int n)
    {
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
              if(s.charAt(i)==')')
            {
                if(stack.isEmpty())
                return false;
                else
                  stack.pop();
            }
           
            if(s.charAt(i)=='(')
            {
                stack.push('(');
             
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
