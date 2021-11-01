class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
        
        // creating temp arr for storing the arr elements so that later on we can merge
         int n1 = m-l;
         int n2 = r-m+1;
         
         int temp1[] = new int[n1];
         int temp2[] = new int[n2];
         
         
         //copying the value left arr
         for(int i=0; i<n1; i++)
            temp1[i] = arr[l+i];
        
        //copyting the right arr value   
        for(int i=0; i<n2; i++)
            temp2[i] = arr[m+i];
            
            
        int ind = l;
        
        int i=0;
        int j=0;
    
        // merging the array
        while(i<n1 && j<n2){
            
            if(temp1[i] <= temp2[j]){
                arr[ind++] = temp1[i++];
            }
            else{
                arr[ind++] = temp2[j++];
            }
        }
        
        //if remaining 
        while(i<n1){
            arr[ind++] = temp1[i++];
        }
        
        //if remaining
        while(j<n2){
            arr[ind++] = temp2[j++];
        }
    }
    
    
    void mergeSort(int arr[], int l, int r)
    {
        if(l<r){
            int mid = l + (r-l)/2;
            
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            
            merge(arr,l,mid+1,r);
        }
    }
}
