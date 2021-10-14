class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // Brute force --> O(n3) time and O(1) space
        // idea is to run three nested loops and store the result in the list
        
        //Another approach --> O(n^2logn) time and O(1) space
        // Idea is to sort the array and use two nested loops and find the next element using binary search
        
        //Optimal Approach --> O(n2) time and O(1) space
        // Idea is to sort the array and traverse the array and for each traversal apply 2 pointer approach 
        
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        for(int i=0; i<n-2; i++){
            
            if(i == 0 || (i>0 && nums[i] != nums[i-1])){
                
                int start = i+1;
                int end = n-1;
                
                int sum = 0 - nums[i];
                
                while(start<end){
                    if(nums[start]+nums[end] == sum){
                        result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        
                        while(start<end && nums[start] == nums[start+1]) start++;
                        while(start<end && nums[end] == nums[end-1]) end--;
                        
                        start++;
                        end--;
                    }
                    else if(nums[start]+nums[end] > sum)
                        end--;
                    
                    else
                        start++;
                }
            }
        }
        return result;
    }
}