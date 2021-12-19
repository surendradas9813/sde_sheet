Note:--- if we apply binary search in sorted array if the target is found then the loop breaks
else the low will point the just greater element to the target and high element will point just smaller 
element to the target and crosses each other resulting the loop break.


This can be used to find the floor and ceil of an element in the sorted array

class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        int low = 0;
        int high = n-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] == x)
                return mid;
                
            else if(arr[mid] > x)
                high = mid-1;
                
            else
                low = mid+1;
        }
        return high;   // here we are returning the index 
    }
    
}



public class Solution {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] == x)
                return arr[mid];
            
            else if(arr[mid] > x)
                high = mid-1;
            
            else
                low = mid+1;
        }
        
        return arr[low];
    }
}