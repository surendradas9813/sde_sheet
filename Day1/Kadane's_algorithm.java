    public int maxSubArray(int[] nums) {
        
// //         BruteForce --> O(n^2) time complexity and O(1) space complexity
        
        
//         int result = Integer.MIN_VALUE;
        
//         for(int i=0; i<nums.length; i++){
            
//             int sum = 0;
            
//             for(int j=i; j<nums.length; j++){
//                 sum += nums[j];
//                 result = Math.max(result,sum);
//             }
            
//         }
//         return result;
        
        
        // Optimal Approach --> Kadane's Algo time complexit --> O(n) time and O(1) space complexity
            
            int result = Integer.MIN_VALUE;
            int maxEndingHere = 0;
        
            for(int i=0; i<nums.length; i++){
//                 we are checking whether we can obtain max by adding previous sum or the current element itself will be max neglecting the previos prefix sum;
                maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]);
                result = Math.max(result,maxEndingHere);
            }
            
            return result;
    }