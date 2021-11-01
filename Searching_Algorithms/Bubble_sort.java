class Solution
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
        
        // O(n^2) time complexity
        // Idea is to swap adjacent elements and push the largest element to the last in each pass.
        
        boolean check = false;  // This variable is used to check if the eleement in the array are already sorted so that we can break and optimize the code
        
        for(int i=0; i<n-1; i++){
            
            check = false;
            
            for(int j=0; j<n-i-1; j++){
                
                if(arr[j] > arr[j+1]){   
                    
                    check = true;
                    
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            
            if(check == false) break;  // If we find that array is in sorted state then we break the loop
        }
    }
}