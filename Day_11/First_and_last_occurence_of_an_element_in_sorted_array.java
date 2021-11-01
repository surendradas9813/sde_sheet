class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0) return new int[]{-1,-1};
        
        int firstOccurence = firstOccur(nums,target);
        
        // if element is not found so return instead for running next last Occur function.
        if(firstOccurence == -1) return new int[]{-1,-1};
        
        int lastOccurence = lastOccur(nums,target);
        
        return new int[]{firstOccurence,lastOccurence};
    }
    
    
    public int firstOccur(int nums[], int target){
        int low = 0;
        int high = nums.length-1;
        
        int res = -1;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                high =  mid-1;         //after find the target to find the first occurence we left of the found index after updating the res
                res = mid;
            }
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return res;
    }
    
    public int lastOccur(int nums[], int target){
        int low = 0;
        int high = nums.length-1;
        
        int res = -1;
        
        while(low <= high){
            int  mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                low = mid+1;      //after finding the target to find the last occurence we move right of the found index after updating th res
                res = mid;
            }
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return res;
    }
}