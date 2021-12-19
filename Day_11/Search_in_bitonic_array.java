public class Solution {
    public int solve(int[] A, int B) {

        int maxEleInd = findMaxInBitonic(A);

        if(A[maxEleInd] == B) return maxEleInd;

        int halfascenresult = ascendingBinarySearch(0,maxEleInd-1,A,B);
        int halfdescenresult = descendingBinarySerach(maxEleInd+1,A.length-1,A,B);

        if(halfascenresult != -1)
            return halfascenresult;
        else if(halfdescenresult != -1)
            return halfdescenresult;
        else
        return -1;




    }

    public int findMaxInBitonic(int arr[]){


        //logic is to find bitonic point(max in bitonic array) and run two binary search from left to bitonic point and from bitonic point to right pint

        int n = arr.length;

        if(n==0) return 0;

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == n-1 || arr[mid] > arr[mid+1]))
                return mid;

            else if(mid > 0 && arr[mid-1] > arr[mid])
                high = mid-1;

            else
                low = mid+1;
        }
        return -1;
    }

    public int ascendingBinarySearch(int low,int high, int arr[], int key){

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == key)
                return mid;
            else if(arr[mid]>key)
                high = mid-1;
            else
                low =  mid+1;
        }
        return -1;
    }

    public int descendingBinarySerach(int low, int high, int arr[], int key){
            while(low <= high){
                int mid = low + (high-low)/2;

                if(arr[mid] == key)
                    return mid;
                
                else if(arr[mid]>key)
                    low = mid+1;
                else
                    high = mid-1;
            }

            return -1;
    }
}
