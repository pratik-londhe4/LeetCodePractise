class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        boolean flag = false;
        // check if ch exists
        int i = 0;
        for( i = 0 ; i < arr.length ; i++){
            if(arr[i] == ch){
                flag = true;
                break;
            }
        }
        if(!flag){
            return word;
        }
        
        // use the ith index to reverse the substring
        for(int j = 0, k = i; j <= k && k > j; j++, k--){
            //swap
            char temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;
            System.out.println(arr);
        }
        
        return new String(arr);
    }
}