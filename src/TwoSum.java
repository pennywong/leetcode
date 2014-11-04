// Problem Link: https://oj.leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * 
 * Output: index1=1, index2=2
 * 
 * @author Penny
 */
public class TwoSum {
	/**
	 * 1.最简单直观的方式是所有的数都两两相加进行判断，但时间复杂度是O(N^2)
	 * 
	 * for(i -> n) for(j=i+1 -> n) if(numbers[i] + numbers[j] == target) return;
	 * 
	 * 2.也可以先将数据进行排序，然后内部循环每次都进行二分查找，时间复杂度变成O(NlogN)，但排序后的序号已经被改变，要注意维护好原来数据的序号
	 * ( 可以用一个map去记录)，也要注意数值相同的情况
	 * 
	 * 3.最优的办法参考自https://github.com/haoel/leetcode/blob/master/src/twoSum/twoSum
	 * .cpp 只需要用一个map就能够将第二个内部循环由O(N)变成O(1)，同时利用一点巧妙的处理，整个算法只需要O(N)即可
	 * 
	 */
	public static int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			Integer index = map.get(numbers[i]);
			// 没有找到
			if (index == null)
				// 这里注意，不是将numbers[i]放进去，而是将target-numbers[i]
				map.put(target - numbers[i], i);
			else
				return new int[] { index + 1, i + 1 };
		}

		return null;
	}
}
