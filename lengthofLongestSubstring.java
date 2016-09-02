/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
//需要两个变量i j 一个定头一个定尾。 记住 每当j 走到一个重复字符的时候，那么i就需要走到被重复字符的位置。
//并且i之前所有的字符要转换为false，因为题目要求仅仅找出 子字符串不含重复
import java.util.*;
import java.lang.*;

public class lengthofLongestSubstring
{
	public static int check (String s)
	{
		boolean [] arr = new boolean [256];
		int n = s.length();
		int i = 0;
		int result = 0;
		for (int j = 0; j < n; j++)
		{
			while (arr[s.charAt(j)])
			{
				arr[s.charAt(i)] = false;
				i++;
			}

			arr[s.charAt(j)] = true;

			result = Math.max(j-i+1,result);

		}
		return result;
	}

	public static void main(String[] args)
	{
		int result = check("pwwkew");
		System.out.println(result);
	}
}