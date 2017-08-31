// Adam Doussan AD844156 07/29/2017

import java.io.*;
import java.util.*;

class car implements Comparable<car>
{
	int t, v;
	int at = 0;

	public car(int t, int v)
	{
		this.t = t; this.v = v;
	}

	public int compareTo(car o)
	{
		return this.t - o.t;
	}
}

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			int car = in.nextInt();

			PriorityQueue<car> cars = new PriorityQueue<>();

			for(int i = 0; i < car; i++)
			{
				cars.add(new car(in.nextInt(), in.nextInt()));
			}

			int ans = solve(cars);

			System.out.println(ans);
		}
	}

	public static int solve(PriorityQueue<car> cars)
	{
		HashSet<car> onRoad = new HashSet<>();
		car temp = cars.remove();
		onRoad.add(temp);

		int time = temp.t;

		int [] highway = new int [101];
		highway[0] = 1;

		while(cars.size() > 0 && time == cars.peek().t)
		{
			highway[0]++;
			onRoad.add(cars.remove());
		}

		int max = highway[0];

		while(time <= 10000 && onRoad.size() > 0)
		{
			time++;

			ArrayList<car> remove = new ArrayList<>();

			for(car c : onRoad)
			{
				highway[c.at]--;

				if(c.at + c.v >= 101)
				{
					remove.add(c);
					continue;
				}

				highway[c.at+c.v]++;

				if(highway[c.at+c.v] > max)
					max = highway[c.at+c.v];

				c.at = c.at+c.v;
			}

			for(car c : remove)
			{
				onRoad.remove(c);
			}

			while(cars.size() > 0 && time == cars.peek().t)
			{
				highway[0]++;
				onRoad.add(cars.remove());
			}

			if(highway[0] > max)
				max = highway[0];

			if(onRoad.size() == 0 && cars.size() > 0)
			{
				temp = cars.remove();
				onRoad.add(temp);
				time = temp.t;

				while(cars.size() > 0 && time == cars.peek().t)
				{
					highway[0]++;
					onRoad.add(cars.remove());
				}
			}
		}

		return max;
	}
}
