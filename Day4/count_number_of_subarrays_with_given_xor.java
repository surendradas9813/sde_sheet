public class Solution {
    public int solve(int[] A, int B) {
        

        // Brute force -- O(n^2) time and O(1) space complexity
        // Idea is to calculate xor of all subarrays and check 

        // int count = 0;

        // int n = A.length;

        // for(int i=0; i<n; i++){
        //     int xor = A[i];
        //     if(xor == B) count++;
            
        //     for(int j=i+1; j<n; j++){
        //         xor = xor ^ A[j];

        //         if(xor == B) count++;
        //     }
        // }

        // return count;


        //Optimal solution --> O(n) time and O(n) space
        // Idea is to use HashMap where we store prefex xor value and their occurences while traversint whole array
        // for eg -->            4        2        2         6         4      xor should be 6 (counting)
        // prefix xor-->        4       6         4        2         6
        // map becomes (4,2),(6,2),(2,1)
        // first subarray is 4 and 2 because their xor is already 6 at reaching index 1
        // second subarray is  2 2 6  because at reaching index 3 xor is 2 and xor ^ target i.e 4 is present in hm twice
        //so two possible subarray i.e 2 2 6 and 6 both from that we get just after 4 calculated xor.
        // last subarray is whole array at last index where final xor is 6.
        // Note  suppose X = 2; so to be subset which gives xor 6 in prefix xor X there should be Y ^ 6 = 2 => so we check if map contains 6 ^ 2 i.e. target ^ xor
        //            

        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        int xor = 0;

        for(int item: A){
            xor = xor ^ item;

            if(xor == B) count++;

            if(hm.containsKey(xor^B)) count += hm.get(xor^B);

            hm.put(xor,hm.getOrDefault(xor,0)+1);
        }
        return count;
    }
}
