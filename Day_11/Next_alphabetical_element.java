Given an array of letters sorted in ascending order, 
find the smallest letter in the the array which is greater than a given key letter.


Input: letters = ["c","f","j"], target = "a"
Output: "c"
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Example 3:

Input: letters = ["c","f","j"], target = "d"
Output: "f"
Example 4:

Input: letters = ["c","f","j"], target = "g"
Output: "j"
Example 5:

Input: letters = ["c","f","j"], target = "j"
Output: "c"


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        //logic is that whenever the loop breaks the low will be pointing to just greater and high will be pointing just smaller to the target
        
        int low = 0;
        int high = letters.length-1;
        
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if(letters[mid] <= target)
                low = mid+1;
            
            else
                high = mid-1;
        }
        
        return letters[low%letters.length];   // here we taken modulo because if not found we need to return the first index;
                                                //eg --> target = z letters=[a,b]  o/p: a;
    }
}