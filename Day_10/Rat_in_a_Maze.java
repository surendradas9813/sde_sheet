// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
     static ArrayList<String> result;
    public static ArrayList<String> findPath(int[][] m, int n) {
         //Your code here
          boolean[][] isVisited = new boolean[n][n];
          
         
          result = new ArrayList<>();
          if(m[n-1][n-1] == 0) return result;
          String path = "";
          dfs("",m,0,0,n-1,isVisited, path);
          
          
          
          //Collections.sort(result);  if we call recursion in DLRU the reuslt automatically will be in sorted order.
          return result;
    }
    
     static void dfs(String direction, int[][]m, int i, int j, int n, boolean[][] isVisited, String path){
         
         if(i==n && j == n) {
            path = path + direction;
            result.add(path);
            return;
             
         }
         
         if(i < 0 || i > n || j < 0 || j > n || isVisited[i][j] == true || m[i][j] == 0){
             return;
         }
         
         isVisited[i][j] = true;
         path = path + direction;
         dfs("D",m, i+1,  j, n, isVisited, path);
         
         dfs("L",m, i, j-1, n, isVisited, path);
         dfs("R",m, i, j+1, n, isVisited, path);
         dfs("U",m, i-1, j, n, isVisited, path);
         
         isVisited[i][j] = false;
         return;
         
     }
}