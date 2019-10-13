  static void countingSort(int []arr,int n,int place)
    {
            int countArray[]=new int[10];
             for(int i=0;i<n;i++)
             {
                 countArray[(arr[i]/place)%10]++;
             }
//             debug(countArray);
             for(int i=1;i<countArray.length;i++)
                 countArray[i]+=countArray[i-1];
        int output[]=new int[n];
//        debug(countArray);

        for(int i=n-1;i>=0;i--)//to do stable sort..
        {
            output[countArray[(arr[i]/place)%10]-1]=arr[i];
            countArray[(arr[i]/place)%10]--;
        }
        for(int i=0;i<n;i++)
            arr[i]=output[i];
//        debug(output);

    }

    static void radixSort(int []arr,int n,int max)
    {
        int mul=1;

        while (max/mul>0)
        {
            countingSort(arr,n,mul);
            mul=mul*10;
        }
    }