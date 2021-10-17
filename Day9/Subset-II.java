class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        solve(nums,result,0,new ArrayList<>());
        return result;
        
    }
    
    public void solve(int nums[], List<List<Integer>> result, int i, List<Integer> temp){
        result.add(new ArrayList<>(temp));
        
        for(int ind=i; ind<nums.length; ind++){
           
            if(ind == i || (ind>i && nums[ind-1] != nums[ind])){
                temp.add(nums[ind]);
                solve(nums,result,ind+1,temp);
                
                temp.remove(temp.size()-1);
            }
            
        }
    }
}