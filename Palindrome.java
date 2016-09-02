/*
Question:
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
Example Questions Candidate Might Ask:
Q: What about an empty string? Is it a valid palindrome?
A: For the purpose of this problem, we define empty string as valid palindrome.
*/
//必须要熟悉 Java.lang.Character Class
//里面很有现成的函数 可以调用
//记住 忽略大小写
//还有 记住  要忽略 不是数字和字母的 字符！！！！ 
//
//http://www.tutorialspoint.com/java/lang/java_lang_character.htm
//http://www.tutorialspoint.com/java/java_strings.htm
import java.io.*;
public class Palindrome
{
	static boolean check(String s)
	{
		boolean flag = false;
		if (s.length() == 0)
		{
			flag = true;
			return flag;
		}

		int i = 0;
		int j = s.length() - 1;



		while ( i < j)
		{
			//skip the char is not Letter and Digit
			while (	Character.isLetterOrDigit(s.charAt(i)) != true	)
				i++;
			//skip the char is not Letter and Digit
			while(	Character.isLetterOrDigit(s.charAt(j)) != true	)
				j--;
			//skip big or small case letters
			if (	Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j)) )
			{
				i++;
				j--;
			}
			else
			{
				return false;
			}


		}
		return true;
		 	
			
			
			
			
		

	}

	public static void main(String...args)
	{
		boolean flag = check("A manswdsf, a plan, a canal: Panama");
		System.out.println(flag);
	}



}

