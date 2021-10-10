class Solution {
    public int longestConsecutive(int[] nums) {
        
//         //Bruteforce--> O(n^3) time complexity and O(1) space complexity
//         // Idea is to use three nested loops and the inner most loop checks the increasing number is present or not 
//         // for each of the numbers in the array
        
//         int n = nums.length;
//         if(n == 0) return 0;
        
//         int longest_streak = 0;
        
//         for(int i=0; i<n; i++){
            
//             int current_num = nums[i];
//             int current_streak = 1;
            
//             while(find(nums,current_num+1)){
//                 current_num++;
//                 current_streak++;
//             }
            
//             longest_streak = Math.max(current_streak,longest_streak);
//         }
        
//         return longest_streak;
//     }
    
//     public boolean find(int nums[], int target){
        
//         for(int num: nums)
//             if(num == target)
//                 return true;
//         return false;
        
        
        
        
//         //Another Approach --> O(nlogn) time complexity and O(1) space complexity
//         // Idea is to sort the array and check consecutively the increasing subsequence;
        
//         if(nums.length == 0) return 0;
        
//         Arrays.sort(nums);
//         int longest_streak = 1;
//         int current_streak = 1;
        
//         for(int i=1; i<nums.length; i++){
            
//             if(nums[i] != nums[i-1]){  // to avoid duplicates like for eg 1 2 0 1 test case
            
//                 if(nums[i]-1 == nums[i-1])
//                     current_streak++;
//                 else{
//                     longest_streak = Math.max(longest_streak,current_streak);
//                     current_streak = 1;
//                 }   
//             }
//         }
//         return Math.max(current_streak,longest_streak);
        
        
        
        //Optimal solution ---> O(n) time complexity and O(1) space complexity
        // Idea is to store all numbers into hashSet 
        // traverse through array and check if num-1 is not present in hashset then it must be starting point of 
        // increasing subsequence so a while loop is used again to check at max how much the sequence continues/
        // and hence we update longest increasing subsequence and check for other elements too.
        
        
        int n = nums.length;
        if(n == 0) return 0;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int num: nums){
            hs.add(num);
        }
        
        int longest_streak = 0;
        
        for(int num: nums){
            
            if(hs.contains(num-1) == false){
                
                int current_streak = 1;
                int current_num = num+1;
                
                while(hs.contains(current_num)){ //Although inner loop is present but the total time will O(n+n) max
                    current_streak++;
                    current_num++;
                }
                
                longest_streak = Math.max(current_streak,longest_streak);
            }
        }
        return longest_streak;
    }
}