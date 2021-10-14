class Solution {
    public int removeDuplicates(int[] nums) {
        
        //Optimal Approach ---> O(N) time and O(1) space
        
        int low = 0;
        int high = 1;
        
        while(high < nums.length){
            
            if(nums[high] == nums[high-1])
                high++;
            
            else
                nums[++low] = nums[high++];
        }
        return low+1;
    }
}