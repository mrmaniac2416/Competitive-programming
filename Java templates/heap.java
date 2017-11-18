   static void maxHeapify(int []arr,int index,int size)
   {
       int left=2*index;
       int right=2*index+1;
       int largest=index;
       if(left<=size && arr[index]<arr[left])
       {
           largest=left;
       }
       if(right<=size && arr[largest] < arr[right])
       {
           largest=right;
       }
       if(largest!=index)
       {
           swap(arr,index,largest);
           maxHeapify(arr,largest,size);
       }

   }

  
   static void swap(int []arr,int a,int b)
   {
       int temp=arr[a];
       arr[a]=arr[b];
       arr[b]=temp;
   }

   static void buildMaxHeap(int []arr,int size)
   {
       for(int i=size/2;i>=1;i--)
           maxHeapify(arr,i,size);
   }

  static void heapSort(int []arr,int size)
   {
       int n=size;
       for (int i=n;i>=2;i--)
       {
           swap(arr,1,i);
           size--;
           maxHeapify(arr,1,size);
       }
   }

  static void printHeap(int arr[])
   {
       for(int i=1;i<arr.length;i++)
           System.out.print(arr[i] + " ");
   }