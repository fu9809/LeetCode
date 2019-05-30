class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <1){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        char[] c = strs[0].toCharArray();
        int a = 0;
        String s = "";
        while(a < c.length){
            s = s.concat(c[a] + "");
            a++;
            for(int i = 1; i < strs.length; i++){
                if(!strs[i].startsWith(s)){
                    s = s.substring(0,s.length()-1);
                    return s;
                }
            }
        }
        return s;
    }
}
