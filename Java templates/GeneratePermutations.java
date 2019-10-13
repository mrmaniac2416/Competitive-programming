 static void generatePermuatations(int arr[]) {
        TreeMap<Integer, Integer> countMap = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!countMap.containsKey(arr[i])) {
                countMap.put(arr[i], 1);
            } else {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            }
        }

        int countArr[] = new int[arr.length];
        int inpArr[] = new int[arr.length];

        int index = 0;
        for (int key : countMap.keySet()) {
            countArr[index] = countMap.get(key);
            inpArr[index] = key;
            index++;
        }
        int result[] = new int[arr.length];
        permutUtil(inpArr,countArr,result,0);
    }

   static void permutUtil(int inpArr[],int countArr[],int result[],int level)
    {
        if(level==inpArr.length)
        {
            printArr(result);
            return;
        }
        for(int i=0;i<inpArr.length;i++)
        {
            if(countArr[i]==0)
                continue;

            result[level]=inpArr[i];
            countArr[i]--;
            permutUtil(inpArr,countArr,result,level+1);
            countArr[i]++;
        }
    }

   static void printArr(int []arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ") ;
        System.out.println();
    }