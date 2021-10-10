class Solution {
    public int subarraySum(int[] nums, int k) {
        
        
        // same logic as of count of subarray with xor equal to target
        
        //Brute force -> O(n^2) time and O(1) space
        
//         int count = 0;
        
//         int n = nums.length;
        
//         for(int i=0; i<n; i++){
//             int sum = 0;
//             for(int j=i; j<n; j++){
//                 sum += nums[j];
                
//                 if(sum == k) count++;
//             }
//         }
//         return count;
        
        
        
        // Optimal solutin ---> O(n) time and O(n) space
        // Idea is to use HashMap as like count of subarray with given xor question
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            if(sum == k) count++;
            
            if(hm.containsKey(sum-k))
                count += hm.get(sum-k);
            
            hm.put(sum,hm.getOrDefault(sum,0)+1);
            
            
        }
        return count;
    }
}