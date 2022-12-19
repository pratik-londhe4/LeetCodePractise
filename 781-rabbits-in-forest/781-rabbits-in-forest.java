class Solution {
    public int numRabbits(int[] answers) {
      HashMap<Integer , Integer> hm = new HashMap();

		for(int val : answers){
			hm.put(val , hm.getOrDefault(val,0)+1);
		}

		int min = 0;
		for(int key : hm.keySet()){
			int group_size = key+1;
			int reportees = hm.get(key);
			int groups = (int)Math.ceil(reportees * 1.0 / group_size * 1.0);
			min+=groups * group_size;
		}
		return min;
        
    }
    
}