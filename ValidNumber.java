/*
9. Valid Number
Code it now: https://oj.leetcode.com/problems/valid-number/
Question:
Validate if a given string is numeric. Some examples:
"0"   true "0.1"   true "abc"   false
Example Questions Candidate Might Ask:
Difficulty: Easy, Frequency: Low
  Q: How to account for whitespaces in the string?
A: When deciding if a string is numeric, ignore both leading and trailing whitespaces.
Q: Should I ignore spaces in between numbers – such as “1 1”?
A: No, only ignore leading and trailing whitespaces. “1 1” is not numeric.
Q: If the string contains additional characters after a number, is it considered valid?
A: No. If the string contains any non-numeric characters (excluding whitespaces and decimal point), it is not numeric.
Q: Is it valid if a plus or minus sign appear before the number? A: Yes. “+1” and “-1” are both numeric.
Q: Should I consider only numbers in decimal? How about numbers in other bases such as hexadecimal (0xFF)?
A: Only consider decimal numbers. “0xFF” is not numeric.
Q: Should I consider exponent such as “1e10” as numeric?
A: No. But feel free to work on the challenge that takes exponent into consideration. (The Online Judge problem does take exponent into account.)
*/
public class ValidNumber
{

/*
s1. Leading whitespaces (optional).
s2. Plus (+) or minus (–) sign (optional).
s3. Number.
s4. Optional trailing whitespaces (optional).
*/

	//注意  用if i＝＝n   判断 全部为空格  符号等情况  所以每次完 记得检查
	//关于检查数字 分成三类  整数  小数  和 科学表示方法
	public static boolean check(String s)
	{
		int n = s.length();
		boolean result = false;
		int i = 0;

		//ignore the leading whitespeaces
		while(i < n && Character.isWhitespace(s.charAt(i))) i++;
		//check the sign + and - 
		if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) i++;
		//check numbers
		while(i < n && Character.isDigit(s.charAt(i)))
		{
			i++;
			result = true;
		}
		//check the float point
		//3.  .3
		if (i < n && s.charAt(i) == '.')
		{
			i++;
			while (i < n && Character.isDigit(s.charAt(i)))
			{
				i++;
				result = true;
			}
		}
		// check the 'e'
		if (i < n && result && s.charAt(i) == 'e')
		{
			i++;
			//e behind must the digit
			result = false;
			//check the sign - +
			if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) i++;
			//check the number
			while (i < n && Character.isDigit(s.charAt(i)))
			{
				i++;
				result = true;
			}
		}
		
		
		//check blank and tail whitespace
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        //check the i == n  can ignore other characters
		return i==n && result;
		

	}

	public static void main(String[] args)
	{
		boolean result = check("   3e10      ");
		System.out.println(result);
	}
}