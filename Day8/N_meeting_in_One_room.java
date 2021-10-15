There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)

Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output: 
1
Explanation:
Only one meetings can be held
with given start and end timings.

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        //nlong for sorting O(n) traversing
        
        //Idea is to sort the interval after making pair according to ascending orde of thier end time
        //Then we increase the count if the current start is more that than previous meeting end time
        
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            list.add(new Pair(start[i],end[i]));
        }
        
        Collections.sort(list,(a,b)->a.end-b.end);
        
        int count = 1;
        int check = list.get(0).end;
        
        for(int i=1; i<n; i++){
            if(list.get(i).start > check){
                count++;
                check = list.get(i).end;  // we should update the check 
            }
        }
        
        return count;
    }
}


class Pair{
    int start;
    int end;
    
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}





Another variation is that find the minimum numbers of rooms required for conducting all the meetings.


public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {

        //Minimum Platforms needed on railway station = Maximum platforms needed at any time 
        //Idea is to take every interval one by one and find the number of intervals that overlap with it. Keep track of the maximum number of intervals that overlap with an interval. Finally, return the maximum value.
	// similar to minimum no of platforms required in railway station. Only differece is that start time cant be equal to previous end time in train problem
        
	int n = A.size();
        int start[] = new int[n];
        int end[] = new int[n];

        for(int i=0; i<n; i++){
            start[i] = A.get(i).get(0);
            end[i] = A.get(i).get(1);
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int room = 1;
        int result = 1;

        int i=1;
        int j = 0;

        while(i<n && j<n){
            if(start[i] < end[j]){
                room++;
                i++;
            }
            else{
                room--;
                j++;
            }

            if(room > result)
                result = room;
        }
        return result;
    }
}

