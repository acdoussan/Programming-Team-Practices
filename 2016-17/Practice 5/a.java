//Adam Doussan AD844156 10/15/2016

import java.io.*;
import java.util.*;

public class a
{
	

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		
		HashMap<Integer, String> map = new HashMap<>();

		for(int i = 0; i < run; i++)
		{
			String ans;

			System.out.print(in.nextInt() + " ");

			int N = in.nextInt();

			if(map.containsKey(N))
			{
				System.out.println(map.get(N));
				continue;
			}

			int sum1 = 0, sum2 = 0, sum3 = 0;

			for(int j = 1; j <= N; j++)
			{
				sum1 += j;
			}

			for(int j = 1; j <= (N*2); j += 2)
			{
				sum2 += j;
			}

			for(int j = 0; j <= (N*2); j += 2)
			{
				sum3 += j;
			}

			ans = String.format("%d %d %d",sum1,sum2,sum3);
			
			map.put(N, ans);

			System.out.println(ans);
		}
	}
}
