class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates,0,result,new ArrayList<>(), target);
        
        return result;
        
    }
    
    public void solve(int arr[], int ind, List<List<Integer>> result, List<Integer> temp, int remain){
        if(remain < 0) return;
        
        else if(remain == 0) result.add(new ArrayList<>(temp));
        
        else{
            for(int i = ind ; i<arr.length; i++){
                temp.add(arr[i]);
                solve(arr,i,result,temp,remain-arr[i]);  // here we are avoiding i+1 because we are allowed to take same number as many times
                temp.remove(temp.size()-1);
            }
        }
    }
}