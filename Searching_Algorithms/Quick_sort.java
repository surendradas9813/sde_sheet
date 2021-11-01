class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        
        // O(nlogn) time complexity and Divide and Conquer Algorithm
        // Idea is to break the array until we are left at one element
        // pi is the index of which all the elements smaller than it lies at left and larger element lies at right
        
        
        if(low < high){
            int pi = partition(arr,low,high);
            
            quickSort(arr,low,pi-1);
            
            quickSort(arr,pi+1,high);
            
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        
        int pi = low;
        
        for(int i = low; i<high; i++){
            
            if(arr[i] <= pivot){
                
                swap(arr,i,pi);
                
                pi++;
            }
        }
        
        swap(arr,pi,high);
        
        return pi;
    }
    
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}