class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
       //Brute force--> O(n^2) time compleixty and O(1) space complexity
        // Idea is to find all the subarrays and check each subarray has distict character or not and update the result
        
        
        // Another Approach -- > O(n) time and O(n) space
        // Idea is to use HashSet; we keep two pointer l and r to 0
        // we keep adding character at r if it is not in hashset and update the longest length
        // if the character is already in hashSet we delete until we reach that character to be deleted from left side 
        // and increasing l.
        
        
//         HashSet<Character> hs = new HashSet<>();
        
//         int l = 0;
//         int r = 0;
        
//         int n = s.length();
//         int length = 0;
        
//         while(r<n){
            
//             if(hs.contains(s.charAt(r)) == false){
//                 hs.add(s.charAt(r));
//                 length = Math.max(length,r-l+1);
//                 r++;
//             }
//             else{
//                 while( hs.contains(s.charAt(r))){   // this inner loop will make time complexity O(2n) 
//                     hs.remove(s.charAt(l));
//                     l++;
//                 }
//             }
//         }
//         return length;
        
        
        // Optimal Approach ---> O(n) time and O(1) space
        // Idea is to optimise the above approach when we are moving left pointer we were moving lineary so instead 
        // we store index of the repeated character and update the l to indexOf(repeatedcharacter)+1;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        
        int n = s.length();
        int length = 0;
        
        while(r<n){
            if(hm.containsKey(s.charAt(r))){
                l = Math.max(l,hm.get(s.charAt(r))+1); // Here we are taking max because the code fails for test cases like abba
                                                       // making sure that the l lies between l and r not before l.                                 
            
            }
            hm.put(s.charAt(r),r);
            length = Math.max(length,r-l+1);
            r++;
        }
        return length;
    }
}