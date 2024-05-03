class Solution {
    public int compareVersion(String version1, String version2) {
        // lets split the string first
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int size = Math.max(v1.length, v2.length);
        
        // fill the small array with 0's
        
        if(v1.length < size){
            
            int length = v1.length;
            v1 = new String[size];
            Arrays.fill(v1, "0");
            System.arraycopy(version1.split("\\."), 0, v1, 0, length);
        }else if(v2.length < size){
            
            int length = v2.length;
            v2 = new String[size];
            Arrays.fill(v2, "0");
            System.arraycopy(version2.split("\\."), 0, v2, 0, length);
        }
        
        System.out.println(v2[0]);
        
        
        for(int i = 0 ; i < size ; i++){
            if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                return 1;
            }else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                return -1;
            }
        }
        
        return 0;
        
    }
}
