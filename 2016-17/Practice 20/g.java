// Adam Doussan AD844156 04/08/2017

import java.io.*;
import java.util.*;

public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int [] ans = new int [1000001];

		for(int i = 1; i < 1000000; i++)
		{
			int start = i+1;
			ans[start]++;

			for(int j = i; j>1; j--)
			{
				start += j;
				try
				{
					ans[start]++;
				}
				catch(Exception e)
				{
					break;
				}
			}
		}

		int test = in.nextInt();

		while(test!=0)
		{
			System.out.println(ans[test]);
			test = in.nextInt();
		}
	}
}
