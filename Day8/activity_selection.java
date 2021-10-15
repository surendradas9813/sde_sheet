Given N activities with their start and finish day given in array start[ ] and end[ ]. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a given day.
Note : Duration of the activity includes both starting and ending day.


Example 1:

Input:
N = 2
start[] = {2, 1}
end[] = {2, 2}
Output: 
1
Explanation:
A person can perform only one of the
given activities.

Example 2:

Input:
N = 4
start[] = {1, 3, 2, 5}
end[] = {2, 4, 3, 6}
Output: 
3
Explanation:
A person can perform activities 1, 2
and 4.

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        
        
        //Idea is similar to N meetings in a room
        
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
                check = list.get(i).end;
            }
        }
        return count;
    }
}


class Pair{
    int start;
    int end;
    
    Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}