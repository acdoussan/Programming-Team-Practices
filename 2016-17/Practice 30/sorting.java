//Adam Doussan AD844156 07/13/2017

import java.io.*;
import java.util.*;

class ans implements Comparable<ans>
{
	int inv; String perm;

	public ans(int inv, String perm)
	{
		this.inv = inv; this.perm = perm;
	}

	public int compareTo(ans o)
	{
		return this.perm.compareTo(o.perm);
	}

	public String toString()
	{
		return this.perm;
	}
}

public class sorting
{
	public static int diff;
	public static PriorityQueue<ans> ans;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		in.nextLine();

		while(size != 0)
		{
			ans = new PriorityQueue<>();

			boolean [][] less = new boolean [size][size];

			diff = Integer.MAX_VALUE;

			for(int i = 0; i < size; i++)
			{
				String temp = in.nextLine();

				for(int j = 0; j < size; j++)
					less[i][j] = (temp.charAt(j) == '1') ? true : false;
			}

			genAns(less, new int [size], new boolean [size], size, 0);

			ans ret = ans.remove();
			System.out.println(ret.perm);
			System.out.println(ret.inv);

			size = in.nextInt();
			in.nextLine();
		}
	}

	public static void genAns(boolean [][] less, int [] guess, boolean [] used, int size, int depth)
	{
		if(depth == size)
		{
			String temp = genGuess(guess);
			int inv = count(guess, less);

			if(inv < diff)
			{
				diff = inv;
				ans = new PriorityQueue<>();
				ans.add(new ans(inv, temp));
			}

			else if(inv == diff)
			{
				ans.add(new ans(inv, temp));
			}
		}

		else
		{
			for(int i = 0; i < size; i++)
			{
				if(!used[i])
				{
					used[i] = true;
					guess[depth] = i;
					genAns(less, guess, used, size, depth+1);
					used[i] = false;
				}
			}
		}
	}

	public static String genGuess(int [] guess)
	{
		StringBuilder ans = new StringBuilder();

		for(int i = 0; i < guess.length; i++)
			ans.append(guess[i] + ((i == guess.length - 1) ? "" : " "));

		return ans.toString();
	}

	public static int count(int [] guess, boolean [][] less)
	{
		int ans = 0;

		for(int i = 0; i < guess.length; i++)
			for(int j = i + 1; j < guess.length; j++)
				if(less [guess[j]][guess[i]])
					ans++;

		return ans;
	}
}
