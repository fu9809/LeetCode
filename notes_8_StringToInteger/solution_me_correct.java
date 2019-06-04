class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        if(len == 0) 
            return 0;
        char[] arr = str.toCharArray();
        int a=0;
        if(arr[0] == '-' || arr[0] == '+'){
            a++;
        }
        for(; a < arr.length; a++){
            if(arr[a] == '0'){
                continue;
            }else{
                break;
            }
        }
        char c = arr[0];
        StringBuilder strb = new StringBuilder();
        if(c != '+' && c != '-' && (c < '0' || c > '9')){
            return 0;
        }
        
        if(c == '-' || c == '+'){
            strb.append(c);
        }
            
        for(int i = a ,j = 0; i < len && j < 12; i++,j++){ 
            if(arr[i] < '0' || arr[i] > '9'){
                break;
            }
            strb.append(arr[i]);
        }
        String s = strb.toString();
        if("".equals(s)){
            return 0;
        }
        
        if(s.equals("-") || s.equals("+")){
            return 0;
        }
        Long num = Long.parseLong(s);
        if(num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else if(num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return Integer.valueOf(s);
    }
}
