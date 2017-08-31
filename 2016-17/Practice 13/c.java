//Adam Doussan AD844156 01/28/2017

import java.io.*;
import java.util.*;

public class c
{
	public static ArrayList<Integer> powers;
	public static int [][] memo;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int pref = in.nextInt();

			int m = in.nextInt();
			int n = in.nextInt();

			powers = new ArrayList<>();
			int temp;

			while((temp = (int)Math.pow(m, powers.size())) < n)
				powers.add(temp);

			memo = new int [powers.size()][n + 1];
			for(int j = 0; j < powers.size(); j++)
				Arrays.fill(memo[j], -1);

			System.out.println(pref + " " + solve(powers.size() - 1, 0, n));
		}
	}

	public static int solve(int power, int sum, int n)
	{
		if(power < 0)
			return 0;

		if(memo[power][sum] != -1)
			return memo[power][sum];

		if(sum + powers.get(power) <= n)
		{
			int ans = solve(power, sum + powers.get(power), n);
			memo [power][sum] = ans;
			return ans;
		}
		
		if(sum == n)
		{
			int ans = 1 + solve(power - 1, sum - powers.get(power), n);
			memo [power][sum] = ans;
			return ans;
		}

		int ans = solve(power - 1, sum, n);
		memo [power][sum] = ans;
		return ans;
	}
}
