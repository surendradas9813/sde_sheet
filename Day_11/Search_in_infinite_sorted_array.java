	public static int binarySearchInInfiniteSortedArray(int arr[], int target){
	    
	    if(arr[0] == target) return 0;
	    
	    int ind = 1;
	    
	    while(arr[ind] < target){    // deciding  the search space
	        ind = ind * 2;
	    }
	    
	    if(arr[ind] == target) return ind;
	    
	    return binarySearch(arr,ind/2,ind);
	    
	}