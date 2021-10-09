There are altogether 3 variations of this question.
i) to print whole pascal triangle
ii) to print the particular row of pascal triangle
iii) to print particular row col of pascal triangle


i)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
    // Simple Implementation --> O(n^2) time complexity
    // Idea is to go through each row is it is first or last index then we put 1 else add from previous row
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<numRows; i++){
            
            List<Integer> temp = new ArrayList<>();
            
            for(int j=0; j<=i; j++){
                
                if(j == 0 || j == i)
                    temp.add(1);
                
                else
                    temp.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                    
            }
            
            result.add(temp);
        }
        return result;
    }
}



ii)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        // Optimal Solution--> O(n) time complexity
        // Idea is to find the pattern and calculate the next term
        // for eg for 5th row --> 1      4          6           4           1 
        //                          1   1x(4/1)    4x(3/2)     6x(2/3)    4x(1/4)
                                      
        // Anthoer idea is to find combination i.e nCr -> shortcut is. for eg 3C2 --> (3x2)/(1X2)  keep on decreasing 
        // keep decreasing upper number until the low number is reaches zero 
                                      
            List<Integer> result = new ArrayList<>();
            
            long num = 1;
            
            for(int i=0; i <= rowIndex; i++){
                
                if( i==0 || i == rowIndex)
                    result.add(1);
                else{
                    num = (num * (rowIndex-i+1))/i;
                    result.add((int)num);
                }
            }
            return result;
    }
}



iii)
in 1 based index if n is the row number and r is the column number then
	(n-1)C(r-1)