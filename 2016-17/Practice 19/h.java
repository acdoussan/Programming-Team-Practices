// Adam Doussan AD844156 04/01/2017

import java.io.*;
import java.util.*;

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int n = in.nextInt();

			if(n == 1)
			{
				in.nextInt();
				System.out.println("YES");
				continue;
			}

			long [] seen = new long [n];

			for(int j = 0; j < n; j++)
			{
				seen[j] = in.nextLong();
			}

			boolean ans = false;

			for(int j = 0; j < 4; j++)
			{
				if(j == 0)
				{
					boolean thisTest = true;
					for(int k = 1; k < n - j; k++)
					{
						if(seen[k - 1] != seen[k])
						{
							thisTest = false;
							break;
						}
					}

					if(thisTest)
					{
						ans = true;
						break;
					}
				}

				else
				{
					boolean thisTest = true;
					for(int k = 0; k < n - j; k++)
					{
						seen[k] = seen[k+1] - seen[k];
					}

					for(int k = 1; k < n - j; k++)
					{
						if(seen[k] != seen[k - 1])
						{
							thisTest = false;
							break;
						}
					}

					if(thisTest)
					{
						ans = true;
						break;
					}
				}
			}

			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static boolean constTest(long[] test)
	{
		for(int i = 0; i < test.length; i++)
		{
			if(test[i] != 0)
				return false;
		}

		return true;
	}

	public static boolean linTest(long[] test)
	{
		for(int i = 1; i < test.length; i++)
		{
			if(test[i] != test[i-1])
				return false;
		}

		return true;
	}

	public static boolean sqTest(long[] test)
	{
		boolean temp1 = true;
		boolean temp2 = true;

		for(int i = 1; i < test.length; i++)
		{
			if(test[i] != test[i-1] * 2)
			{
				temp1 = false;
				break;
			}
		}
/*
		for(int i = 1; i < test.length; i++)
		{
			if(test[i] != test[i-1] / 2)
			{
				temp2 = false;
				break;
			}
		}
*/
		return temp1;// || temp2;
	}

	public static boolean cbTest(long[] test)
	{
		boolean temp1 = true;
		boolean temp2 = true;

		for(int i = 1; i < test.length; i++)
		{
			if(test[i] != test[i-1] * 3)
			{
				temp1 = false;
				break;
			}
		}
/*
		for(int i = 1; i < test.length; i++)
		{
			if(test[i] != test[i-1] / 3)
			{
				temp2 = false;
				break;
			}
		}
*/
		return temp1;// || temp2;
	}
}
