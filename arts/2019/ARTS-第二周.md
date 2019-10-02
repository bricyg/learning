## Algorithm
LeetCode 3: [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) Medium

Given a string, find the length of the longest substring without repeating characters.

**Example 1**:

```
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
```

**Example 2**:

```
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

**Example 3**:

```
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

**Code**:

``` java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, flag = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= flag){
                flag = map.get(ch) + 1;
            }
            map.put(ch, i);
            int len = i - flag + 1;
            if (len > maxLen){
                maxLen = len;
            }
        }
        return maxLen;
    }
}
```

## Review
Article: [So You Want to be a Functional Programmer (Part 1)](https://medium.com/@cscalfani/so-you-want-to-be-a-functional-programmer-part-1-1f15e387e536)

该文章是作者介绍函数式编程的第一篇文章，只是初步的介绍了函数式编程的基本概念：

* 纯函数：只操作输入参数；所有的有用纯函数必须有返回值；纯函数具有幂等性；纯函数没有副作用
* 不变性

## Tip
无

## Share
本周分享一个项目: [https://github.com/bytedeco/javacpp-presets](https://github.com/bytedeco/javacpp-presets)

通过java jni对一些常见的c++库进行封装。