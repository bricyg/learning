## Algorithm
LeetCode 2: [Add two number](https://leetcode.com/problems/add-two-numbers/) Medium

**Description**: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example**:

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8

Explanation: 342 + 465 = 807.
```

**Code**:

``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0), p = r;
        boolean carryBit = false;
        while (l1 != null || l2 != null){
            int v1 = (l1 != null)? l1.val: 0;
            int v2 = (l2 != null)? l2.val: 0;
            int val = carryBit? v1 + v2 + 1: v1 + v2;
            carryBit = val >= 10;
            p.next = new ListNode(val % 10);
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carryBit) p.next = new ListNode(1);
        return r.next;
    }
}
```

## Review
这周的英文文章是：[HTML5 Video: Everything I Needed to Know](http://ronallo.com/blog/html5-video-everything-i-needed-to-know/)

该文章有点长，创作时间是2012-12-22。作者由浅入深的讲解了**H5 video**标签的使用，以通俗易懂方式覆盖了`video`标签的大部分功能及JS API，后面还介绍了视频流的范围传输。该文章对要了解和使用`video`的初学者很有帮助。

## Tip
本周Tip主要是Java的函数式编程方面，详见Share部分。

## Share
本次主要分享一篇关于Java Lambda的入门文章，详情见：[Lambda 表达式有何用处？](https://mp.weixin.qq.com/s/-PHOc6p-qKJBktle28AUgA)

作者用通俗易懂的方式描述了什么是Lambda，Lambda的作用以及在Java中常见的Lambda使用场景。我曾经读 [Google Guava UsingAndAvoidingNullExplained](https://github.com/google/guava/wiki/UsingAndAvoidingNullExplained) (翻译见：[使用和避免null](/2018/10/21/UsingAndAvoidingNullExplained) )文档时一直有个问题，如果避免使用**null**，而用**Optional**代替**null**能提供接口的傻瓜式保护，但是并没有提供多大的益处。但是，如果Lambda配合Optional<T>可以使Java对null的处理非常的优雅。例如作者在文中提到：

``` java
Person person = goAndGetAPerson();
Optional<Person> personOpt = Optional.ofNullable(person);
```

如果不使用Lambda，代码是这样：

``` java
if (personOpt.isPresent()) {
	return personOpt.get();
} else {
	return UNKNOWN_PERSON;
}
```

如果使用Lambda，存在则返回，无则返回屁：

``` java
return personOpt.orElse(UNKNOW_PERSON);
```

当然还有其他情况：

``` java
存在则开干：
personOpt.ifPresent(System.out::println);

存在则返回，无则由函数生成：
return personOpt.orElseGet(() -> goAndGetAPerson());

夺命连环null检查：
return personOpt.map(p -> p.getLastName())
			.map(name -> name.toUpperCase())
			.orElse(UNKNOW_PERSON);
```