//Adam Doussan AD844156 10/15/2016

import java.io.*;
import java.util.*;

class Fib
{
	HashMap<Double,Integer> map;
	ArrayList<ArrayList<Double>> seen;

	Fib()
	{
		map = new HashMap<>();
		seen = new ArrayList<>();
		ArrayList<Double> temp = new ArrayList<>();
		temp.add(1.0);
		temp.add(1.0);
		temp.add(2.0);
		temp.add(3.0);
		seen.add(temp);
	}

	int getFib(double num)
	{
		if(map.containsKey(num))
			return map.get(num);
		if(num < 3)
			return 1;
		if(num == 3)
			return 2;

		ArrayList<Double> start = findBiggestSeen(num);

		int ans = getFibHelp(num, start);

		map.put(num,ans);

		return ans;
	}

	int getFibHelp(double num, ArrayList<Double> biggestSeen)
	{
		int [] ans = new int [3];

		double temp1 = biggestSeen.get(0);
		double temp2 = biggestSeen.get(1);
		double temp3 = biggestSeen.get(2);

		ans[0] = (int) temp1;
		ans[1] =	(int) temp2;
		ans[2] = (int) temp3;

		for(double i = biggestSeen.get(3) - 1; i < num - 1; i++)
		{
			ans[0] = ans[1];
			ans[1] = ans[2];
			int temp = (ans[0] + ans [1]);
			ans[2] = (temp > 1000000000) ? temp - 1000000000 : temp;
		}

		ArrayList<Double> temp = new ArrayList<>();

		temp.add((double)ans[0]);
		temp.add((double)ans[1]);
		temp.add((double)ans[2]);
		temp.add(num);

		insert(temp);

		return ans[2];
	}

	ArrayList<Double> findBiggestSeen(double num)
	{
		if(seen.size() < 2)
			return seen.get(0);

		//System.out.println("looking for " + num);

		int start = 0, end = seen.size() - 1, look = ((end - start) / 2) + start;

		while(start < end)
		{
			//System.out.println("looking");
			look = ((end - start) / 2) + start;

			if(seen.get(look).get(3) < num)
			{
				start = look + 1;
			}
			if(seen.get(look).get(3) > num)
			{
				end = look - 1;
			}
			else // Data found
			{
				// This should be unreachable because we check if we have seen this
				// number before on line 24
			}
		}

		//System.out.println("found " + seen.get(look + 1).get(3));
		return seen.get(look + 1);
	}

	// inserts in sorted order
	void insert(ArrayList<Double> temp)
	{
		if(temp.get(3) > seen.get(seen.size() - 1).get(3))
		{
			seen.add(temp);
			return;
		}

		seen.add(seen.get(seen.size() - 1));

		int i;
		for(i = seen.size() - 1; i > 0; i--)
		{
			if(seen.get(i).get(3) > temp.get(3))
				seen.set(i, seen.get(i - 1));
			else
				break;
		}

		seen.set(++i, temp);
	}

	void insertAt(ArrayList<Double> temp, int index)
	{
		
	}

	public String toString()
	{
		String ans = "";

		for(int i = 0; i < seen.size(); i++)
		{
			ans = ans + seen.get(i).get(3) + " ";
		}
		
		return ans;
	}
	
}

public class c
{
	public static void main(String [] args)
	{
		new c();
	}

	c()
	{
		Scanner in = new Scanner(System.in);
		Fib fibo = new Fib();

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			System.out.print(in.nextInt() + " ");
			System.out.println(fibo.getFib(in.nextDouble()));
			//System.out.println(fibo);
		}
	}
}
