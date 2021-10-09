class Solution {
    public int majorityElement(int[] nums) {     
        
//         //Bruteforce --> O(nlogn) time complexity and O(n) space complexity;
        
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         for(int num: nums){
//             hm.put(num,hm.getOrDefault(num,0)+1);
//         }
        
//         for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
//             if(entry.getValue() > nums.length/2)
//                 return entry.getKey();
//         }
//         return -1;
        
        
        //Optimal solution--> O(n) time complexity and O(1) space complexity
        // Algorith used is Boyer Moree Majority Voting algorithm
        // Idea is 2 2 1 1 1 2 2 --> 2 2 1 1 | 1 2 | 2 where | is break point where cnt is zero;
        // since the count should >n/2 so while traversing the elements gets cancelled out and remaining is ans;
        
        int ele = 0;
        int cnt = 0;
        
        for(int num: nums){
            
            if(cnt == 0)
                ele = num;
            
            if(ele == num)
                cnt++;
            else
                cnt--;
        }
        return ele;
    }
}