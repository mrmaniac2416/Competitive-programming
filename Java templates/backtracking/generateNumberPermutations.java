static   void generatePermutations(ArrayList<Integer> A,int depth,TreeMap<Integer,Integer> countMap,ArrayList<Integer> result,ArrayList<ArrayList<Integer>> ans)
        {
            debug(countMap,depth,result,ans);
            if(depth==A.size())
            {
                ArrayList<Integer> temp=new ArrayList<>();
                for(int a : result)
                    temp.add(a);
                ans.add(temp);
                return;
            }

            for(int num : countMap.keySet())
            {
                if(countMap.get(num)!=0)
                {
                    result.set(depth,num);
                    countMap.put(num,countMap.get(num)-1);
                    generatePermutations(A,depth+1,countMap,result,ans);
                    countMap.put(num,countMap.get(num)+1);
                }

            }
        }