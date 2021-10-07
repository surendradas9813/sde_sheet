    public int[][] merge(int[][] intervals) {
        
//         Optimal Solution O(nlogn) time and O(n) space for storing the result;
        
//         the idea is to srot the intervals according to the starting number and check end and first of next interval and try to merge them and add in the list
        
//         One point to remember if you make a list of list or array and add the list1 inside list of list and further anywhere you modify the list1 the list  of list will algo get modified;
        
        
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]); //sorting the array by passing comparator;
        
        
        
        List<int[]> result = new ArrayList<>();
        
       int[] current = intervals[0];
        result.add(current);
        
        for(int[] interval: intervals){
            
            int current_start = current[0];
            int current_end = current[1];
            
            int next_start = interval[0];
            int next_end = interval[1];
            
            if(current_end >= next_start){
                current[1] = Math.max(current_end,next_end); //update the array which is already in the list
            }
            
            else{
                current = interval; //make the current to the interval and add in the list and perform comparison on its basis and update its value in next interation.
                
                result.add(current);
            }
        }
        
        return result.toArray(new int[result.size()][]); //new int [][] for convertin Object[] into int[][] type
    }