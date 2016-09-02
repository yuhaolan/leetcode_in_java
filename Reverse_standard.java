/*Question:
Given an input string s, reverse the string word by word.
For example, given s = "the sky is blue", return "blue is sky the".
*/
//!!!  " " is a string
//!!!  ' ' is a character
// so s.charAt(i) == " " is wrong, because error: incomparable types: char and String
//substring(beginIndex, endIndex) 
//beginIndex -- the begin index, inclusive.
//endIndex -- the end index, exclusive 所以 j 是 全长 不用剪去1 因为 exclusive
//!!! 
//			if ( i == 0 || s.charAt(i-1) == ' ' )   vs 			if ( s.charAt(i-1) == ' ' || i == 0)
//第一个写法才是正确的  因为如果是第二种 如果i＝0 那么 i－1就是－1 这样就会throw exception！！！！ 注意啊！！！


public class Reverse_standard
{
	public static String reverseWords(String s) 
	{ 
		StringBuilder reversed = new StringBuilder(); 
		int j = s.length();
		for ( int i = s.length() - 1; i >= 0; i--)
		{
			
			if ( i == 0 || s.charAt(i-1) == ' ' )
			{
				if (reversed.length() != 0)
					reversed.append(' ');

				System.out.println("i = " + i + "j = " + j);
				reversed.append(s.substring(i,j));
			}
			else if (s.charAt(i) == ' ')
			{
				j = i;
				System.out.println("j = " + j);
			}

		}
		return reversed.toString();
	}

	public static void main(String [] args)
	{
		String result = reverseWords("the sky is blue");
		System.out.println(result);
	}





}
