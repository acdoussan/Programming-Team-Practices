//Adam Doussan AD844156 06/03/2017

import java.io.*;
import java.util.*;

public class arabic
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			boolean arab = false, eng = false;
			int idx = 0;

			int numWord = in.nextInt();

			String[] words = new String[numWord];

			for(int i = 0; i < numWord; i++)
			{
				words[i] = in.next();
				boolean skip = false;

				for(int j = 0; j < words[i].length(); j++)
					if(words[i].charAt(j) != '#')
					{
						idx = i;
						eng = true;
						skip = true;
						break;
					}
				if(!skip)
				{
					arab = true;
				}
			}

			StringBuilder ans = new StringBuilder();

			if(arab && eng)
			{
				for(int i = idx+1; i < numWord; i++)
					ans.append(words[i] + " ");

				ans.append(words[idx] + " ");

				for(int i = 0; i < idx; i++)
					ans.append(words[i] + " ");
			}

			else
			{
				for(int i = 0; i < numWord; i++)
					ans.append(words[i] + " ");
			}

			System.out.println(ans.toString().trim());
		}
	}
}
