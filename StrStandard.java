public class StrStandard
{
	public static int Str(String haystack, String needle)
	{
		for (int i = 0; ; i++)
		{
			for (int j = 0; ; j++)
			{
				if (j == needle.length()) return i;
				if (i + j == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}

	public static void main(String...args)
	{
		int result = Str("ha","lanyuhao");
		System.out.println(result);
	}
}