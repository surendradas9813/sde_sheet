class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        //Bruteforce --> sort the array and use 3 pointer and binary search --> O(N^3logN) time and O(1) space
        // we can use HashSet to remove the duplicates.
        
        
        //Optimal solution --> O(N^3) time and O(1) space
        // Idea is to sort the array and place two index i and j from the start and apply 2 pointer approach on right half to find the target-nums[i]-nums[j]
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for(int i=0; i<n-3; i++){
            if( i == 0 || (nums[i] != nums[i-1])){ // To avoid duplicates
                for(int j=i+1; j<n-2; j++){
                    if(j == i+1 || (nums[j] != nums[j-1])){ // To avoid duplicates
                        
                        // two pointer approach
                        
                        int start = j+1;
                        int end = nums.length-1;
                        
                        int sum = target-nums[i]-nums[j];
                        
                        while(start<end){
                            
                            if(nums[start] + nums[end] == sum){
                                
                                result.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                                
                                while(start < end && nums[start] == nums[start+1]) start++; //To avoid duplicates
                                while(start < end && nums[end] == nums[end-1]) end--;
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
            }
        }
        
        return result;
    }
}