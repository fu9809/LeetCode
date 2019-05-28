### 无重复字符的最长子串

#### 题目

给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。

**示例 1:**

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2:**

```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3:**

```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

#### 初始思路

- 看到题目的第一眼，毫无思绪，思考一段时间后，有一点儿思路

- 定义2个变量（num=1 ,max=1），2个指针，先取出一个字符，和另一个相比，如果不同就num+1，相同的时候，就比较num和max，如果num比max大，就 max = num；遍历整个字符串

- 初始代码

  ```java
  public int lengthOfLongestSubstring(String s) {
      int num = 1,max=1,len = s.length();
      for(int i=0;i < len-max; i++){
          for(int j=i+1; j < len-max;j++){
              if((s.charAt(i)) == (s.charAt(j))){
                  if(num > max){
                      max = num;
                      num = 1;
                  }
                  break;
              }else{
                  num++;
              }
          }
      }
      return max;
  }
  ```

- 错误

#### 出现的问题或不足

1. 取出第二层字符的指针，只和第一层的一个特定的字符比较，没有考虑到，第二个指针指向的第一个字符和第二个字符的比较，如果第二个字符和第三个字符相同，此解法识别不了，还会继续往后进行。此解法错误。
2. 如果按照最初思路，应该改为，当第二个指针往后移动一位的时候，就需要再把前边的每个数据再遍历一次，按照初始思路，这是无法实现的。

### 解法

#### 解法一

1. list集合

   ````java
   public int lengthOfLongestSubstring(String s) {
       List list = new ArrayList();
       List<List> parentList = new ArrayList();
       char[] chars = s.toCharArray();
   
       for (int i = 0; i < chars.length; i++) {
           list = new ArrayList();
           for (int j = i; j < chars.length; j++) {
               if (list.contains(chars[j])){
                   break;
               }
               list.add(chars[j]);
           }
           parentList.add(list);
       }
       int length = 0;
       int max_length = 0 ;
       for (int i = 0; i < parentList.size(); i++) {
           length = parentList.get(i).size();
           if (length>max_length){
               max_length = length;
           }
       }
       System.out.println(max_length);
       return max_length;
   }
   ````

2. 此解法是利用了list集合，把字符串中所有的不包含重复字符的子串都存入到集合中，然后比较每一个集合的长度，取出最长的那个。

3. 还有很多利用集合的方式，比如，map，queue等，都是这个思想

#### 最优解法

- 仍然是定义2个变量（num【没有出现重复字符的下标】, max【最大的子串长度】），2个指针，第一个指针从0遍历到最后一个，第二个指针，从num 开始遍历，到第一个指针指向的字符时结束。
- 当遇到和第一个指针相同的字符时，记录num的值，为第二个指针指向的下标 + 1，跳出本次循环，判断此次遍历子串的长度，是否比max大，（不重复子串的长度为：第一个指针的下标 - num的下标 + 1）。
- 直至遍历到最后一个字符

### 总结

1. 当我看到利用集合解题的方法后，发现自己考虑问题时不周到，不全面，没有想到用集合的方法来判断是否含有重复的字符。我的初始思路，从前往后遍历，第二个指针如果换成一个集合，只需判断字符是否在集合中存在即可，是可以完成任务的。思考了很久却没有想到，知识点还是没有融会贯通。
2. 了解了最优解法的思想，从前往后遍历，不容易解决问题的时候，可以更改为从后往前遍历。
3. 虽然最优解法并不容易想到，但是利用集合的方式来解决问题，问题就显得很简单。以后考虑问题，要尝试着从集合的角度考虑。