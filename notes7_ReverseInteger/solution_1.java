class Solution {
    public int reverse(int x) {
        int max = (int)(Math.pow(2,31)-1), min= (int)Math.pow(-2,31);
        if(x == 0 || x <= min || x >= max){
            return 0;
        }
        int sign = 1,x1 = x;
       
        if(x < 0){
            sign = 0;
            x1 = Math.abs(x);
        }
        StringBuffer strB1 = new StringBuffer(String.valueOf(x1));
        int j = strB1.length() - 1;
        while(strB1.charAt(j) == '0'){
            strB1.deleteCharAt(j);
            j--;
        }
        
        if(sign == 0){
            strB1.append('-');
        }
        StringBuffer strB2 = strB1.reverse();
        
        String str = strB2.toString();
        long xx = Long.parseLong(str);
        if(xx < min || xx > max ){
            return 0;
        }
        return (int)xx;
        
    }
}
