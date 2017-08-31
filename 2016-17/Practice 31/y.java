//Adam Doussan AD844156 07/15/2017

import java.io.*;
import java.util.*;

public class y
{
	public static int ans;
	public static HashSet<String> seen;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int [] nums = new int [9];

			for(int i = 0; i < 9; i++)
				nums[i] = in.nextInt();

			ans = 0;
			seen = new HashSet<>();
			solve(nums, new boolean [9], new int [9], 0);

			System.out.println(ans);
		}
	}

	public static boolean magic(int [] guess)
	{
		int [] r = new int [3];
		int [] c = new int [3];

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				r[i] += guess[(i*3)+j];
			}

			for(int j = 0; j < 3; j++)
			{
				c[i] += guess[i +(j*3)];
			}
		}

		boolean ans = true;
		for(int i = 0; i < 3; i++)
		{
			if(r[i] != r[(i+1)%3])
			{
				ans = false;
				break;
			}

			if(c[i] != c[(i+1)%3])
			{
				ans = false;
				break;
			}
		}

		return ans && (r[0] == c[0]);
	}

	public static void solve(int [] nums, boolean [] used, int [] guess, int depth)
	{
		if(depth == 9)
		{
			String temp = getString(guess);
			if(!seen.contains(temp) && magic(guess))
			{
				seen.add(temp);
				ans++;
			}
			return;
		}

		for(int i = 0; i < 9; i++)
		{
			if(!used[i])
			{
				used[i] = true;
				guess[depth] = nums[i];
				solve(nums, used, guess, depth+1);
				used[i] = false;
			}
		}
	}

	public static String getString(int [] guess)
	{
		StringBuilder ans = new StringBuilder();

		for(int i = 0; i < 9; i++)
			ans.append(guess[i]);

		return ans.toString();
	}
}
