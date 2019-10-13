  static void mergeSort(int a[])
    {
        if(a.length<2)
            return;
        int mid=a.length/2;
        int leftArray[]=new int[mid];
        int rightArray[]=new int[a.length-mid];
        for(int i=0;i<mid;i++)
            leftArray[i]=a[i];
        for(int i=mid;i<a.length;i++)
            rightArray[i-mid]=a[i];
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray,rightArray,a);
    }

    static void merge(int leftArray[],int rightArray[],int a[])
    {
        int l1=leftArray.length;
        int l2=rightArray.length;
        int i=0;
        int j=0;
        int k=0;
        while (i<l1 && j<l2)
        {
            if(leftArray[i]<rightArray[j])
            {
                a[k]=leftArray[i];
                k++;
                i++;
            }
            else
            {
                a[k]=rightArray[j];
                k++;
                j++;
            }
        }
        while (i<l1)
        {
            a[k]=leftArray[i];
            k++;
            i++;
        }
        while (j<l2)
        {
            a[k]=rightArray[j];
            k++;
            j++;
        }
    }
