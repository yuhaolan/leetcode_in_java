/*
Challenge 2:
Rotate an array to the right by k steps in-place without allocating extra space.
For instance, with k = 3, the array [0, 1, 2, 3, 4, 5, 6] is rotated to [4, 5, 6, 0, 1, 2, 3].
*/
//和 reversetwo 对比  注意 reverse的写法 加1 和 减1 两种写法 个人偏向加1
import java.util.*;
public class ReverseThree
{
	public static void reverse_arr(int [] arr, int k)
	{
		reverse(arr,0,arr.length-1);//因为代入的是 最大index 不是长度  所以交换reverse的时候 加1！！！
		reverse(arr,0,arr.length-1-k-1);
		reverse(arr,arr.length-1-k,arr.length-1);
	}
	public static void reverse(int [] arr, int start, int end)
	{
		int temp;
		for(int i = 0;i < (end - start + 1)/2 ; i++)//!!!!
		{
			temp = arr[start+i];
			arr[start+i] = arr[end-i];
			arr[end-i] = temp;

		}
	}

	public static void main(String[] args)
	{
		int [] array = {0,1,2,3,4,5,6};
		reverse_arr(array,3);
		System.out.println(Arrays.toString(array));
	}
}
