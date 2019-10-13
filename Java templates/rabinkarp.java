//define mod and prime in code..

 static int calculateHash(String s,int start,int end)
    {
        int ans=0;
        int index=0;
        for(int i=start;i<=end;i++)
        {
            ans=ans+(s.charAt(i)*(int)Math.pow(prime,index))%mod;
            ans=ans%mod;
            index++;
        }
        return ans;
    }

    static int rehash(String s,int start1,int end1,int start2,int end2,int hash1,int patternSize)
    {
        int newHash=hash1-s.charAt(start1);
        newHash=newHash/prime;
        newHash=newHash+(s.charAt(end2)*(int)Math.pow(prime,patternSize-1))%mod;
        newHash=newHash%mod;
        return newHash;
    }
    static boolean isEqual(String s1,int start1,int end1,String s2,int start2,int end2,int patternSize)
    {
        for(int i=0;i<patternSize;i++)
        {
            if(s1.charAt(start1+i)!=s2.charAt(start2+i))
                return false;
        }
        return true;
    }

    static  ArrayList<Integer> matchedIndexes(String pattern,String inp) {
        int patternLength = pattern.length();
        int inpLength = inp.length();
        ArrayList<Integer> ans = new ArrayList<>();
        int hashPattern=calculateHash(pattern,0,patternLength-1);
        int hashInitial=calculateHash(inp,0,patternLength-1);
        for (int i = 0; i < inpLength - patternLength + 1; i++)
        {
            if(i==0)
            {
                if(hashInitial==hashPattern)
                {
                    if(isEqual(pattern,0,patternLength-1,inp,0,patternLength-1,patternLength))
                        ans.add(i);
                }
            }
            else
            {
                hashInitial=rehash(inp,i-1,i+patternLength-2,i,i+patternLength-1,hashInitial,patternLength);
                if(hashInitial==hashPattern)
                {
                    if(isEqual(pattern,0,patternLength-1,inp,i,i+patternLength-1,patternLength))
                        ans.add(i);
                }
            }
        }
        return ans;
    }