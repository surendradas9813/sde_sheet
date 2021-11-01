class Solution {
    public boolean check(int[] nums) {
        
        
        //O(n) --> time complexity and O(1)--> space complexity
        
        //Idea is to observe the rotated array. In sorted rotated array if we compare adjacent element then there will be only one 
        // case where the first element will be larger than second one. If there is more case then it is not rated sorted array
        // if sorted array and not rotated is taken then also there will be once case i.e. last element will be larger than the first element at index 0.

        int k = 0;
        int n = nums.length;
        
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > nums[(i+1)%n])   //last element should be compared with first element.
                k++;
            if(k>1)
                return false;
        }
        return true;
        
    }
}