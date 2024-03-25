class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int [] hashTable = new int[1000001];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            hashTable[nums[i]]++;
            if(hashTable[nums[i]] == 2){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}