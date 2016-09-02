//Given an input string s, reverse the string word by word.
//For example, given s = "the sky is blue", return "blue is sky the".
//Similar to Question [6. Reverse Words in a String], but with the following constraints:
//“The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
//Could you do it in-place without allocating extra space?
//Another important feature of String is that it's immutable. 
//You can pass a String to any method and be sure that this method won't change the contents of the String. 
//That is not the case with a char array.
//!!	O(n) runtime, O(1) space – In-place reverse:
//做不来 好难！
//思路 首先 用 reverse 把 整个数组倒过来	然后再根据空格 reverse 每一个单词
//!! s[j] == ' ' || j == s.length   vs   j == s.length || s[j] == ' '
//后者正确  因为 如果 j＝＝s.length 那么 这个数组 就outofbound！！！ 所以 它应该写前面

import java.util.*;
public class Reversetwo
{
	public void reverseWord(char[] s)
	{
		reverse(s,0,s.length);// 代入的是长度 本来就多1 所以写reverse 的时候 （end － begin）／2 不用加1了！！！！！！！！
		System.out.println("==" + Arrays.toString(s));

		for(int i = 0, j = 0; j <= s.length; j++)
		{
			if ( j == s.length || s[j] == ' ')
			{
				reverse(s,i,j);
				i = j + 1;
			}
		}

		String str = new String(s);
		System.out.println(str);
		System.out.println(Arrays.toString(s));
		
	}
	


	private void reverse (char[] s, int begin, int end)
	{
		for (int i = 0; i < (end - begin) / 2 ; i++)
		{
			char temp = s[begin + i];
			s[begin + i] = s[end - i - 1];//之所以减去1 是因为 s[length] is out of range!!!! 
			s[end - i - 1] = temp;
		}
		
	}

	public static void main(String...args)
	{
		Reversetwo obj = new Reversetwo();
		char [] s = "a ba".toCharArray();
		obj.reverseWord(s);
	}



}
















/*
public class Reversetwo
{

	reverseword(char[] s)
	{
		int length = s.length;
		int index = length - 1;
		int i = j = temp = 0;
		while (index >= 0)
		{

			if (s[index] == ' ')
			{
				j = index;
				i = temp;
				temp = j;

				if (i > 0)
					reverse(s,j,i);
			}

			index--;

			if (index == 0)
				reverse(s,0,j);
		}
	}

	reverse(char[] s,j,i)
	{

	}


}
*/