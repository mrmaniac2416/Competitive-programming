/*package whatever //do not write package name here */

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
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		       a[i]=Integer.parseInt(sc.next());
		    
		    int max_until_now=1;
		    int min_until_now=1;
		    int max_so_far=1;
		    
		    for(int i=0;i<n;i++)
		    {
		        if(a[i]>0)
		        {
		            min_until_now=Math.min(min_until_now*a[i],a[i]);
		            max_until_now=Math.max(max_until_now*a[i],a[i]);
		        }
		        else
		        {
		            int t1=min_until_now;
		            int t2=max_until_now;
		            max_until_now=Math.max(t1*a[i],a[i]);
		            min_until_now=Math.min(t2*a[i],a[i]);
		        }
		        max_so_far=Math.max(max_so_far,max_until_now);
		    }
		    System.out.println(max_so_far);
		}
	}
}