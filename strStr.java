/*
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class strStr
{
	public static int check(String needle, String haystack)
	{
		//注意 首先去思考所有的先决条件！！！
		if (haystack.length() == 0)
			return -1;
		//!!!!!
		if (needle.length() > haystack.length())
			return -1;
		//!!!!!
		if (needle.length() == 0)
			return 0;

		int imax = needle.length();
		int jmax = haystack.length();

		for(int j = 0; j < jmax; j++ )
		{
			//System.out.println("j=" + j);
			//System.out.println(haystack.charAt(j));
			//System.out.println("i=" + i);
			int i = 0;
			int oldi = i;
			int oldj = j;
			//System.out.println(haystack.charAt(j));
			while(haystack.charAt(j) == needle.charAt(i))
			{
				i++;
				j++;
				//在循环内部判断 是否检查完了 如果在外部 因为for loop i早晚都会到最大 没意义 return oldj记住！！！ 是最初的坐标
				if(i == imax)
				{
					return oldj;
					
				}
			}
				i = oldi;
				j = oldj;
			
		}
	return -1;

	}	

	public static void main(String...args)
	{
		int result = check("aaaaaaaa","aaaaaa");
		System.out.println(result);
	}
}