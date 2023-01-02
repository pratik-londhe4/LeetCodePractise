class Solution {
    public int findDuplicate(int[] nums) {
        int freq[] = new int[1000001];
        
        for(int i  : nums){
            freq[i]++;
            if(freq[i] > 1)return i;
        }
        return 0;
    }
}