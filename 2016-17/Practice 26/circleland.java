//Adam Doussan AD844156 06/03/2017

import java.io.*;
import java.util.*;

public class circleland
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int numR = in.nextInt();
			int[] dist = new int [numR];
			int[] runSum = new int [numR + 1];

			for(int i = 0; i < numR; i++)
			{
				dist[i] = in.nextInt();
				runSum[i+1] = runSum[i] + dist[i];
			}

			int ans = (runSum[runSum.length - 2] < runSum[runSum.length - 1] - runSum[1]) ?
						runSum[runSum.length - 2] : runSum[runSum.length - 1] - runSum[1];

			for(int i = 0; i < numR; i++)
			{
				int left = runSum[i];
				int right = runSum[runSum.length-1] - runSum[i+1];

				int temp = 2*left + right;

				if(temp < ans)
					ans = temp;

				temp = 2*right + left;

				if(temp < ans)
					ans = temp;
			}

			System.out.println(ans);
		}
	}
}
