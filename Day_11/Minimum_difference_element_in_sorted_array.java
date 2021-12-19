Given a sorted array,
find the element in the array which has minimum difference with the given number.

arr={1,3,8,10,15} key = 12

o/p: 10


Approach--> (1 , 3 , 8, 10, 15)
	     11	 9   4   2   3        so we are getting 2 as minimum when subtracting with key = 12



Solution --> O(logn) solultion

if the key is present in the array then it would be answer because the difference would be 0

if the key is not present in the array then when the loop breaks the low will be pointing the just greater 
to the target and high will be pointing to the just smaller to the target so we can take

lowDiff = Math.abs(arr[low]-key)
highDiff = Math.abs(arr[high]-key)

if(lowDiff<highDff)  return arr[low];
else return arr[high];