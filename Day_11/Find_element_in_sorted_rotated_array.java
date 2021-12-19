

2 variations of question  ----> i) search in the array with no duplicates
				ii) search in the array which may contain duplicates.






i)
class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target) return mid;
            
            //left part of the array is sorted
            else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]) // if the target lies in between the sorted array
                    high = mid-1;
                else
                    low = mid+1;
            }
            
            //right part of the array is sorted
            else{
                if(target > nums[mid] && target <= nums[high])  //if the target lies in between the sorted array
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}





ii)
class Solution {
    public boolean search(int[] nums, int target) {
        
         
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target) return true;
            
            //left part of the array is sorted
            else if(nums[low] < nums[mid]){
                if(target >= nums[low] && target < nums[mid]) // if the target lies in between the sorted array
                    high = mid-1;
                else
                    low = mid+1;
            }
            
            
            //to avoid duplicates
            else if(nums[low] == nums[mid])
                low++;
            
            //right part of the array is sorted
            else{
                if(target > nums[mid] && target <= nums[high])  //if the target lies in between the sorted array
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return false;
        
    }
}