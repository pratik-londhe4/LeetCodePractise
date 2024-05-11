class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Worker[] workers = new Worker[quality.length];
        
        for(int i = 0 ; i < workers.length ; i++ ){
            workers[i] = new Worker(quality[i], wage[i]);
        }
        
        Arrays.sort(workers,(a,b) -> {
            if(a.rate < b.rate){
                return -1;
            }else if(a.rate > b.rate){
                return 1;
            }else return 0;
        } );
        
        
        PriorityQueue<Worker> q = new PriorityQueue<>(new CompareWorker());
        
        double ans = Double.MAX_VALUE;
        int total_quality = 0;
        
        for(int i = 0 ; i < workers.length ; i++){
            
            Worker curr = workers[i];
            q.offer(workers[i]);
            total_quality += curr.quality;
            
            if(q.size() > k){
               total_quality -= q.poll().quality;
                
            }
            
            if(q.size() == k){
                ans = Math.min(ans, total_quality * curr.rate);
            }
  
        }
        
        return ans;
     
        
    }
    
    class Worker{
        int quality;
        int wage;
        double rate;
        
        public Worker(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
            this.rate = wage/(double)quality;
            
        }
    }
    
    class CompareWorker implements Comparator<Worker> {
        
        public int compare(Worker a, Worker b){
             if(a.quality < b.quality){
                return 1;
            }else if(a.quality > b.quality){
                return -1;
            }else return 0;
        }
    }
}