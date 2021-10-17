class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        
        solve(s,result,new ArrayList<>(),0);
        
        return result;
        
    }
    
    public void solve(String s, List<List<String>> result, List<String> temp, int i){
        
        if(i == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int ind = i; ind<s.length(); ind++){
            
            if(isPalindrome(s,i,ind)){
                temp.add(s.substring(i,ind+1));
                solve(s,result,temp,ind+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    
    
    boolean isPalindrome(String S, int low, int high){
        
        while(low<=high){
            if(S.charAt(low) != S.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}