class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
//         //Bruteforce is to use HashMap --> O(nlogn) time complexity O(n) space
        
//         List<Integer> result = new ArrayList<>();
        
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         for(int num: nums){
//             hm.put(num,hm.getOrDefault(num,0)+1);
//         }
        
//         for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
//             if(entry.getValue()>nums.length/3)
//                 result.add(entry.getKey());
//         }
//         return result;
        
        
        //Optimal solution --> Moore Voting algorithm -> O(n) time complexity and O(1) space
        // Atmax you can have two majority element and at min you can have zero majority element
        
        // Idea is to use two variable and follow the concept of majority I problem 
        // 1 1 1 3 3 2 2 2 --> keep on count 1 with cnt1 and 3 with cnt2 , when the pointer reaches to 2 then we 
        // we start decreasing cancel out the cnt, at last we remain with 1 1's and 1 2's which is the answer;
        // Note at last we have to traverse and check whether the count is more than n/2 because we are not sure
        
        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = -1;
        int ele2 = -1;
        
        List<Integer> result = new ArrayList<>();
        
        for(int num: nums){
            
            if(ele1 == num) cnt1++;
            
            else if(ele2 == num) cnt2++;
            
            else if(cnt1 == 0){
                ele1 = num;
                cnt1 = 1;
            }
            else if(cnt2 == 0){
                ele2 = num;
                cnt2 = 1;
            }
            else{
                cnt1--;
                cnt2--;
            }
            
        }
        
        int count1 = 0;
        int count2 = 0;
        
        for(int num: nums){
            if(num == ele1)
                count1++;
             if(num == ele2)  // Note use else if because the code will fail for cases like -1 -1 -1 expected -1 got -1 -1
                 
                count2++;
        }
        
        if(count1 > nums.length/3) result.add(ele1);
        if(count2 > nums.length/3) result.add(ele2);
        
        return result;
    }
}