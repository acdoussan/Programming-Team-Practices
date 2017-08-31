// Adam Doussan AD844156 02/18/2017

import java.io.*;
import java.util.*;

public class mad
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		while(run != 0)
		{
			int sum = 0;

			StringBuilder ans = new StringBuilder();

			for(int i = 0; i < run; i++)
			{
				int temp = in.nextInt();

				for(int j = 0; j < temp - sum; j++)
					ans.append(String.format("%d ", i + 1));

				sum += temp - sum;
			}

			System.out.println(ans.toString().trim());

			run = in.nextInt();
		}
	}
}
