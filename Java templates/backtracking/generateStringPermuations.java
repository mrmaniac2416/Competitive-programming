 static void generatePermutation(String s,int depth,int countArr[],char result[])
    {

        if(depth==s.length())
        {
            debug(result);
            return;
        }
        for(int i=0;i<countArr.length;i++)
        {
            if(countArr[i]!=0)
            {
                countArr[i]--;
                result[depth]=(char)(97+i);
                generatePermutation(s,depth+1,countArr,result);
                countArr[i]++;

            }
        }
    }