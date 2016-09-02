public class ValidNumbe_STD
{
	public boolean isNumber(String s)
	{
		int i = 0, n = s.length();
		//remove the leading spaces
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		//check the sign
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		//check the digit
		boolean isNumberic = false;
		//find the digit
		while (i < n && Character.isDigit(s.charAt(i)))
		{
			i++;
			isNumberic = true;
		}
		//check the float point
		if (i < n && s.charAt(i) == '.')
		{
			i++;
			//check another part of the digit
			while(i < n && Character.isDigit(s.charAt(i)))
			{
				i++;
				isNumberic = true;
			}
		}
		//check the 'e'
		if (isNumberic && i < n && s.charAt(i) == 'e')
		{
			i++;
			isNumberic = false;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
			while(i < n && Character.isDigit(s.charAt(i)))
			{
				i++;
				isNumberic = true;
			}

		}
		//remove the tailing space
		while(i < n && Character.isWhitespace(s.charAt(i))) i++;
		return isNumberic && i == n;
	}
}