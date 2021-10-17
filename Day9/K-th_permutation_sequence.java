class Solution {
    public String getPermutation(int n, int k) {
        
        //Bruteforce --> find all permutations using recursion and once all permutations are obtained sort it and return kth permuation by traversing through the data structure.
        //Time complexity = n! factorial time and for deep copy of list for storing O(n) and for sorting n!long(n!).
        
        
        
        //Optimal solution--> O(N^2) time and O(N) space complexity
        // Idea is to use Mathematics
        
        // for n=4 and k = 17  o/p:  3 4 1 2
        
        // Aproach   1 + (2,3,4)i.e 3! -> (0-5th)
        //           2 + (1,3,4)i.e.3! -> (6th-11th) 
        //           3 + (1,2,4)i.e.3! -> (12th-17th) 
        //           4 + (1,2,3)i.e.3! -> (18th-23th) sequence          our requirement is k=17 which is k = k-1 = 16th swquecen(0-based)  n = [1,2,3,4]
                                                                        // we 16/6 = 2 i.e 2nd element of list  3 _ _ _  and we find 16%6 = 4 --> 4th sequenc in remaining [1,2,4];      
        
        //          1 + (2,4)i.e 2! -> (0-1th) sequence
        //          2 + (1,4)i.e 2! -> (2th-3th) sequence    
        //          4 + (1,2)i.e 2! -> (4th-5th) sequecence        // we 4/2 = 2 i.e 2nd element of the list [1,2,4]   3 4 _ _ and we find 4%2 --> 0th sequence in remaing [1,2];
        
        //          1 + (2) i.e. 1! -> (0-0th) sequence
        //          2 + (1) i.i 1! -> (1 - 1th) sequence           // we 0/1 = 0 .ie 0th element of the list [1,2]   --> 3 4 1 _ and we find 0 % 1 --> 0th sequcne in remaig [2];
        
        
        //          2                                             // --> final answer is 3 4 1 2 and the list is finally empty 
        
        
        String ans = "";
        
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<n; i++){
            list.add(i);
            fact = fact*i;
        }
        
        list.add(n);
        k = k-1;
        
        while(true){
            ans = ans+list.get(k/fact);
            
            list.remove(k/fact); // this line making the code O(n^2) because we are removing random element in the list so internally it takes O(n)
            
            if(list.size()==0) break;
            
            k = k%fact;
            
            fact = fact/list.size();
        }
        
        return ans;
        
        
    }
}