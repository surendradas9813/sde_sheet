class Solution {
    public void nextPermutation(int[] nums) {
        
        
        // Brute force-->N! factorial time find all the permutation and store the and sort them. After that traverse and
        // print the permutation just after the given permutation is matched.
        
        
        // Optimal Approach--> O(n) time and O(1) space complexity       
        // idea is to find the break point where the array breaks its high point from the last like for
        //1 4 5 3 2 -- > we find the index of 4 where the array 1 3 | 5 4 2
        // after finding breakpoint we need change the prefix i.e 1 4 particular the index at 3 value
        // so we find the smallest from right i.e greater than 3 .ie 4 and swap it because we have to make next permutation also 4 and 5 can be both but we take least because we want the next  1 4 | 5 3 2
        // after this we need reverse the right part because we want to be the minimul. o/p 1 4 2 3 5
        
        
        
        
        int n = nums.length;
        
        if(n <= 1) return;
        
        int i = n-2;
        
        
        while(i>=0 && nums[i] >= nums[i+1]) i--;
        
        if(i>=0){
            int j = n-1;
            
            while(nums[j] <= nums[i]) j--;
            
            // swapping the indexes value
            
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
        }
        
        reverse(nums,i+1,n-1);
        
    }
    
    public void reverse(int nums[], int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; 
            end--;
        }
    }
    
    
}