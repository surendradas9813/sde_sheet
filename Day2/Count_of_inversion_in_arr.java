class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // // Brute force-->O(N^2) time complexity and O(1) space complexity
        
        // int n = arr.length;
        // long cnt = 0;
        
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(arr[i] > arr[j])
        //             cnt++;
        //     }
        // }
        
        // return cnt;
        
        
        // Optimal Solution--> O(nlogn) time complexity 
        // Idea is to use merge sort technique.
        
        return mergeSort(arr,0,arr.length-1);
    }
    
    static long mergeSort(long arr[], int l, int r){
        
        long inversion_count = 0;
        
        if(l<r){
            int mid = l + (r-l)/2;
            
            inversion_count += mergeSort(arr,l,mid);
            inversion_count += mergeSort(arr,mid+1,r);
            
            inversion_count += merge(arr,l,mid+1,r);
        }
        return inversion_count;
    }
    
    static long merge(long arr[], int l, int mid, int r){
        
        int n1 = mid-l;
        int n2 = r-mid+1;
        
        long temp1[] = new long[n1];
        long temp2[] = new long[n2];
        
        for(int i=0; i<n1; i++)
            temp1[i] = arr[i+l];
            
        for(int i=0; i<n2; i++)
            temp2[i] = arr[mid+i];
            
        int i=0;
        int j=0;
        
        int ind = l;
        
        long cnt = 0;
        
        while(i<n1 && j<n2){
            
            if(temp1[i] <= temp2[j]){
                arr[ind++] = temp1[i++];
            }
            else{
                cnt += n1-i;
                arr[ind++] = temp2[j++];
            }
        }
        
        while(i<n1){
            arr[ind++] = temp1[i++]; 
        }
        while(j<n2){
            arr[ind++] = temp2[j++];
        }
        return cnt;
    }
}