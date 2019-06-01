class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')'){
                if(stack.empty()){
                    return false;
                }
                if(stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}

/*
 * else if() {
 *	if ()
 *	这里可以换成 || && 
 * }
 * */
