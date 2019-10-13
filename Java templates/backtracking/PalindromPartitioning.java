boolean isPalindrome(String s, int l, int r)
    {
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
                 return false;
            l++;
            r--;
        }
        return true;
    }
    
    void generatePartitions(String s, int l, int r , List<String> partition,List<List<String>> partitions)
    {
        if(l==s.length())
        {
            partitions.add(new ArrayList<>(partition));
            return;
        }
        
       
            for(int j=l;j<=r;j++)
            {
                if(isPalindrome(s,l,j))
                {
                    partition.add(s.substring(l,j+1));
                    generatePartitions(s,j+1,r,partition,partitions);
                    partition.remove(partition.size()-1);
                }
            }
        
    }