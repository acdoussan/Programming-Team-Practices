//Adam Doussan AD844156 01/21/2017

import java.io.*;
import java.util.*;

class Bridge
{
	public int cap, time;

	Bridge(int cap, int time)
	{
		this.cap = cap;
		this.time = time;
	}
}

class Event implements Comparable<Event>
{
	public int eventTime, bridge, people;

	Event(int eventTime, int bridge, int people)
	{
		this.eventTime = eventTime;
		this.bridge = bridge;
		this.people = people;
	}

	public int compareTo(Event a)
	{
		if(this.eventTime - a.eventTime != 0)
			return this.eventTime - a.eventTime;
		return this.bridge - a.bridge;
	}
}

public class bridges
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int B = 0 - in.nextInt(), P = in.nextInt();

		while(true)
		{
			if(B == 0 && P == 0)
				return;

			Bridge [] bridges = new Bridge [B];

			for(int i = 0; i < B; i++)
			{
				bridges[i] = new Bridge(in.nextInt(), in.nextInt());
			}

			int [] people = new int [B + 1];
			boolean [] crossing = new boolean[B];

			people[0] = P;
			int currentTime = 0;

			PriorityQueue<Event> events = new PriorityQueue<>();

			if(people[0] <= bridges[0].cap)
			{
				events.add(new Event( currentTime + bridges[0].time, 1, people[0]));
				people[0] = 0;
				crossing[0] = true;
			}

			else
			{
				events.add(new Event( currentTime + bridges[0].time, 1, bridges[0].cap));
				people[0] -= bridges[0].cap;
				crossing[0] = true;
			}

			while(!events.isEmpty())
			{
				Event next = events.remove();

				people[next.bridge] += next.people;
				crossing[next.bridge - 1] = false;
				currentTime = next.eventTime;

				//System.out.println(next.people + " crossed bridge " + next.bridge + " at time " + next.eventTime);

				if(people[next.bridge - 1] != 0)
				{
					if(people[next.bridge - 1] <= bridges[next.bridge - 1].cap)
					{
						events.add(new Event( currentTime + bridges[next.bridge - 1].time,
													 next.bridge, people[next.bridge - 1]));
						people[next.bridge - 1] = 0;
						crossing[next.bridge - 1] = true;
					}

					else
					{
						events.add(new Event( currentTime + bridges[next.bridge - 1].time,
													 next.bridge, bridges[next.bridge - 1].cap));
						people[next.bridge - 1] -= bridges[next.bridge - 1].cap;
						crossing[next.bridge - 1] = true;
					}
				}

				if(next.bridge == B || crossing[next.bridge])
					continue;

				else
				{
					if(people[next.bridge] != 0)
					{
						if(people[next.bridge] <= bridges[next.bridge].cap)
						{
							events.add(new Event( currentTime + bridges[next.bridge].time,
														 next.bridge + 1, people[next.bridge]));
							people[next.bridge] = 0;
							crossing[next.bridge] = true;
						}

						else
						{
							events.add(new Event( currentTime + bridges[next.bridge].time,
														 next.bridge + 1, bridges[next.bridge].cap));
							people[next.bridge] -= bridges[next.bridge].cap;
							crossing[next.bridge] = true;
						}
					}
				}				
					
			}

			System.out.println(currentTime);

			B = 0 - in.nextInt(); P = in.nextInt();
		}
	}
}
