/*
Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

得到差值 在数组用二分法找  并且验证 找到的数 和 index1不是同一个数
*/
import java.util.*;

public class TwoSum2
{
	static int [] twosum(int [] nums, int target)
	{
		int i = 0;
		int [] index = new int[2];
		for(int num : nums)
		{
			i++;
			int diff = target - num;

			int result = binsearch(nums,0,nums.length-1,diff);



			if (result > 0)
			{
				if (result == target)
				{
					return null;//if find the same two value!!!
				}

				index[0] = i;
				index[1] = result + 1;
				return index;
			}
		}
		return null;
		//throw new IllegalArgumentException("No two sum solution");
	}
	static int binsearch(int [] arr, int start, int end, int target)
	{
		if (end > start)//记住这个先决条件 不然一直忘记！！！
		{
			int mid = (start + end)/2;
			if (target == arr[mid])
			{
				System.out.println("mid =" + mid);
				return mid;
			}

			if (target > arr[mid])
			{
				System.out.println(">");
				return binsearch(arr,mid+1,end,target);//如果没有写return，那么递归调用完这个函数，就继续执行下一条语句，即  System.out.println("<");

			}


			System.out.println("<");
			return binsearch(arr,start,mid-1,target);


		}
		return -1;

		
	}

	public static void main(String...args)
	{
		int [] arr = {2,3,11,15};
		int target = 13;
		int [] result = twosum(arr,target);
		System.out.println(Arrays.toString(result));

	}
}