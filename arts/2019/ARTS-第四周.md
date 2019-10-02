## Algorithm
LeetCode 5: [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) Medium

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

**Example 1**:

```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

**Example 2**:

```
Input: "cbbd"
Output: "bb"
```

**Code**:

``` java
class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++){
            String tmp = longestPalindrome(s, i);
            if (max.length() < tmp.length()){
                max = tmp;
            }
        }
        return max;
    }
    
    private String longestPalindrome(String s, int index) {
        int i = index, j = index;
        while (i >= 0 && s.charAt(index) == s.charAt(i)) i--;
        while (j < s.length() && s.charAt(index) == s.charAt(j)) j++;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
```

## Review
[So You Want to be a Functional Programmer (Part 3)](https://medium.com/@cscalfani/so-you-want-to-be-a-functional-programmer-part-3-1b0fd14eb1a7)

全文主要分为3部分：

* 第一部分主要讲**函数组合(Function Composition)**，杜绝重复代码，将各个单一功能函数通过函数组合方式组合成更强大的函数。

> Code reuse sounds great but is difficult to achieve. Make the code too specific and you can’t reuse it. Make it too general and it can be too difficult to use in the first place.

* 第二部分是**Point-Free Notation**，一种函数式编程风格，编写函数时不用指定函数参数。
* 第三部分是使用Function Composition和Point-Free Notation的一些问题。

## Tip
最近在研究 [Alibaba Sentinel](https://github.com/alibaba/Sentinel) 的源码，这周的Tip是关于Sentinel资源调用链的设计思想，该调用链是使用了责任链模式来设计的，具体可参考Share部分的博客分享。

## Share
[限流降级神器-哨兵(sentinel)的资源调用链原理分析](https://mp.weixin.qq.com/s/UEzwD22YC6jpp02foNSXnw)

sentinel限流降级核心就是一堆Slot组成的调用链。