
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		
		while(t-->0)
		{
		    int n=Integer.parseInt(sc.next());
		    String strs[]=new String[n];
		    
		    for(int i=0;i<n;i++)
		       strs[i]=sc.next();
		       
		    String s=sc.next();
		    int size=s.length();
		    
		    boolean dp[]=new boolean[size+1];
		    
		    for(int i=1;i<=size;i++)
		    {
		        if(contains(strs,s.substring(0,i)))
		             dp[i]=true;
		          if(dp[i])
		          {
		              
		          for(int j=i+1;j<=size;j++)
		          {
		              if(contains(strs,s.substring(i,j)))
		                   dp[j]=true;
		          }
		          }
		    }
		    System.out.println(dp[size] ? "1"  : "0");
		    
		    
		}
	}
	
	public static boolean contains(String strs[],String s)
	{
	    for(int i=0;i<strs.length;i++)
	        if(s.equals(strs[i]))
	            {
	                return true;
	            }
	    
	    
	    return false;
	}
}