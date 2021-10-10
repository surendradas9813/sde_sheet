class Solution {
    public int[] twoSum(int[] nums, int target) {
        
//         //Bruteforce-> O(n^2) time complexity and O(1) space complexity
//         // Idea is to traverse the array with extra inner traversal and check 
        
//         int n = nums.length;
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 if(nums[i]+nums[j] == target)
//                     return new int[]{i,j};
//             }
//         }
//         return new int[]{-1,-1};
        
        
        // Optimal ---> O(N) time complexity and O(N) space complexity
        // Idea is to use HashMap --> we go on adding in the hashmap if (target-num[i]) is not found
        // for eg 2 7 11 15 --->  for 2 --> (2,0), for 7 --> we check (9-7) =2 which is already in hashmap so take that index and current index
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{hm.get(target-nums[i]),i};
            }
            else
                hm.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}