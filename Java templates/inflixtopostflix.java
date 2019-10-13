/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    String s=sc.next();
		    Stack<Character> stk=new Stack<>();
		    for(int i=0;i<s.length();i++)
		    {
		        if(isOperand(s.charAt(i)))
		        {
		            int prec1=getPrecedence(s.charAt(i));
		            if(s.charAt(i)=='(')
		               {
		                   stk.push('(');
		                   continue;
		               }
		            if(s.charAt(i)==')')
		            {
		                while(!stk.isEmpty() && stk.peek()!='(')
		                     {
		                         System.out.print(stk.pop());
		                     }
		                     stk.pop();
		                     continue;
		            }
		            if(stk.isEmpty() || (prec1>getPrecedence(stk.peek())))
		                stk.push(s.charAt(i));
		            else
		            {
		                while(!stk.isEmpty() && prec1<= getPrecedence(stk.peek()))
		                  {
		                      System.out.print(stk.pop());
		                  }
		                  stk.push(s.charAt(i));
		            }
		        }
		        else
		          System.out.print(s.charAt(i));
		    }
		    while(!stk.isEmpty())
		        
		        {
		            if(stk.peek()!='(' && stk.peek()!=')')
		            System.out.print(stk.peek());
		            
		            stk.pop();
		        }
		    System.out.println();
		    
		}
	}
	
	static int getPrecedence(char c)
	{
	    if(c=='(' || c==')')
	         return 1;
	    if(c=='-')
	        return 2;
	    if(c=='+')
	        return 2;
	    if(c=='*')
	         return 4;
	     if(c=='/')
	         return 4;
	    
	         return 5;
	}
	
	static boolean isOperand(char c)
	{
	    return c=='(' || c==')' || c=='-' || c=='+' || c=='*' || c=='/' || c=='^';
	}
}