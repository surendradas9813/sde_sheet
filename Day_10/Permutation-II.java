class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        boolean isTaken[] = new boolean[nums.length];
        
        solve(nums,result,isTaken, new ArrayList<>());
        
        return result;
        
    }
    
    
    public void solve(int nums[], List<List<Integer>> result, boolean isTaken[],List<Integer> temp){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            
            if(isTaken[i] == false){
                
                if(i>0 && nums[i] == nums[i-1] && isTaken[i-1] == true) continue;  //try for eg 1 1 2 o/p- 112 121 211
                    isTaken[i] = true;
                    temp.add(nums[i]);
                    
                    solve(nums,result,isTaken,temp);
                    
                    isTaken[i] = false;
                    temp.remove(temp.size()-1);
                
                
            }
            
                
                
            
        }
    }
}