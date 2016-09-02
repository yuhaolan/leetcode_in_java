/*3. Two Sum III – Data structure design
Code it now: Coming soon! Difficulty: Easy, Frequency: N/A
Question:
Design and implement a TwoSum class. It should support the following operations: add and find.
add(input) – Add the number input to an internal data structure.
find(value) – Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5); find(4)true; find(7)false
*/
import java.util.*;
//用 list 这个数据结构； 用复杂度为n的首尾扫一遍的方法。但是 前提必须是 这个数组sort了！！！！
//更为普遍的方式是 hashmap  对于 没有sort的数组来说
//这里 我们用find（）表明 用扫一遍的方法 数组已经sort了  find1() ===> binarysearch  also apply to sorted array
//find2() =====>hashmap
//记得考虑 和是两个相同数的情况。 到底是一个数算了两次 还是 真的有两个一样的数
//


public class TwoSum3
{
	static List<Integer> arr = new ArrayList<Integer>();

	public static void add(int i)
	{
		arr.add(i);
	}
	//scan index0 accompany with index(length-1)
	//based on sorted array
	//add O(1) find O(n) store O(n)
	public static boolean find(int target)
	{
		int i = 0;
		int j = arr.size() - 1;//list has size but array has length

		//System.out.println(j);
		while(i < j)
		{
			if(arr.get(i) + arr.get(j) > target)
			{
				j--;
			}
			else if (arr.get(i) + arr.get(j) < target)
			{
				i++;
			}
			else if (arr.get(i) + arr.get(j) == target)
			{
				return true;
			}
		}

		return false;
	}
	//binary search to sorted array
	//add O(1) find O(log n) store O(n)

	public static boolean find1(int target)
	{
		int i = 0;
		while(i < arr.size())
		{
			int diff = target - arr.get(i);
			int result = binsearch(0,arr.size(),diff);
			i++;

			if(result > 0 )
			{
				if (result == i-1)
					return false;//make sure the duplicates have not get same number twice!!!


				return true;
			}


		}
		return false;

	}
	public static int binsearch(int start, int end, int target)
	{
		int mid = (start + end)/2;
		if (start < end)
		{
			if ( arr.get(mid) > target )
			{
				return binsearch(start,mid-1,target);
			}
			if (arr.get(mid) == target)
				return mid;

			return binsearch(mid+1,end,target);

		}
		return -1;

		
	}

	//Hash map to unsorted array
	//add O(1) find O(n) store (n)
	public static boolean find2(int target)
	{
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		int i = 0;
		while(i < arr.size())
		{
			int diff = target - arr.get(i);
			if(hash.containsKey(diff))
			{
				if(hash.get(diff) == i)
					return false;//make sure the duplicates have not get same number twice!!!


				return true;
			}
			else
			{
				hash.put(arr.get(i),i);
			}
			++i;


		}
		return false;
	}

	


	public static void main(String...args)
	{
		add(1);
		add(2);
		add(3);
		add(5);
		boolean result = find2(6);
		System.out.println(result);
		TwoSum obj = new TwoSum();
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(5);
		boolean result1 = obj.find(10);
		System.out.println(result1);

		//find(4);
		//find(7);
	}
}
//add into hash table key
// find the diff= target - i; int all keys(containsKey)
class TwoSum
{
	private HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();

	public void add(int i)
	{
		int count = (hash.containsKey(i)) ? hash.get(i) : 0;
		hash.put(i,count + 1);
	}

	public boolean find(int target)
	{
    	for (Map.Entry<Integer, Integer> entry : hash.entrySet()) 
    	{	
    		int key = entry.getKey();
    		int diff = target - key;

    		if(key == diff)
    		{
    			if(entry.getValue() >= 2)
    			{
    				return true;//make sure the duplicates have not get same number twice!!!
    			}
    		} 
    		else if(hash.containsKey(diff))
    		{
    			return true;
    		}

    	}
    	return false;

    }












}
