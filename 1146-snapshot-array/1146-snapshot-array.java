class SnapshotArray {
    HashMap<Integer,Integer> hm[];
    int snapId ;

    public SnapshotArray(int length) {
        snapId = 0;
        hm = new HashMap[length];
    }
    
    public void set(int index, int val) {
        if(hm[index] == null){
            hm[index] = new HashMap();
        }
        hm[index].put(snapId,val);
        
    }
    
    public int snap() {
        snapId++;
        return snapId-1;
        
    }
    
    public int get(int index, int snap_id) {
        if(hm[index] == null)return 0;
        System.out.println(hm[index].containsKey(snap_id));
        
        while(snap_id >= 0 && !hm[index].containsKey(snap_id)){
            snap_id--;
        }
        System.out.println(snap_id);
        
        if(snap_id == -1)return 0;
        
        return hm[index].get(snap_id);
        
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */