
//APPROACH 1

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        
        //Time Complexity ----> O(n!Xn) time and O(n) space
        //Idea if there are n elements then there will be n! permutations.
        //So we take a result and isTaken boolean array and perform the recursion
        
        //for eg [1,2,3] ----->                                1,2,3         result=[] taken=[]
        //                                                     /                         |                        \    using for loop we can select 3 elements at this moment
        //                                       res=[1] taken[1]                      res[2] taken[2]           res[3] taken[3]
        //                             /                 |                \                      /|\                  /|\
        //                  1 cant be taken     res=[1,2]  taken[1,2]     res[1,3]taken[1,3]
        //                  as it is already          /|\                        /|\
        //                  teaken
        //                                        
        //                                  1 cant.. 2 cant.. res=[1,2,3]    1 cant.. res[1,3,2]   3 cant...                      
        //                                                    taken[1,2,3]            taken[1,3,2]
        //                                                     we stop here            we stop here
        //
        //
        
        
        List<List<Integer>> result = new ArrayList<>();
        
        boolean isTaken[] = new boolean[nums.length];
        
        solve(nums,result,isTaken,new ArrayList<>());
        
        return result;
        
    }
    
    public void solve(int nums[], List<List<Integer>> result, boolean isTaken[], List<Integer> temp){
        
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
           
        for(int i=0; i<nums.length; i++){
            if(isTaken[i] == false){
                
                temp.add((nums[i]));
                isTaken[i] = true;
                
                solve(nums,result,isTaken,temp);
                
                temp.remove(temp.size()-1);
                isTaken[i] = false;
            }
                
        }
    }
}



//APPROACH 2
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        //O(n! X n) time complexity but we have reduced space complexity to O(1) space;
        
        //Idea is recursion and swapping the nums array
        
        //   start=0                                                1,2,3
        //   start = 1             1,2,3                           2,1,3                                    3,2,1         swap the value from start to end using for loop
        //   start = 2       1,2,3        1,3,2          2,1,3             2,3,1                 3,2,1             3,1,2
        //   start = 3   so we stop and add the list and backtrack again
        
        List<List<Integer>> result = new ArrayList<>();
        
        solve(result,0,nums);
        
        return result;
        
        
        
    }
    
    public void solve(List<List<Integer>> result, int start, int nums[]){
        if(start == nums.length){
            List<Integer> res = new ArrayList<>();
            
            for(int k=0; k<nums.length; k++){
                res.add(nums[k]);
            }
            result.add(res);
            
            return;
        }
        
        for(int i=start; i<nums.length; i++){
            swap(nums,start,i);
            
            solve(result,start+1,nums);
            
            swap(nums,start,i);
        }
    }
    
    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}