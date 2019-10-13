public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[nums.length];
        
        for(int i=0;i<n;i++)
            dp[i]=1;
        
        for(int i=0;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int maxSequence=0;
        for(int num : dp)
        {
            if(maxSequence < num)
                 maxSequence=num;
        }
        return maxSequence;
        
    }