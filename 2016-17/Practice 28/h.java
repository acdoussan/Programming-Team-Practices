//Adam Doussan AD844156 06/25/2017

import java.io.*;
import java.util.*;
import java.awt.Point;

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int n = in.nextInt(), m = in.nextInt();
			int [] scores = new int [m];

			for(int i = 0; i < m; i++)
				scores[i] = in.nextInt();

			Arrays.sort(scores);
			int [] ans = new int [1];
			ans[0] = -1;
			boolean [][] seen = new boolean [n+1][n+1];

			solve(n, scores, 0, 0, ans, seen);

			System.out.println(ans[0]);
		}
	}


	public static void solve(int goal, int [] scores, int push, int score, int [] ans, boolean[][] seen)
	{
		if(!seen[push][score])
		{
			seen[push][score] = true;
			for(int i = scores.length - 1; i >= 0; i--)
			{
				if(push + scores[i] + score == goal)
				{
					if(score + scores[i] > ans[0])
						ans[0] = score + scores[i];
				}

				else if(push + scores[i] + score < goal)
					solve(goal, scores, push + scores[i] + score, score + scores[i], ans, seen);
			}
		}
	}

}
