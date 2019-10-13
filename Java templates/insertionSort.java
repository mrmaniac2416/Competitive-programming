 static void insertionSort(int a[],int n){
          for(int i=1;i<n;i++)
          {
              int value=a[i];
              int startIndex=i;
              while (startIndex>0 && a[startIndex-1] > a[startIndex])
              {
                swap(a,startIndex-1,startIndex);
                startIndex--;
              }
          }
    }

    static void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
