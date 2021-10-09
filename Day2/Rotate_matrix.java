class Solution {
    public void rotate(int[][] matrix) {
        
        // Brute force --> make an extra matrix with same size and copy 1st row into last col and so on
        // O(nxm) time and O(nxm) space complexity
        
        
        // Optimal solutin --> transpose the given matrix and reverse each row 
        // O(nxm) time and O(1) space complexity
        
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        // transpose the matrix
        
        for(int i=0; i<row; i++){
            for(int j=i+1; j<col; j++){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // reversing each row of the matrix
        
        for(int i=0; i<row; i++){
            reverse(matrix[i]);
        }
        
    }
    
    public void reverse(int arr[]){
        int low = 0;
        int high = arr.length-1;
        
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}