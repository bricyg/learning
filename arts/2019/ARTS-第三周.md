## Algorithm
LeetCode 4: [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) Hard

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

**Example 1**:

```
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```

**Example 2**:

```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```
**Code**:

``` java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int p1 = 0, p2 = 0, preV = 0, count = 0;
        while (count < len / 2){
            if (p1 < nums1.length && p2 < nums2.length && nums1[p1] <= nums2[p2]){
                preV = nums1[p1];
                p1++;
            } else if (p2 < nums2.length){
                preV = nums2[p2];
                p2++;
            } else {
                preV = nums1[p1];
                p1++;
            }
            count++;
        }
        if ((len & 1) == 0){
            if (p1 < nums1.length && p2 < nums2.length){
                return nums1[p1] <= nums2[p2]? (preV + nums1[p1])/(double)2: (preV + nums2[p2])/(double)2;
            }
            if (p1 < nums1.length){
                return (preV + nums1[p1])/(double)2;
            }
            return (preV + nums2[p2])/(double)2;
        } else {
            if (p1 < nums1.length && p2 < nums2.length){
                return nums1[p1] <= nums2[p2]? nums1[p1]: nums2[p2];
            }
            if (p1 < nums1.length){
                return nums1[p1];
            }
            return nums2[p2];
        }
    }
}
```

Runtime: 2 ms, faster than 100.00% of Java online submissions for Median of Two Sorted Arrays.

Memory Usage: 45.6 MB, less than 95.39% of Java online submissions for Median of Two Sorted Arrays.

But the code is not graceful.

## Review
Article: [So You Want to be a Functional Programmer (Part 2)](https://medium.com/@cscalfani/so-you-want-to-be-a-functional-programmer-part-2-7005682cec4a)

通过重构一段代码引出高阶函数，又介绍了函数式编程里面的闭包。

## Tip
本周的Tip是 [ServiceLoader](https://docs.oracle.com/javase/8/docs/api/java/util/ServiceLoader.html)，一般用于SPI的设计与实现。

1. 创建一个接口
2. 在项目的classpath(例如spring boot的resources目录下)创建META-INF/services文件夹
3. 在services文件夹下创建文件，文件名为接口全名，内容为为该接口的默认实现

Example:

``` java
package site.bitinit;

// 接口
public interface Info{
	String getName();
	String getAddress();
}

// 实现
public class Man implements Info{
	@Override
	public String getName(){
		return "john";
	}
	@Override
	public String getAddress(){
		return "xx1";
	}
}
public class Woman implements Info{
	@Override
	public String getName(){
		return "mary";
	}
	@Override
	public String getAddress(){
		return "xx2";
	}
}

// 文件
文件名：site.bitinit.Info
内容：  site.bitinit.Man

// 测试
public class TestServiceLoader{
	public static void main(String[] args){
		ServiceLoader<Info> serviceLoader = ServiceLoader.load(Info.class);
		for (Info info: serviceLoader){
			System.out.Println(info.getName() + ": " + info.getAddress());
		}
	}
}

// 结果
john: xx1
```

## Share
本周分享：[HTTP API认证授权术](https://coolshell.cn/articles/19395.html)

耗子叔对API认证技术的归纳与总结，基本上全面覆盖了HTTP认证方面的所有知识。