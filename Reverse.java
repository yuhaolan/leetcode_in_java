/*Question:
Given an input string s, reverse the string word by word.
For example, given s = "the sky is blue", return "blue is sky the".
*/
import java.io.*;
//java \\s+ represents one or more spaces
//java \\s+ 表示 有一个或者很多个空格
//alert the head and tail must have no spaces
//注意 首位和尾数 不能有空格
//array's length is array.length
//数组的length 的表示是  parts.length
//string length is  string.length()
//It is recommended to use StringBuilder whenever possible because it is faster than StringBuffer.
// However if thread safety is necessary the best option is StringBuffer objects. 
//
//
public class Reverse
{
	public static String rev(String s)
	{
		String [] parts = s.split("\\s+");
		int length = parts.length;
		StringBuilder result =  new StringBuilder();

		while(length > 0)
		{
			result.append(parts[length - 1]);

			if (length == 1)
				break;

			result.append(" ");

			length--;

		}

		return result.toString();
	}

	public static void main(String...args)
	{
		String result = rev("the sky is blue");
		System.out.println(result);
	}
}
