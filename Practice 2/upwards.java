// Adam Doussan AD844156 09/23/2017

import java.io.*;
import java.util.*;

public class upwards
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int k = in.nextInt()+1, n = in.nextInt(), r = in.nextInt();

			int [] ans = new int [n];

			init(ans, k);

			for(int i = 1; i < r; i++)
			{
				ans[n-1]++;

				if(ans[n-1] > 25)
				{
					int j;
					for(j = n-2; j >= 0; j--)
					{
						if(ans[j]+1 <= 25 - ((n-1-j)*k))
						{
							ans[j]++;
							break;
						}
					}

					fix(ans, j, k);
				}
			}

			StringBuilder ans2 = new StringBuilder();

			for(int i = 0; i < n; i++)
				ans2.append((char)('a' + ans[i]));

			System.out.println(ans2);
		}
	}

	public static void init(int [] ans, int k)
	{
		ans[0] = 0;

		for(int i = 1; i < ans.length; i++)
			ans[i] = ans[i-1]+k;
	}

	public static void fix(int [] ans, int j, int k)
	{
		for(int i = j+1; i < ans.length; i++)
			ans[i] = ans[i-1]+k;
	}
}
