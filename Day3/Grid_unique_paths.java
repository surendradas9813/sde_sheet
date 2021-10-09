class Solution {
    
//     //Bruteforce --> O(2^n) time complexity
//     // Idea is to use recursion
    
//     public int uniquePaths(int m, int n) {
        
//         return solve(m-1,n-1);        
        
//     }
    
    
//     public int solve(int m, int n){
        
//         if(m == 0 || n == 0) return 1;
        
//         return solve(m-1,n)+solve(m,n-1);
//     }
    
    
    
//     // Reducing the time complexity by topdown and memoization;
    
//     public int uniquePaths(int m, int n){
        
//         int dp[][] = new int[m][n];
        
//         for(int i=0; i<m; i++)
//             for(int j=0; j<n; j++)
//                 dp[i][j] = -1;
        
//         solve(m-1,n-1,dp);
//         return dp[m-1][n-1];
//     }
    
//     public int solve(int m, int n, int dp[][]){
//         if(m == 0 || n== 0){
//             dp[m][n] = 1;
//             return 1;
//         }
        
//         if(dp[m][n] != -1)
//             return dp[m][n];
        
//         dp[m][n] = solve(m-1,n,dp)+solve(m,n-1,dp);
        
//         return dp[m][n];
//     }
    
    
//     // bottom up dp with almost same time complexity and avoid recursion call stack
    
//     public int uniquePaths(int m, int n){
        
//         int dp[][] = new int[m][n];
        
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(i == 0 || j == 0)
//                     dp[i][j] = 1;
//                 else
//                     dp[i][j] = dp[i-1][j] + dp[i][j-1];
//             }
//         }
//         return dp[m-1][n-1];
//     }
    
    
    
    // Optimal solution is to use combinations
    
    // O(m) or O(n) time complexity and O(1) space complexity
    
    // Basic idea is that for 2X3 matrix the possible paths are RRD, DRR, RDR if we see the paths
    // we find the similarity that we are taking 3 steps so how we are getting 3 lets figure out
    // if m rows are there then we need to move down by n-1 i.e 2-1 = 1
    // if n cols are there then we need to move right by m-1 i.e. 3-1 = 2 so total is 1+2 =3 
    // so total directions becaomse m-1 + n-1 = m+n-2
    // Another obervation for above examples we need to fill three empty blanks __ __ __
    // so if we choose 2 right direction or we choose 1 down direction then rest can be filled
    // like for choosing 1 down lets se  B _ _ , _ B _ , _ _ b total 3 so those empty can be filled
    // by choosing down steps we can figure out total ways and rest empty can be filled with R right dire
    // so formula becomes m+n-2 C n-1 or m+n-2 C m-1 both will give same answer
    
    public int uniquePaths(int m, int n){
        
        int x = m+n-2;
        int y = n-1;
        
        double res = 1;
        
        for(int i=1; i<=y; i++){
            
            res = res * (x-y+i)/i; //shortcut way of find nCr  keeping decreasing n until r reaches to 0
        }
        return (int)res;
    }
    
    
}