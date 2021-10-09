class Solution {
    public void setZeroes(int[][] matrix) {
        
        
        // Bruteforce --> O(MxN) x(m+n) time complexity and O(1) space complexity
        // Idea is to traverse each element in the matrix and whenenver we find 0 we traverse the column and row of 
        // that element and mark it as some arbiratory value like '-1' if only positive integers are present in the 
        // matrix. After this we traverse through array and mark that arbiratory value to 0 and output is obtained;
        
        
        // Approach 2 --> O(MXN) time complexity and O(m+n) space complexity
        // Idea is to maintain one row and one column to store the indexes of the element that are int zero in matrix
        
//         int row = matrix.length;
//         int col = matrix[0].length;
        
//         boolean horizontal[] = new boolean[col];
//         boolean vertical[] = new boolean[row];
        
//         for(int i=0; i<row; i++){
//             for(int j=0; j<col; j++){
//                 if(matrix[i][j] == 0){
//                     horizontal[j] = true;
//                     vertical[i] = true;
//                 }
//             }
//         }
        
        
//         for(int i=0; i<row; i++){
//             for(int j=0; j<col; j++){
//                 if(horizontal[j] || vertical[i])
//                     matrix[i][j] = 0;
//             }
//         }
        
        
        // Optimal Approach--> O(mXn) time complexity and O(1) space complexity
        // Idea is to use the first row and first column of the matrix for storing the indexes of 0's of the matrix
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean fr = false;
        boolean fc = false;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                
                if(matrix[i][j] == 0){
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
                    
            }
        }
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        if(fr){
            for(int i=0; i<col; i++)
                matrix[0][i] = 0;
        }
        if(fc){
            for(int i=0; i<row; i++)
                matrix[i][0] = 0;
        }
        
    }
}