//3 variations are there ---> no of times a sorted array of distinct element is rotated
                         ---> find minimum element in sorted rotated array of distinct element
                         ---> find minimum element in sorted rotated array where duplicates may be present




1st variation
class Solution {
    int findKRotation(int arr[], int n) {
        
        //O(logn) time complexity
        //Idea is to find the index of minimum element in the array as it doesnot contain duplicates
    
        int low = 0;
        int high = n-1;
        
        
        
        //at the ene low and high will both converge to answer
        while(low< high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] > arr[high])   // arr[mid] is larger than high that means there will be atleast one element on the right that will contribtute the answer
                low = mid+1;    //mid will not be required as already smaller number is present on the right side
            else
                high = mid;     //the answer is on left side and mid too might be answer so we move high = mid;
        }
        return low;  //we can return low or high as both will point to the answer at last.
    }
}




2nd variation

// we can use above logic and code. At last we should return the number instead of index



//3rd variation
class Solution {
    public int findMin(int[] nums) {

	//Idea is almost same just we need to handle the case where mid and high may be duplicate
        
         int low = 0;
        int high = nums.length-1;
        
        while(low<high){
            
            int mid = low +(high-low)/2;
            
            if(nums[mid] > nums[high])
                low = mid+1;
            
            else if(nums[mid]<nums[high])
                high = mid;
            else
                high--;   // if mid and high are same we reduce the upper bound
        }
        return nums[high];
    }
}

