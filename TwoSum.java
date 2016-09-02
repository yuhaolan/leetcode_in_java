/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

Subscribe to see which companies asked this question
*/
import java.util.*;

public class TwoSum
{

    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int [] arr = new int [2];

        for(int i = 0; i < nums.length; i++)
        {
            int diff = target - nums[i];
            //check having
            if (map.containsKey(diff))
            {
                if (nums[i] > map.get(diff))
                {
                    arr[0] = map.get(diff);//index!!!
                    arr[1] = i;//!!!!
                }
                else
                {
                    arr[0] = i;
                    arr[1] = map.get(diff);
                }

                return arr;
            }
            //not having 
            map.put(nums[i],i);//value key

        }
        return null;
    }

        
    






    public static void main(String...args)
    {
        int [] array = {2,7,11,15,3};
        int [] array1 = new TwoSum().twoSum(array,17);
        System.out.println(Arrays.toString(array1));
        
    }
}