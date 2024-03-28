class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> hashTable = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        
        while(right < nums.length){
            int old = hashTable.getOrDefault(nums[right], 0);
            hashTable.put(nums[right] , old+1);
            while(hashTable.get(nums[right]) > k ){
                hashTable.put(nums[left] , hashTable.get(nums[left]) - 1);
                left++;
            }
            right++;
            ans = Math.max(right-left , ans);
        }
        return ans;
    }
}