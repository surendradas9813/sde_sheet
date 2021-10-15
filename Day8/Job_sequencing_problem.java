class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        
       // O(nlogn) for sorting and O(n2) for update the time array.
       
       //Idea is to sort the jobs according decreasing order of their proft.
       //Then take the max deadline and maintain a max+1 size time array with -1 initial values
       //Then traverse through each jobs and update the time array at their deadline time with the job id
       // Because the smaller deadline job can be done and maximum profit can be obtained
       
        Arrays.sort(arr,(a,b)->(b.profit-a.profit));
        
        int maxDeadLine = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            maxDeadLine = Math.max(maxDeadLine,arr[i].deadline);
        }
        
        int time[] = new int[maxDeadLine+1];
        
        Arrays.fill(time,-1);
        
        int jobCount = 0;
        int profit = 0;
        
        for(int i=0; i<n; i++){
            
            for(int j=arr[i].deadline; j>0; j--){// j>0 because we following 1 based index
                                                // this loop check if the job deadline is filled then we try to fill deadline-1 time accordingly                                
                if(time[j] == -1){       
                    time[j] = arr[i].id;
                    jobCount++;
                    profit += arr[i].profit;
                    break;
                }
            }
            
        }
        
        return new int[]{jobCount,profit};
    }
}