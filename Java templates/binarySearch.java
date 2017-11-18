static int binarySearch(int a[],int toBeFound)
    {
        int start=0;
        int end=a.length-1;
        int mid=(start+end)/2;
        while (start<=end)
        {
            mid=(start+end)/2;
            if(a[mid]==toBeFound)
                return mid;
            else if(a[mid]<toBeFound)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return -1;
    }


 static int binarySearch(int a[],int low,int high,int toBeFound)
    {
        if(low>high)
            return -1;
        int mid=(low+high)/2;
        if(a[mid]==toBeFound)
            return mid;
        else if(a[mid]<toBeFound)
            return binarySearch(a,mid+1,high,toBeFound);
        else
            return binarySearch(a,low,mid-1,toBeFound);
    }



    static int binarySearchFirstOccurence(int a[],int toBeFound)
    {
        int low=0;
        int high=(a.length-1);
        int result=-1;
        while (low<=high)
        {
            int mid=(low+high)/2;
            if(a[mid]==toBeFound)
            {
                high=mid-1;
                result=mid;
            }
            else if(a[mid]<toBeFound)
            {
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return result;
    }


    static int binarySearchLastOccurence(int a[],int toBeFound)
    {
        int low=0;
        int high=(a.length-1);
        int result=-1;
        while (low<=high)
        {
            int mid=(low+high)/2;
            if(a[mid]==toBeFound)
            {
                low=mid+1;
                result=mid;
            }
            else if(a[mid]<toBeFound)
            {
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return result;
    }



     static int noOfOccurences(int a[],int toBeSearched)
    {
        int firstOccurence=binarySearchFirstOccurence(a,toBeSearched);
        int lastOccurence=binarySearchLastOccurence(a,toBeSearched);
        if(firstOccurence!=-1 && lastOccurence!=-1)
            return lastOccurence-firstOccurence+1;
        return -1;
    }



      static int noOfRotations(int a[],int low,int high)
    {
        int mid=(low+high)/2;
        int next=(mid+1)%a.length;
        int prev=(mid+a.length-1)%a.length;
        if(a[low]<=a[high])
        {
             return low;
        }
       else if(a[mid]<=a[next] && a[mid]<=a[prev])
        {
            return mid;
        }
        else if(a[mid]<=a[high])
        {
            return noOfRotations(a,low,mid-1);
        }
        else{
            return noOfRotations(a,mid+1,high);
        }
    }


     static int binarySearchInCircularSortedArray(int a[],int toBeFound)
    {
        int low=0;
        int high=a.length-1;
        int mid=(low+high)/2;
        while (low<=high)
        {
            
             mid=(low+high)/2;
            if(a[mid]==toBeFound)
                return mid;
            if(a[mid]<=a[high])  //right is sorted
            {
                if(toBeFound>a[mid]  && toBeFound<=a[high])
                {
                    low=mid+1; //search in right half
                }
                else
                {
                    high=mid-1; //search in left half
                }
            }
            else  //left is sorted
            {
                if(toBeFound>=a[low] && toBeFound<a[mid])
                {
                    high=mid-1; //search in left half
                }
                else
                {
                    low=mid+1;
                }
            }
        }
        return -1;
    }