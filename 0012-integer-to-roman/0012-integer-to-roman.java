class Solution {
    public String intToRoman(int num) {
        Queue<Symbol> q = new LinkedList<Symbol>();
        
        q.add(new Symbol("M", 1000));
        q.add(new Symbol("CM", 900));
        q.add(new Symbol("D", 500));
        q.add(new Symbol("CD", 400));
        q.add(new Symbol("C", 100));
        q.add(new Symbol("XC", 90));
        q.add(new Symbol("L", 50));
        q.add(new Symbol("XL", 40));
        q.add(new Symbol("X", 10));
        q.add(new Symbol("IX", 9));
        q.add(new Symbol("V", 5));
        q.add(new Symbol("IV", 4));
        q.add(new Symbol("I", 1));
        String ans = "";
        while(!q.isEmpty()){
            Symbol curr = q.remove();
            int quantity = num/curr.val;
            if(quantity > 0){
                num%=curr.val;
                for(int i = 0 ; i < quantity ; i++)
                    ans+=curr.symb;
            }            
            
            }
        
        return ans;

    }
}

class Symbol {
    String symb;
    int val;
    public Symbol(String symb, int val){
        this.symb = symb;
        this.val = val;
    }
}