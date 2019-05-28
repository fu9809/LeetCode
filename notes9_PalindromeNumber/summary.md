### 回文数

#### 题目

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

**示例 1:**

```
输入: 121
输出: true
```

**示例 2:**

```
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
```

**示例 3:**

```
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
```

#### 初始思路

1. 由示例知，负数都不是回文数
2. 使用数字的方法，把数字反转，如果两数字相等，则为回文数
3. 或者使用字符串的方法，把数字反转，比较两数是否相等
4. 或者使用字符串的方法，取出数字的第一位和最后一位比较，依次取出，直到所有字符都遍历完

#### 代码实现

1. 数字的方法

   ```java
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
   ```

2. 字符串的方法

   ```java
   class Solution {
       public boolean isPalindrome(int x) {
           return String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString());
       }
   }
   ```

3. 字符串逐个比较

   ```java
   class Solution {
       public boolean isPalindrome(int x) {
           String str = String.valueOf(x);
           int i=0,j=str.length()-1;
           while(i<j){
               if(str.charAt(i++)!=str.charAt(j--)){
                   return false;
               }
           }
           return true;
       }
   }
   ```

### 总结

1. 虽然想到了思路，但是代码的实现较臃肿，代码不够简洁

2. 要整理好自己的思路，让思路完全明确之后，并且考虑了众多极端特例，在着手开始代码，注重代码的可读性，简洁性。

   
