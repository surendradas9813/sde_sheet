class Solution
{
  public void insertionSort(int arr[], int n)
  {
      
      // O(n^2) time complexity
      // Idea is similar to playing cards where we pick the card and place accordingly.
      
      
        for(int i=1; i<n; i++){
            
            int key = arr[i];
            int j;
            
            // find the correct position to place the key;
            for(j=i-1; j>=0 && arr[j] > key; j--){
                arr[j+1] = arr[j];
            }
            
            arr[j+1] = key;
        }
  }
}