    public void sortColors(int[] nums) {
        
//         basic idea is to use 3 pointers and when 0 or 2 is encountered swapping is done and we try to keep 1 in between
        
        int start = 0;
        int end = nums.length-1;
        
        int mid = 0;
        
        int swap = 0;
        
        while(mid <= end){
            
            switch(nums[mid]){
                case 0:
                    swap = nums[mid];
                    nums[mid] = nums[start];
                    nums[start] = swap;
                    start++;
                    mid++;
                    break;
                    
                case 1:
                    mid++;
                    break;
                case 2:
                    swap = nums[mid];
                    nums[mid] = nums[end];
                    nums[end] = swap;
                    end--;
                    
            }
        }
    }