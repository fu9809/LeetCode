class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = 0, xx = x;
        while(xx != 0){
            num = xx%10 + num*10;
            xx = xx/10;
        }
        if(num == x)
            return true;
        return false;
    }
}
