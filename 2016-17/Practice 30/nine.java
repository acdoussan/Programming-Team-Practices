// Adam Doussan AD844156 07/11/2017

import java.io.*;
import java.util.*;

class ans implements Comparable<ans>
{
	String rep;
	int diff;
	
	public ans(String rep, int diff)
	{
		this.rep = rep;
		this.diff = diff;
	}

	public int compareTo(ans o)
	{
		if(this.diff == o.diff)
			return this.rep.compareTo(o.rep);
		return this.diff - o.diff;
	}

	public String toString()
	{
		return rep;
	}
}

public class nine
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		String test = in.nextLine();

		while(!test.equals("00:00"))
		{
			int time = getVal(test);

			int diff = search(time);

			ArrayList<ans> ans = new ArrayList<>();
			int num9 = 0;

			for(int guess = time - diff; guess <= time + diff; guess++)
			{
				if(inRange(guess))
				{
					ArrayList<String> reps = getRep(guess);

					for(String s : reps)
					{
						int temp = count9(s);

						if(num9 < temp)
						{
							ans = new ArrayList<>();
							ans.add(new ans(s, Math.abs(time - guess)));
							num9 = temp;
						}

						else if(num9 == temp)
						{
							ans.add(new ans(s, Math.abs(time - guess)));
						}
					}
				}
			}

			Collections.sort(ans);

			System.out.println(ans.get(0));

			//for(String s : ans)
			//	System.out.println(s);

			//System.out.println();

			test = in.nextLine();
		}
	}

	public static int getVal(String test)
	{
		int time = 0;

		time += (test.charAt(0) - '0') * 600;
		time += (test.charAt(1) - '0') * 60;
		time += (test.charAt(3) - '0') * 10;
		time += (test.charAt(4) - '0');

		return time;
	}

	public static int search(int ori)
	{
		int hi = 10000, lo = 0;

		while(lo < hi-1)
		{
			int mid = ((hi-lo)/2) + lo;

			if(isValid(ori, ori+mid))
				lo=mid;
			else
				hi=mid;
		}

		if(isValid(ori, ori+hi))
			return hi;
		else
			return lo;
	}

	public static boolean isValid(int ori, int guess)
	{
		return 10 * Math.abs(ori-guess) < ori;
	}

	public static boolean inRange(int guess)
	{
		return guess <= 6039 && guess >= 0;
	}

	public static ArrayList<String> getRep(int time)
	{
		ArrayList<String> ans = new ArrayList<>();

		if(time <= 99)
			ans.add(String.format("00:%02d", time));

		if(time < 60)
			return ans;

		int min = time / 60;
		int sec = time % 60;

		ans.add(String.format("%02d:%02d", min, sec));

		if(sec+60 <= 99 && min > 0)
			ans.add(String.format("%02d:%02d", min-1, sec+60));

		return ans;
	}

	public static int count9(String test)
	{
		int ans = 0;

		for(char c : test.toCharArray())
			if(c == '9')
				ans++;

		return ans;
	}
}
