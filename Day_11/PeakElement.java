class Solution {
    public int findPeakElement(int[] arr) {
        
        
        
//         //Approach 1 ---> O(n) time complexity
        
//         int peak = 0;
        
//         for(int i=1; i<nums.length; i++){
//             if(nums[i] > nums[i-1])
//                 peak = i;
//         }
//         return peak;
        
        
        //Approach 2 ---> O(logn) solution using binary search
            
        int n = arr.length;
        
        int low = 0;
        int high = n-1;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == n-1 || arr[mid] > arr[mid+1])) //checking if the mid is greater than its neighbour
                return mid;
            
            else if(mid > 0 && arr[mid-1] > arr[mid]) //moving to left if left neigher is greater
                high = mid-1;
            else                                      //moving to right if right neighbour is greater
                low = mid+1;
        }
        
        return -1;      
    }
}