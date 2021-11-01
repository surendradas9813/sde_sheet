class Solution
{

	void selectionSort(int arr[], int n)
	{
	    
	    // O(n^2) time complexity
	    // Idea is to traverse the array and for each index find the smallest element and swap.
	    for(int i=0; i<n-1; i++){
	        
	        int minIndex = i;
	        
	        for(int j=i+1; j<n; j++){   // find the smallest value for the index i
	            
	            if(arr[j] < arr[minIndex])
	                minIndex = j;
	        }
	        
	        // swapping the value so that i index is swapped the ith smallest number.
	        int temp = arr[i];
	        arr[i] = arr[minIndex];
	        arr[minIndex] = temp;
	    }
	}
}