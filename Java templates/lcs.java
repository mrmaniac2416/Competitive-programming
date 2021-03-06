 String s1=sc.nextLine();
        String s2=sc.nextLine();
        int lcs[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length();i++)
            lcs[i][0]=0;
        for(int i=0;i<=s2.length();i++)
            lcs[0][i]=0;

        for(int i=1;i<=s1.length();i++)
        {
            for(int j=1;j<=s2.length();j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    lcs[i][j]=lcs[i-1][j-1]+1;
                else
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        debug(lcs);
          out.println(lcs[s1.length()][s2.length()]);        


        Stack<Character> s=new Stack<>();
        int rowPointer=s1.length();
        int colPointer=s2.length();
        while (rowPointer>0 && colPointer>0)
        {
            debug(rowPointer,colPointer);
            if(lcs[rowPointer][colPointer]==(lcs[rowPointer-1][colPointer-1]+1))
            {
                s.add(s1.charAt(rowPointer-1));
                rowPointer--;
                colPointer--;
            }
            else if(lcs[rowPointer][colPointer]==lcs[rowPointer-1][colPointer])
                rowPointer--;
            else
                colPointer--;
        }
        debug(s);