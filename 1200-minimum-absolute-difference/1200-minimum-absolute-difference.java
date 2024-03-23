class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int abs = Math.abs(arr[1] - arr[0]);
         for(int i = 1 ; i < arr.length -1  ; i++){
             abs = Math.abs(arr[i] - arr[i+1]) < abs ? Math.abs(arr[i] - arr[i+1]) : abs;
         }
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0 ; i < arr.length -1  ; i++){
            if(Math.abs(arr[i+1] - arr[i]) == abs){
               List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                ans.add(pair);
            }
        }
        return ans;
     }
}