There are two variations of this question
i) row-wise and column wise sorted --> O(m+n) time
ii) row-wise sorted and last element is smaller than first element of next row --> O(log(m+n)) time


i)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
      // Optimal solution--> O(m+n) time complexity and constant space
      // Idea is to start from top left and traverse down if target is more and traverse left if target is small
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int i=0;
        int j=col-1;
        
        while(i<row && j>=0){ //we are moving left or down so i increase on moving down and j decrease on moving left
            
            if(matrix[i][j] == target) return true;
            
            else if(matrix[i][j] > target) j--;
            
            else i++;
            
        }
        
        return false;
    }
}



ii)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Bruteforce --> O(nXm) time complexity and O(1) space
        // Idea is to traverse through matrix and return true if target is found
        
        
        // Optimal solution --> o(log(m+n)) time complexity and constant space
        // Idea is to use binary search be using 2d int 1d array index representation 
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = 0;
        int end = row*col-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(matrix[mid/col][mid%col] == target)
                return true;
            else if(matrix[mid/col][mid%col] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }
}