// Adam Doussan AD844156 03/04/2017

import java.io.*;
import java.util.*;

class player implements Comparable<player>
{
	String name;
	int level;
	int [] scores;
	int total;

	player(String name, int level, int [] scores, int total)
	{
		this.name = name;
		this.level = level;
		this.scores = scores;
		this.total = total;
	}

	public int compareTo(player p)
	{
		if(this.level != p.level)
			return p.level - this.level;
		if(this.total != p.total)
			return p.total - this.total;
		for(int i = 0; i < level; i++)
		{
			if(this.scores[i] != p.scores[i])
				return p.scores[i] - this.scores[i];
		}

		return this.name.compareTo(p.name);
	}

	public String toString()
	{
		return String.format("%s", this.name);
	}
}
public class highscore
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 1; i <= run; i++)
		{
			int players = in.nextInt();

			PriorityQueue<player> pq = new PriorityQueue<>();

			for(int j = 0; j < players; j++)
			{
				String name = in.next();
				int level = in.nextInt();
				int [] scores = new int [level];
				int sum = 0;

				for(int k = 0; k < level; k++)
				{
					scores[k] = in.nextInt();
					sum += scores[k];
				}

				pq.add(new player(name, level, scores, sum));
			}

			System.out.println("Game #" + i);

			while(!pq.isEmpty())
				System.out.println(pq.remove());
		}
	}
}
