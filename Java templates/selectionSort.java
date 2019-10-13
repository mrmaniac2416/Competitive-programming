  static void selectionSort(int a[],int n)
    {
        int startIndex=0;
        while (startIndex<(n-1))
        {
            int minNumber=a[startIndex];
            int minIndex=startIndex;
            for(int j=startIndex+1;j<n;j++)
            {
                if(a[j]<minNumber)
                {
                    minNumber=a[j];
                    minIndex=j;
                }
            }
            swap(a,startIndex,minIndex);
            startIndex++;
        }
    }
    static void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
