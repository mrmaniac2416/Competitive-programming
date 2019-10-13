 public String longestPalindrome(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                if(s.charAt(i)==s.charAt(j) && (dp[i+1][j-1] || j==(i+1)))
                    dp[i][j]=true;
            }
        }
        int maxLen=0;
        int maxI=0;
        int maxJ=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(dp[i][j])
                {
                
                    if(maxLen<(j-i+1))
                  {
                    maxLen=j-i+1;
                    maxI=i;
                    maxJ=j;
                  }
                
                }
                
            }
        }
        
        return s.substring(maxI,maxJ+1);
        
        
    }