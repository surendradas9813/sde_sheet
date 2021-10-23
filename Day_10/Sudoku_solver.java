class Solution {
    public void solveSudoku(char[][] board) {
        
        if(board == null || board.length == 0)
            return;
        
        solve(board);
        
    }
    
    
    public boolean solve(char board[][]){
        
        for(int row=0; row<board.length; row++){
            for(int col = 0; col<board.length; col++){
                
                if(board[row][col] == '.'){
                    
                    for(char c='1'; c <= '9'; c++){
                        if(validate(board,row,col,c)){
                            
                            board[row][col] = c;
                            
                            if(solve(board))
                                return true;
                            else 
                               board[row][col] = '.';   //backtrack
                        }
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean validate(char board[][], int row,int col, char c){
        
        for(int i=0; i<9; i++){
            
            if(board[row][i] == c) return false;
            
            if(board[i][col] == c) return false;
            
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)] == c)
                return false;
        }
        return true;
    }
}