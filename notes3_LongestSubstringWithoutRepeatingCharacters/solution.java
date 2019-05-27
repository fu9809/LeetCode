class Solution {
    public int lengthOfLongestSubstring(String s) {
        int num = 0,max=0,len = s.length();
        for(int i=0;i < len; i++){
            for(int j=num; j < i;j++){
                if((s.charAt(i)) == (s.charAt(j))){
                    num = j + 1;
                    break;
                }
            }
            if(max < i - num + 1){
                max = i - num + 1;
            }
        }
        return max;
    }
}
