class Solution {
    public int leastInterval(char[] tasks, int n) {
        // get counts of each tasks
        // add them to max heap, start popping and adding to queue
        int time = 0;
        Map<Character, Integer> map = new HashMap<>();
    for (Character character : tasks) {
        Integer characterCount = map.get(character);
        if(characterCount == null) {
            characterCount = 0;
        }
        characterCount++;
        map.put(character, characterCount);
    }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (Character key : map.keySet()) {
            
            pq.add(map.get(key));

}
        Queue<Integer[]> q = new LinkedList<>();
        
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int curr = pq.remove() - 1;
                if(curr != 0){
                    q.add(new Integer[]{curr, time + n});
                }
            }
            
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.remove()[0]);
            }
        }
        return time;
    }
}