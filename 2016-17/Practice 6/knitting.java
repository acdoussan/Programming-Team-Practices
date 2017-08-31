//Adam Doussan AD844156 10/22/2016

import java.io.*;
import java.util.*;

public class knitting
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int N,M,K;
		int [] pattern;

		do
		{
			N = in.nextInt();
			M = in.nextInt();
			K = in.nextInt();
			pattern = new int[K];

			for(int i = 0; i < K; i++)
				pattern[i] = in.nextInt();

		solve(N,M,K,pattern);
		
		}while(N != 0 && M != 0 && K != 0);
	}

	public static void solve(int N, int M, int K, int [] pattern)
	{
		if(N == 0 && M == 0 && K == 0)
			return;

		int sum = N;

		for(int i = 0; i < M - 1; i++)
		{
			N = (N + pattern[i % K]);
			sum += N;			
		}

		System.out.println(sum);
	}
}
