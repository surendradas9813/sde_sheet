Given a list arr of N integers, print sums of all subsets in it.

Example 1:

Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.


Example 2:

Input:
N = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8


class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        
        //Brute force --> calculate powerSet (2^N) and traverse through each set and store the length
        
        
        //Optimal Approach ---> while calculateing powerSet only we are calculating the sum of each subset
        
        // for eg                   3,1,2, sum = 0,i=0
        //               3,1,2, sum=3, i=1(taken)                                             3,1,2 sum = 0, i=1 (not taken)
        //      3,1,2, sum=4, i=2       3,1,2 sum=3 i=2                               3,1,2 sum =1, i=2           3,1,2 sum = 0, i=2
        //  sum=6,i==3  sum=4,i==3   sum=5,i==3 sum ==3 i==3                    sum=3 i==1  sum=1 i==3            sum ==2 i==3   sum=0 i==3
        // since we reached end of the array so we add the sum in list and sort it and then return;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        solve(arr,result,0,0,N);
        
        
        // we are sorting because the result should be in sorted order.
        Collections.sort(result);
        
        return result;
    }
    
    
    void solve(ArrayList<Integer> arr, ArrayList<Integer> result, int i,int sum, int N){
        
        if(i == N){
            result.add(sum);
            return;
        }
        
        //picking the element at ith
        solve(arr,result,i+1,sum + arr.get(i),N);
        
        //Not picking the element at ith
        solve(arr,result,i+1,sum,N);
    }
}






Another Approach which is useful in subset sumII combination I and II

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums);
        
        //Time complexity is --> 2^n*N where N is for making deep copy and adding to result 
        //space complexity is --> 2^n;
        
        //Idea is to use recursion and backtrack
        
        //lets take example for [1,2,3]             [1,2,3] i=0 tmp=[]     ---> each level is answer 
        //                                  [1,2,3]i=1 tmp[1]                                  i=2 tmp[2]                                       i=3 tmp[3]              
        //        [1,2,3]          i=2 tmp[1,2]      i=3 tmp[1,3]               i=3 tmp[2,3]    
        //                      i=3 tmp[1,2,3]
        //         
       
        
        List<List<Integer>> result = new ArrayList<>();
        
        solve(nums,new ArrayList<>(),result,0);
        
        return result;
    }
    
    
    public void solve(int nums[], List<Integer> temp, List<List<Integer>> result, int i){
        
        result.add(new ArrayList<>(temp)); // here we are adding by doing new arraylist<>(temp) beacause if we  simply add as .add(temp) then anywhere we do change in temp the result also will get updated.
        
        for(int ind=i; ind<nums.length; ind++){
            temp.add(nums[ind]);
            solve(nums,temp,result,ind+1);
            temp.remove(temp.size()-1);
        }
    }
}