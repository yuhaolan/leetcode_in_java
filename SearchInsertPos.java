/*
Question:
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples. 
[1,3,5,6], 5 → 2 
[1,3,5,6], 2 → 1 
[1,3,5,6], 7 → 4 
[1,3,5,6], 0 → 0
*/

//一次性做成功 值得鼓励啊
//思路： 因为是sorted array 所以用binary search 是最好的方法 复杂度 是 log(n)
//		如果找的到 直接返回index
//		如果找不到，还是用binary search 找到 起点和终点 相差为1的时候， 这时候就说明， target 在 起点和终点这个范围里面，
//		那么这时候 比较 target 和 起点 和 终点的大小， 如果比起点大， 那么插入的index应该在终点，如果不是，那么应该在起点
//
//
//because the array have been sorted  so use BINARY SEARCH    the running time is LOG(N)
//Method binary search

public class SearchInsertPos
{
	static int search(int [] arr, int target)
	{
		int result = binsearch(arr,0,arr.length,target);
		if (result > 0)
			return result;
		else
		{
			result = insert(arr,0,arr.length,target);
			return result;

		}

	}

	static int binsearch(int [] arr, int start, int end, int target)
	{
		int mid = (start + end)/2;

		if (start < end)
		{
			if (target < arr[mid])
			{
				return binsearch(arr,start,mid - 1, target);
			}
			if (target == arr[mid])
				return mid;

			return binsearch(arr,mid+1,end,target);
		}
		return -1;
	}

	static int insert(int [] arr, int start, int end, int target)
	{
		int mid = (start + end)/2;

		if (start < end)
		{
			if (target < arr[mid])
			{
				// know the target is between two vaules
				if ((mid-1) - start == 1)
				{
					if (target > arr[start])
						return mid-1;
					else
						return start;
				}
				return binsearch(arr,start,mid - 1, target);
			}
			else
			{
				// know the target is between two vaules

				if (end - (mid+1) == 1)
				{
					if (target > arr[mid+1])
						return end;
					else
						return mid+1;

				}

				return binsearch(arr,mid+1,end,target);
			}
		}
		return -1;



	}

	public static void main(String...args)
	{
		int [] arr = {1,3,5,6};
		int result = search(arr,0);
		System.out.println(result);
	}
}
