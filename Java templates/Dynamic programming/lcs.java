static int[] longestCommonSubsequence(int[] a, int[] b) {
         int n=a.length;
         int m=b.length;
         int dp[][]=new int[n+1][m+1];
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(a[i-1]==b[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        int lcs[]=new int[dp[n][m]];
        int currN=n;
        int currM=m;
        int noOfElements=0;
      //  debug(dp);
        while(noOfElements != lcs.length)
        {
            
               
                   if(a[currN-1]==b[currM-1])
                   {
                       lcs[lcs.length-1 - noOfElements]=a[currN-1];
                       currN=currN-1;
                       currM=currM-1;
                       
                       noOfElements++;
                   }
                 else
                 {
                     if(dp[currN][currM]==dp[currN-1][currM])
                     {
                         currN=currN-1;
                     }
                     else
                         currM=currM-1;
                 }
               
            
        }
        return lcs;

    }