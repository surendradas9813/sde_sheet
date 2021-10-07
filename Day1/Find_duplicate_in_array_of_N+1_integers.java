    public int findDuplicate(int[] nums) {
        
        //Brute force - O(nlogn) solution
        // sort the array and check the adjacent elements
        
        
        //Approach 2 -  O(n) time & O(n) space
        // use HashSet or temp array and update frequency and check which one is repeating
        
        
      //optiomal solution --> O(n) time using slow and fast pointer find starting point of cycle as in linkedlist question
        
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        
        fast = nums[0];
        
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }