class Solution {
    public int maxProfit(int[] prices) {
        
        // Bruteforce - O(n^2) time complexity and O(1) space complexity
        
//         int result = 0;
//         int n = prices.length;
        
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 if(prices[j] > prices[i])
//                     result = Math.max(result, prices[j] - prices[i]);
//             }
//         }
//         return result;
        
        
        // Optimal solutin - O(n) time complexity and O(1) space complexity
        // we find min in the array as we go on traverse and calculate prfoit for each element in array with min;
        
            int min = Integer.MAX_VALUE;
            int result = 0;
        
            for(int i=0; i<prices.length; i++){
                min = Math.min(min,prices[i]);
                result = Math.max(result,prices[i]-min);
            }
        
            return result;
    }
}s