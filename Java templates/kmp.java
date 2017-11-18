static ArrayList<Integer> findPattern(String pattern,String text,int prefixArray[])
  {
      int patternPointer=0;
      ArrayList<Integer> ans=new ArrayList<>();
      int i=0;
      while(i<text.length())
      {
          if(text.charAt(i)==pattern.charAt(patternPointer))
          {
              patternPointer++;
              if(patternPointer==pattern.length())
              {
                  ans.add(i);
                  patternPointer = prefixArray[patternPointer-1];
              }
              else
              {
                  i++;
              }
          }
          else
          {
              if(patternPointer!=0) {
                  patternPointer = prefixArray[patternPointer - 1];
              }
              else
              {
                  i++;
              }
          }

      }
      return ans;

  }
  static   int []buildPrefixArray(String pattern)
    {
        int prefixArray[]=new int[pattern.length()];
        int i=1;
        int j=0;
        while(i<pattern.length())
        {
            if(pattern.charAt(j)!=pattern.charAt(i))
            {
                while (pattern.charAt(j)!=pattern.charAt(i) && j!=0)
                {
                    j--;
                    j=prefixArray[j];
                }
                if(pattern.charAt(j)==pattern.charAt(i))
                {
                    prefixArray[i]=j+1;
                    i++;
                    j++;
                }
                else
                {
                    prefixArray[i]=0;
                    i++;
                }
            }
            else
            {
                prefixArray[i]=j+1;
                i++;
                j++;
            }
        }
        return prefixArray;
    }
