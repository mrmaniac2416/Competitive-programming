 int noOfStages=sc.nextInt();
        int entryTimes[]=new int[2];
        int exitTimes[]=new int[2];

        entryTimes[0]=sc.nextInt();
        entryTimes[1]=sc.nextInt();
        exitTimes[0]=sc.nextInt();
        exitTimes[1]=sc.nextInt();

        int timeAtStages[][]=new int[2][noOfStages+1];
        for(int i=0;i<2;i++)
        {
            for(int j=1;j<=noOfStages;j++)
            {
                timeAtStages[i][j]=sc.nextInt();
            }
        }
        int shiftingTimes[][]=new int[2][noOfStages+1];

        for(int i=0;i<2;i++)
        {
            for(int j=2;j<=noOfStages;j++)
            {
                shiftingTimes[i][j]=sc.nextInt();
            }
        }

        int dp1[]=new int[noOfStages+1];
        int dp2[]=new int[noOfStages+1];
        dp1[0]=entryTimes[0];
        dp2[0]=entryTimes[1];
        dp1[1]=dp1[0]+timeAtStages[0][1];
        dp2[1]=dp2[0]+timeAtStages[1][1];
        for(int i=2;i<=noOfStages;i++)
        {
            dp1[i]=Math.min(dp2[i-1]+shiftingTimes[1][i]+ timeAtStages[0][i],dp1[i-1]+timeAtStages[0][i]);
            dp2[i]=Math.min(dp1[i-1]+shiftingTimes[0][i] + timeAtStages[1][i],dp2[i-1]+ timeAtStages[1][i]);
        }
        debug(dp1);
        debug(dp2);
        System.out.println(Math.min(dp1[noOfStages]+exitTimes[0],dp2[noOfStages]+exitTimes[1]));

         int temp=noOfStages;
        int currLine=0;
        if(ans==dp1[noOfStages]+exitTimes[0])
        {
            System.out.println("1");
            currLine=1;
        }
        else
        {
            System.out.println("2");
            currLine=2;
        }


        while (noOfStages>1)
        {
            if(currLine==2)
            {
                if(dp2[noOfStages]==(dp1[noOfStages-1]+shiftingTimes[0][noOfStages]+timeAtStages[1][noOfStages]))
                {
                    currLine=1;
                    System.out.println("1");
                }
                else
                {
                    currLine=2;
                    System.out.println("2");
                }
            }
            else
            {
                if(dp1[noOfStages]==(dp2[noOfStages-1]+shiftingTimes[1][noOfStages]+timeAtStages[0][noOfStages]))
                {
                    currLine=2;
                    System.out.println("2");
                }
                else
                {
                    currLine=1;
                    System.out.println("1");
                }
            }
            noOfStages--;
        }

