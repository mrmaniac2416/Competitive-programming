 static void quickSort(int a[],int start,int end)
    {
        if(start>=end)
            return;
        int partionIndex=partition(a,start,end);
        quickSort(a,start,partionIndex-1);
        quickSort(a,partionIndex+1,end);
    }

    static int partition(int a[],int start,int end)
    {
        int pIndex=start;
        int pivot=a[end];
        for(int i=start;i<=(end-1);i++)
        {
            if(a[i]<=pivot)
            {
                swap(a,i,pIndex);
                pIndex++;
            }
        }
        swap(a,pIndex,end);
        return pIndex;
    }
    static void swap(int a[],int i1,int i2)
    {
        int temp=a[i1];
        a[i1]=a[i2];
        a[i2]=temp;
    }