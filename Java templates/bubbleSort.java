  static void bubbleSort(int a[],int n)
    {
        boolean isSorted;

        for(int k=1;k<=(n-1);k++)
        {
            isSorted=true;
            for(int i=0;i<=n-k-1;i++)
            {
                if(a[i]>a[i+1])
                {
                    swap(a,i,i+1);
                    isSorted=false;
                }
            }
            if(isSorted)
                break;
        }
    }
    static void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }