class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        ArrayList<Fraction> list = new ArrayList<>();
        
        for(int j = arr.length - 1 ; j  >= 0 ; j--){
            for(int i = 0 ; i < j ; i++){
                double val  = arr[i] /(double) arr[j];
                
                list.add(new Fraction(val, arr[i], arr[j]));
            }
        }
        
        Collections.sort(list, new CompareFraction() );
        
        Fraction ans = list.get(k-1);
        
        return new int[]{ans.num, ans.den};
    }
    
    class Fraction{
        double val;
        int num, den;
        
        public Fraction(double val, int num, int den){
            this.val = val;
            this.num = num;
            this.den = den;
        }
    }
    
    class CompareFraction implements Comparator<Fraction> {
        
        public int compare(Fraction a, Fraction b){
            if(a.val > b.val){
                return 1;
            }else if(a.val < b.val){
                return -1;
            }else return 0;
        }
    }
}



















