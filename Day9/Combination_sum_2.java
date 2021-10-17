class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        List<List<Integer>> result =new ArrayList<>();
        
        solve(candidates,result, new ArrayList<>(),target,0);
        
        return result;
        
    }
    
    public void solve(int arr[], List<List<Integer>> result, List<Integer> temp, int remain, int ind){
        
        if(remain < 0) return;
        
        else if(remain == 0) result.add(new ArrayList<>(temp));
        
        for(int i=ind; i<arr.length; i++){
            if( i== ind || (i>ind && arr[i] != arr[i-1])){
                temp.add(arr[i]);
                solve(arr,result,temp,remain-arr[i],i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}