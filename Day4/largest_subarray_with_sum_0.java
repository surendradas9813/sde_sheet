class GfG
{
    int maxLen(int arr[], int n)
    {
        
        
        //Bruteforce--> O(n^2) time and O(1) space
        //Idea is to calculate all subarray whose sum is zero and update the result
        
        
        // int result = 0;
        
        // for(int i=0; i<n; i++){
        //     int sum = 0;
            
        //     for(int j=i; j<n; j++){
        //         sum += arr[j];
        //         if(sum == 0)
        //             result = Math.max(result,j-i+1);
        //     }
        // }
        // return result;
        
        
        //Optimal solution--> O(n) time and O(n) space
        // Idea is to use HashMap  and store the prefixsum with their indexes
        // ------> 15        -2        2       -8       1       7        10        23
        //      (15,0)    (13,1)       15    (7,3)    (8,4)     15      (25,6)    (48,7)
        //              |                  | 
        //              |                                        |
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int sum = 0;
        
        int length = 0;
        
        for(int i=0; i<n; i++){
            
            sum += arr[i];
            
            if(sum == 0)
                length = Math.max(length,i+1);  // if the total sum is zero then consider whole arr
            
            if(hm.containsKey(sum)){
                length = Math.max(length,i-hm.get(sum));
            }
            
            else
                hm.put(sum,i);
        }
        
        return length;
    }
}