class Solution {
    public String longestPalindrome(String s) {
        if("".equals(s) || s.length() == 1){
            return s;
        }
        int max = 1, start = 0, end = 0, length = s.length();
        for(int i = 0; i < length; i++){
            int len1 = expandAroundCenter(i,i,s);
            int len2 = expandAroundCenter(i,i+1,s);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }   
        return s.substring(start, end + 1);
    }
   
    public int expandAroundCenter(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
