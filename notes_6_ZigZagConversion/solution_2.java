class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows <= 1 || len < numRows){
            return s;
        }
        char[] arr = s.toCharArray();
        int cycleLen = 2 * numRows - 2;
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < len; j += cycleLen){
                ret.append(arr[j]);
                if(i != 0 && i != numRows - 1 && j + cycleLen -2*i <len){
                    ret.append(arr[j + cycleLen -2*i]);
                }
            }
        }
        return ret.toString();
    }
}
