class Solution {
    public double myPow(double x, int n) {
        
        
        // Optimal solution --> O(logn) Idea is to use fast power exponentiation technique
        //  a^n = a * a^(n-1) if n is odd
        //      = a^2 * a^(n/2) if n is even
        
        //eg 2^10 a=2 b = 10  ----> 4^5  ie a = 4 b = 5   result = 1;
        //    4^5 a=4 b = 5  ----> 4 * 4^4 i.e. a = 4 b = 4 result = 4
        //    4^4 a=4 b = 4  -----> 16^2  i.e. a = 16 b =2  result = 4
        //    16^2 a=16 b=2  -----> 256^1 i.e. a = 256 b =1  result 4
        //    256^1 a=256 b=1 -----> 256 * 256^0 i.e. a=256 b = 0  result = 4 * 256 = 1024  
        //   since b >0 is false
        //  so final answer is 1024;
        
        long b = n;  // we are taking long to avoid integer overflow when taken abs of int max min
        b = Math.abs(b);
        
        double result = 1;
        
        while(b>0){
          
            if(b % 2 == 0){
                x = x*x;
                b = b/2;
            }
            
            else{
                result = result*x;
                
                b = b-1;
            }
                     
        }
        return (n<0)?(1/result):result;
    }
}