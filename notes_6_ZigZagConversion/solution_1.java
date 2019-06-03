class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int len = s.length();
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        int rows = Math.min(numRows, len);
        for (int i = 0; i < rows; i++){
            list.add(new StringBuilder());
        }
            
        int row = 0;
        boolean flag = false;
        for(char c : s.toCharArray()){
            list.get(row).append(c);
            if(row == 0 || row == numRows-1){
                flag = !flag;
            }
            row += flag ? 1 : -1;
        }
        for(StringBuilder sb : list){
            ret.append(sb);
        }
        return ret.toString();
    }
}
