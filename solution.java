class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int num = 0,len = arr.length;
        for(int i=0; i < len; i++){
            switch(arr[i]){
// 优化前，自己写的代码
                case 'I': 
                    if(i+1 >= len){
                        num += 1;
                        break;
                    }
                    if(arr[i+1] == 'V'){
                        num += 4;
                        i++;
                    }else if(arr[i+1] == 'X'){
                        num += 9;
                        i++;
                    }else{
                        num += 1;
                    }
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if(i+1 >= len){
                        num += 10;
                        break;
                    }
                    if(arr[i+1] == 'L'){
                        num += 40;
                        i++;
                    }else if(arr[i+1] == 'C'){
                        num += 90;
                        i++;
                    }else{
                        num += 10;
                    }
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if(i+1 >= len){
                        num += 100;
                        break;
                    }
                    if(arr[i+1] == 'D'){
                        num += 400;
                        i++;
                    }else if(arr[i+1] == 'M'){
                        num += 900;
                        i++;
                    }else{
                        num += 100;
                    }
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
// 优化后的代码
/*
 		case 'I': 
                    if(i+1 >= len){
                        num += 1;
                        break;
                    }
                    if(arr[i+1] == 'V' || arr[i+1] == 'X'){
                        num -= 1;
                    }else{
                        num += 1;
                    }
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if(i+1 >= len){
                        num += 10;
                        break;
                    }
                    if(arr[i+1] == 'L' || arr[i+1] == 'C'){
                        num -= 10;
                    }else{
                        num += 10;
                    }
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if(i+1 >= len){
                        num += 100;
                        break;
                    }
                    if(arr[i+1] == 'D' || arr[i+1] == 'M'){
                        num -= 100;
                    }else{
                        num += 100;
                    }
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
 */
            }
        }
        return num;
    }
}
