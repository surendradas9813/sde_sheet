// This method is only valid for indian currency

// i.e. coints[] = [1,2,5,10,20,50,100,500,100]

// time complexity is O(V) i.e where V is the given input whose output is required.

//This greedy fail if V = 11 and denomination is [1,5,6,9] because by greedy you will get 9,1,1 but output is 5,6


static void findMin(int V){
    List<Integer> ans = new ArrayList<>();
    
    int deno[] = {1,2,5,10,20,50,100,500,1000};
    int n = deno.length;
    
    for(int i=n-1; i>=0; i--){
        while(V >= deno[i]){
            V -= deno[i];
            ans.add(deno[i]);
        }
    }
    
    for(int i=0; i<ans.size(); i++)
        System.out.print(ans.get(i)+" ");
}
