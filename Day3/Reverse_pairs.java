class Solution {
    public int reversePairs(int[] nums) {
        
        
//         // Bruteforce --> O(n^2) time complexity and O(1) space complexity
//         // Idea is to traverse with one inner traversal and check 
        
//         int count = 0;
        
//         for(int i=0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
                
//                 if(nums[i] > 2 * nums[j])
//                     count++;
//             }
//         }
//         return count;
        
        
        
        
        // Optimal --> O(nlogn) solution
        // Idea is to use merge sort technique
        
        return mergeSort(nums,0,nums.length-1);
        
    }
    
    public int mergeSort(int nums[], int l, int r){
        int count = 0;
        
        if(l<r){
            int mid = l +(r-l)/2;
            
            count += mergeSort(nums,l,mid);
            count += mergeSort(nums,mid+1,r);
            count += merge(nums,l,mid+1,r);
            
        }
        return count;
    }
    
    public int merge(int nums[],int l, int m, int r){
        
        int n1 = m-l;
        int n2 = r-m+1;
        int count = 0;
        
        int temp1[] = new int[n1];
        int temp2[] = new int[n2];
        
        for(int i=0; i<n1; i++)
            temp1[i] = nums[l+i];
        
        for(int j=0; j<n2; j++)
            temp2[j] = nums[m+j];
        
        int i=0;
        int j=0;
        int ind = l;
        
        while(i<n1 && j<n2){
            if(temp1[i] > 2*(long)temp2[j]){  // using long to avoid integerflow while multiplying with 2
               
                count += n1-i;
                j++;
            }
            else i++;
        }
        
        i=0;
        j=0;
        while(i<n1 && j<n2){
            if(temp1[i] < temp2[j]){
                nums[ind++] = temp1[i++];
            }
            else
                nums[ind++] = temp2[j++];
        }
        
        while(i<n1)
            nums[ind++] = temp1[i++];
        
        while(j<n2)
            nums[ind++] = temp2[j++];
        
        return count;
    }
}