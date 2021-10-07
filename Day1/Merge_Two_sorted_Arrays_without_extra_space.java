//     Two variations are there one of leetcode  ---> 1,2,3,0,,0,0    2,5,6  o/p: 1,2,2,3,5,6
//     another gfg  10   2,3  o/p: 2   3,10
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
//       Brutre force: Use another array, store all and sort and store back to respective array
        
//         Optimal is O(n) time and 0(1) space  using two pointer approach;
        
        int n1 = m-1;
        int n2 = n-1;
        
        int ind = nums1.length-1;
        
        while(n1 >=0 && n2 >=0){
            
            if(nums1[n1] < nums2[n2])
                nums1[ind--] =  nums2[n2--];
            
            
            else
                nums1[ind--] = nums1[n1--];
        }
        
//         coptying the reaming of value of 2nd array if any presnt
        
        while(n2>=0)
            nums1[ind--] = nums2[n2--];
    }






gfg question 


    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        
        // 1st Method: O(m+nlog(m+n)) time and o(n) space
        // Use a third array and store all the element of both arrays and sort and copy back 
        // original array
        
        
        // 2nd Method : O(n*m) time and O(1) space
        // we compare the elements of 1st array with 1st element of 2nd array and if element 
        // first array is larger we swap and run a loop inside to put the swapped element in
        // the correct position so that the array remains sorted;
        
        // int n1 = arr1.length;
        // int n2 = arr2.length;
        
        // for(int i=0; i<n1; i++){
            
        //     if(arr1[i] > arr2[0]){  //comparint each element of 1st arr with 1st ele of 2nd arr
                
        //         long temp = arr1[i];
        //         arr1[i] = arr2[0];
        //         arr2[0] = temp;
                
                
        //         long toPlace = arr2[0]; // we have to place this to correct position
        //         int j;
        //         for(j=1; j<n2 && arr2[j] < toPlace; j++){
        //             arr2[j-1] = arr2[j]; 
        //         }
        //         arr2[j-1] = toPlace;  //found the position and finally placing
        //     }
        // }
        
        
        
        // 3rd Method : Gap Method   time compl.. --> lon n XO(n)    space --> O(1)
        
        // we will swap at the gap distance  and gap reduces upto 1;  for gap --> log n 
        // for traversing array - O(n)  so overall is logn X O(n);
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        int i;
        int j;
        
        for(int gap = nextGap(m+n); gap>0; gap =nextGap(gap)){
            
            // comparing in first array
            for(i=0; i+gap<n1; i++){
                if(arr1[i] > arr1[i+gap]){
                    long temp = arr1[i];
                    arr1[i] = arr1[i+gap];
                    arr1[i+gap] = temp;
                }
            }
            
            // comparing in both the arrays
            for(j=gap>n1?gap-n1:0; i<n1 && j<n2; j++,i++){
                if(arr1[i] > arr2[j]){
                    long temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            
            // comparing in 3rd array if j didnt reach end
            if(j<n2){
                for(j=0; j+gap<n2; j++){
                    if(arr2[j] > arr2[j+gap]){
                        long temp= arr2[j];
                        arr2[j] = arr2[j+gap];
                        arr2[j+gap] = temp;
                    }
                }
            }
        }
        
    }   
    
    
    static int nextGap(int n){
        if(n <= 1) return 0;
        
        return n/2 + n%2;
    }