
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
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int dp[][]=new int[n+1][k+1];
		    
		    for(int i=1;i<=n;i++)
		    {
		        for(int j=1;j<=k;j++)
		        {
		            if(j==0 || j==1)
		                dp[i][j]=j;
		             else if(i==1)
		                dp[i][j]=j;
		             else
		                {
		                    dp[i][j]=Integer.MAX_VALUE;
		                    for(int x=1;x<=j;x++)
		                    {
		                        int res=1+Math.max(dp[i-1][x-1],dp[i][j-x]);
		                        if(res<dp[i][j])
		                           dp[i][j]=res;
		                    }
		                }
		        }
		    }
		    System.out.println(dp[n][k]);
		}
	}
}