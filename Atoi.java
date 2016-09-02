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

public class Atoi
{
	static final int MAX = 214748364;
	static final int MIN = -214748364;
	public static int atoi(String s)
	{
		int value = 0;
		int result = 0;
		int flag = 0;
		int record = -1;
		for(int i = 0; i < s.length(); i++)
		{
			//ignore blanks
			if (s.charAt(i) == ' ')
				continue;
			// "+" or "-"
			if (s.charAt(i) == '-')
			{
				flag = -1;
				continue;
			}
			if (s.charAt(i) == '+')
			{
				flag = 1;
				continue;
			}
			//check the first char
			if (record < 0 && Character.isDigit(s.charAt(i)) != true )
			{
				record = i;
				return 0;
			}
			
			record = i;

			if (Character.isDigit(s.charAt(i)))
			{
				value = Character.getNumericValue(s.charAt(i));

				//check the max and min
				//注意 极值应该除10！！！，下一个各位数如果大于7  或者 8 那么就会超出范围了
				//alert!  the MAX_VALUE needs to be divided by 10 and if next number is bigger than 7 or 8 that will exceeds the MAX and MIN

				if (flag*result >= Integer.MAX_VALUE/10 && value>7)
					return Integer.MAX_VALUE;

				if (flag*result < Integer.MIN_VALUE/10 && value>8)
					return Integer.MIN_VALUE;
				
				System.out.println(value);
				result = 10*result + value;
				System.out.println("=="+result);
				System.out.println(">"+Integer.MIN_VALUE);		
				
			}
			//The string can contain additional characters after those that form the integral number, 

			if (Character.isDigit(s.charAt(i)) != true)
				break;

		}
		return flag*result;
	}
	public static void main(String[] args)
	{
		int result = atoi("   -1111112222jfdsjf");
		System.out.println(result);
	}
}
