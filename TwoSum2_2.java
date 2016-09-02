/*
Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
/*
O(n) runtime, O(1) space – Two pointers:
Let’s assume we have two indices pointing to the ith and jth elements, Ai and Aj
respectively. The sum of Ai and Aj could only fall into one of these three possibilities:
i. Ai + Aj > target. Increasing i isn’t going to help us, as it makes the sum even
bigger. Therefore we should decrement j.
ii. Ai + Aj < target. Decreasing j isn’t going to help us, as it makes the sum even
smaller. Therefore we should increment i.
iii. Ai + Aj == target. We have found the answer.

首位扫一遍的方法
一个在头
一个在尾
因为数组sort了
*/

import java.util.*;

public class TwoSum2_2
{
	public static int [] twosum(int [] arr, int target)
	{
		int i = 0;
		int j = arr.length - 1;
		int [] index = new int [2];

		while(j > i)
		{
			if (arr[i] + arr[j] > target)
			{
				j--;

			}
			else if (arr[i] + arr[j] < target)
			{
				i++;
			}
			else if (arr[i] + arr[j] == target)
			{
				index[0] = i+1;
				index[1] = j+1;
				return index;

			}
		}
		return null;
	}

	public static void main(String...args)
	{
		int [] arr = {2,3,11,15};
		int target = 15;
		int [] result = twosum(arr,target);
		System.out.println(Arrays.toString(result));

	}
}