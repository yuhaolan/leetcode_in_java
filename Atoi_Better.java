/*
8. String to Integer (atoi)

Implement atoi to convert a string to an integer.

	The atoi function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 

	Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, 

and interprets them as a numerical value.

	The string can contain additional characters after those that form the integral number, 
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. 

If the correct value is out of the range of representable values, 

the maximum integer value (2147483647) or the minimum integer value (–2147483648) is returned.
*/
//多用while loop！！


public class Atoi_Better
{
	private static final int MAX_DIV_10 = Integer.MAX_VALUE/10;
	public static int atoi(String s)
	{
		int value = 0;
		int result = 0;
		int sign = 1;
		int i = 0;
		int n = s.length();
		//discard the whitespace chars

		while( i < n && Character.isWhitespace(s.charAt(i)) )
			i++;
		

		//注意啊！！  i 小于 s.length() 要放在前面！！！！记住啊  所有的string 操作 必须 记住 啊！！！！！
		//注意啊！！  i 小于 s.length() 要放在前面！！！！记住啊  所有的string 操作 必须 记住 啊！！！！！
		//注意啊！！  i 小于 s.length() 要放在前面！！！！记住啊  所有的string 操作 必须 记住 啊！！！！！
		//注意啊！！  i 小于 s.length() 要放在前面！！！！记住啊  所有的string 操作 必须 记住 啊！！！！！
		//alert!! i < s.length() must be putted in the front place!!!

		
		//optional plus or minus
		//注意 i 要小于 string的长度
		if (i < n && s.charAt(i) == '+')
		{
			i++;
		}
		else if (i < n && s.charAt(i) == '-')
		{
			sign = -1;
			i++;
		}
		//the first
		if (i<n &&!Character.isDigit(s.charAt(i)))
		{
			return 0;
		}


		//if it is number
		//注意啊！！  i 小于 s.length() 要放在前面！！！！记住啊  所有的string 操作 必须 记住 啊！！！！！
		while(i < n && Character.isDigit(s.charAt(i)) )
		{
			value = Character.getNumericValue(s.charAt(i));

			if (result >= MAX_DIV_10 && value > 7)
			{
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = 10*result + value;
			i++;
		}
		return sign*result;
	}
	public static void main(String[] args)
	{
		int result = atoi("      ");
		System.out.println(result);
	}
}
