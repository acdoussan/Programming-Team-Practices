//Adam Doussan AD844156 01/28/2017

import java.io.*;
import java.util.*;

public class d
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int pref = in.nextInt();
			int call = in.nextInt();

			System.out.println(pref + " " + toString(solve(call)));
		}
	}

	public static String toString(ArrayList<Integer> ans)
	{
		return String.format("%d/%d", ans.get(0), ans.get(1));
	}

	public static ArrayList<Integer> solve(int call)
	{
		ArrayList<Integer> ans = new ArrayList<>();

		if(call == 1)
		{
			ans.add(1);
			ans.add(1);
			return ans;
		}

		if(call % 2 == 0)
		{
			ArrayList<Integer> parent = solve(call / 2);
			parent.set(1, parent.get(0) + parent.get(1));
			return parent;
		}

		else
		{
			ArrayList<Integer> parent = solve(call / 2);
			parent.set(0, parent.get(0) + parent.get(1));
			return parent;
		}
	}
}
