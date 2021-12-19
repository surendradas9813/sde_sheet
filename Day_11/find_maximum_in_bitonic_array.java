class Solution {
    int findMaximum(int[] arr, int n) {
        
        
    //     //O(n) time complexity using linear traversal through array.
    //     int ans = arr[0];
       
    //   for(int i=1; i<n; i++){
    //       if(arr[i] > arr[i-1])
    //         ans = arr[i];
    //   }
       
    //   return ans;
       
       
       // O(logn) solution using binary search
       //Logic is same as of the find peak element in the array.
       
       
       int low = 0;
       int high = n-1;
       
       while(low<=high){
           
           int mid = low + (high-low)/2;
           
           if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == n-1 || arr[mid] > arr[mid+1]))
                return arr[mid];
                
            else if(mid>0 && arr[mid-1]>arr[mid])
                high = mid-1;
                
            else
                low = mid+1;
       }
       
       return -1;
    }
}