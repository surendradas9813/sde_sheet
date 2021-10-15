class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        
        
        //time complexit O(nlogn ) for sorting O(n) for traversing and calculating
        // Idea is to sort according to decreasing value/weight ratio and start picking weights
        //and when we encounter less weight remaining then take fraction of reached weights and break the loop
        
        Arrays.sort(arr, (a,b)->{
           double r1 = (double)b.value/(double)b.weight;  //double to for float values as some test cases will be failed
           double r2 = (double)a.value/(double)a.weight;
           
            if(r1-r2>0) return 1;
            else return -1;
            });
        
       int i= 0;
       
       double value = 0.0;
       
       while(W > 0 && i<n){
           
           if(W>=arr[i].weight){
               W = W-arr[i].weight;
               value += arr[i].value;
               i++;
           }
           else{
               value += ((double)arr[i].value/(double)arr[i].weight) * (double)W;
               break;
           }
       }
       return value;
    }
}