class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        dfs(0,board,result);
        return result;
        
    }
    
    public boolean validate(char board[][], int row, int col){
        int duprow = row;
        int dupcol = col;
        
        //checking for upper diagonal
        while(row >= 0 && col>= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        //checking for lower diagonal
        while(col>=0 && row<board.length){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        
        row = duprow;
        col = dupcol;
        
        // checking for straight backward
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        return true;
    }
    
    
    public void dfs(int col, char[][] board, List<List<String>> res){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row<board.length; row++){
            if(validate(board,row,col)){
                
                board[row][col] = 'Q'; //placing the queen
                
                dfs(col+1,board,res);  // trying for next column
                
                board[row][col] = '.';  //Backtrack(removing the queen)
            }
        }
    }
    
    
    // making list of String and each string is one row of chessboard
    public List<String> construct(char board[][]){
        List<String> res = new ArrayList<>();
        
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);  // taking one row of chessboard and converting into string 
            res.add(s);
        }
        return res;
    }
}




//The validation can be done in another method and time complexity for it can be reduced to O(n) to O(1)

class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2*n-1];
        int upperDiagonal[] = new int[2*n-1];
        
        
        
        dfs(0,board,result,leftRow,lowerDiagonal,upperDiagonal);
        return result;
        
    }
    
//     public boolean validate(char board[][], int row, int col){
//         int duprow = row;
//         int dupcol = col;
        
//         //checking for upper diagonal
//         while(row >= 0 && col>= 0){
//             if(board[row][col] == 'Q') return false;
//             row--;
//             col--;
//         }
        
//         row = duprow;
//         col = dupcol;
        
//         //checking for lower diagonal
//         while(col>=0 && row<board.length){
//             if(board[row][col] == 'Q') return false;
//             col--;
//             row++;
//         }
        
//         row = duprow;
//         col = dupcol;
        
//         // checking for straight backward
//         while(col>=0){
//             if(board[row][col] == 'Q') return false;
//             col--;
//         }
//         return true;
//     }
    
    
    public void dfs(int col, char[][] board, List<List<String>> res,int leftRow[], int lowerDiagonal[], int upperDiagonal[]){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row<board.length; row++){
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length-1+col-row] == 0){
                
                board[row][col] = 'Q'; //placing the queen
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[board.length-1+col-row] = 1;
                
                dfs(col+1,board,res,leftRow,lowerDiagonal,upperDiagonal);  // trying for next column
                
                board[row][col] = '.';  //Backtrack(removing the queen)
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length-1+col-row] = 0;
                
            }
        }
    }
    
    
    // making list of String and each string is one row of chessboard
    public List<String> construct(char board[][]){
        List<String> res = new ArrayList<>();
        
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);  // taking one row of chessboard and converting into string 
            res.add(s);
        }
        return res;
    }
}