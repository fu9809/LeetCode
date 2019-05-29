### 罗马数字转整数

#### 题目

罗马数字包含以下七种字符: `I`， `V`， `X`， `L`，`C`，`D` 和 `M`。

```
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

例如， 罗马数字 2 写做 `II` ，即为两个并列的 1。12 写做 `XII` ，即为 `X` + `II` 。 27 写做  `XXVII`, 即为 `XX` + `V` + `II` 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 `IIII`，而是 `IV`。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 `IX`。这个特殊的规则只适用于以下六种情况：

- `I` 可以放在 `V` (5) 和 `X` (10) 的左边，来表示 4 和 9。
- `X` 可以放在 `L` (50) 和 `C` (100) 的左边，来表示 40 和 90。 
- `C` 可以放在 `D` (500) 和 `M` (1000) 的左边，来表示 400 和 900。

给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

**示例 1:**

```
输入: "III"
输出: 3
```

**示例 2:**

```
输入: "IV"
输出: 4
```

**示例 3:**

```
输入: "IX"
输出: 9
```

**示例 4:**

```
输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
```

**示例 5:**

```
输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
```

#### 初始思路

1. 使用 for 循环遍历整个字符串，使用switch-case 语句，规定字符所代表的数字。最后求和。

#### 解法：

1. 使用Map集合的方式，把那些字符对应的值，写成键值对的方式，然后遍历字符串，从map中获取相应的值，相加即可得出结果
   - 这里对那6个特殊字符，有2种处理方式：
     1. 先处理那6种特殊情况，把那些条件都剪切出字符串，然后再处理常规字符。
     2. 把那6个特殊字符当做一个字符，一起做处理

代码实现：

1. 方式一

   ```java
   class Solution {
       public int romanToInt(String s) {
           // 六种特殊情形
           if (s.contains("IV")){
               s = s.replace("IV"," 4 ");
           }
           if (s.contains("IX")){
               s = s.replace("IX"," 9 ");
           }
           if (s.contains("XL")){
               s = s.replace("XL"," 40 ");
           }
           if (s.contains("XC")){
               s = s.replace("XC"," 90 ");
           }
           if (s.contains("CD")){
               s = s.replace("CD"," 400 ");
           }
           if (s.contains("CM")){
               s = s.replace("CM"," 900 ");
           }
   
           // 其他情形
           if (s.contains("I")){
               s = s.replace("I"," 1 ");
           }
           if (s.contains("V")){
               s = s.replace("V"," 5 ");
           }
           if (s.contains("X")){
               s = s.replace("X"," 10 ");
           }
           if (s.contains("L")){
               s = s.replace("L"," 50 ");
           }
           if (s.contains("C")){
               s = s.replace("C"," 100 ");
           }
           if (s.contains("D")){
               s = s.replace("D"," 500 ");
           }
           if (s.contains("M")){
               s = s.replace("M"," 1000 ");
           }
   
           s = s.trim();
           s = s.replace("  "," ");
   
    //       System.out.println(s);
   
           String[] strings = s.split(" ");
   
           int sum = 0;
   
           for (String s1 : strings){
               sum += Integer.parseInt(s1);
           }
   
           return sum;
       }
   }
   ```

2. 方式二

   ```java
   class Solution {
       public int romanToInt(String s) {
           int sum = 0;
           String temp = s;
           for (Map.Entry<String, Integer> entry : roman.entrySet()) {
               s = s.replaceAll(entry.getKey(),"");
               sum += (temp.length() - s.length()) / entry.getKey().length() * entry.getValue();
               temp = s;
           }
           return sum;
       }
       
       private Map<String, Integer> roman = new LinkedHashMap<>();
   
       {
           roman.put("IV",4);
           roman.put("IX",9);
           roman.put("XL",40);
           roman.put("XC",90);
           roman.put("CD",400);
           roman.put("CM",900);
           roman.put("I",1);
           roman.put("V",5);
           roman.put("X",10);
           roman.put("L",50);
           roman.put("C",100);
           roman.put("D",500);
           roman.put("M",1000);
       }
   }
   ```

### 总结

- 判断那 6 个特殊含义的字符时，
  - 初始思路：逐个考虑了代表的数字，没有用到总结思想；
  - 优化思路： 应该总结出那些数字的显而易见且容易用代码实现的规律，在本例中，是使数值减小，进而优化代码。
- 方法有多种，可以多次尝试
