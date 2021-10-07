    int[] findTwoElement(int arr[], int n) {
        
        // 1st Method
        // // time complexity --> O(n)
        // // space complexity --> O(n) maintaing an array of frequency so that we can iterate and fine the missing and repeating No;
        
        
        // int temp[] = new int[n+1];
        
        // int repeatNo = -1;
        // int missingNo = -1;
        
        // for(int item: arr)
        //     temp[item]++;
            
        // for(int i=1; i<temp.length; i++){
        //     if(temp[i] == 2)
        //         repeatNo = i;
                
        //     if(temp[i] == 0)
        //         missingNo = i;
        // }
        
        // return new int[]{repeatNo,missingNo};
        
        
        
        
        // // 2nd Method
        // // time complexity --> O(n);
        // // space complexity --> O(1); Using Mathematic and concept of algebra i.e. making equations;
        
        
        // long sum_N = 0;    //long to avoid integer overflow;
        // long squareSum_N = 0;
        
        // for(int i=0; i<n; i++){
            
        //     sum_N += (i+1) - arr[i];  // eg 1 3 3 -> 1+2+3-1-3-3
        //     squareSum_N += Math.pow((i+1),2) - Math.pow(arr[i],2);  // eg 1 3 3 -> 1^2 + 2^2 + 3^2 - 1^2 - 2^2 - 3^2
            
        // }
        
        // long missingNo = (squareSum_N/sum_N + sum_N)/2;
        
        // long repeatingNo = missingNo - sum_N;
        
        // return new int[]{(int)repeatingNo,(int)missingNo};
        
        
        
        // 3rd Method (Using Bit Manipulation) Best Method;
        
        int xor = 0;
        
        for(int i=0; i<n; i++){
            xor = xor ^ (i+1) ^ arr[i];
        }
        
        int setBitNo = xor & (-xor);   //to find the right most setBitNo;
        
        int num1 = 0;
        int num2 = 0;
        
        for(int i=0; i<n; i++){
            
            if((setBitNo & (i+1)) == 0)
                num1 = num1 ^ (i+1);
                
            else
                num2 = num2 ^ (i+1);
                
            if((setBitNo & arr[i]) == 0)
                num1 = num1 ^ arr[i];
            else
                num2 = num2 ^ arr[i];
        }
        
        int result[] = {num1,num2};
        
        // we are not sure which one is repeating and missing number among result so 
        // we need to traverse through given array and check
        
        for(int i=0; i<n; i++){
            
            if(arr[i] == num2){
                int temp = result[0];
                result[0] = result[1];
                result[1] = temp;
                break;
            }
        }
        return result;
        
    }