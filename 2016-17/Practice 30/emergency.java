//Adam Doussan AD844156 07/08/2017

import java.io.*;
import java.util.*;

class treat implements Comparable<treat>
{
	int pri, dur;

	public treat(int pri, int dur)
	{
		this.pri = pri; this.dur = dur;
	}

	public int compareTo(treat o)
	{
		return o.pri - this.pri;
	}
}

class patient implements Comparable<patient>
{
	PriorityQueue<treat> treats;
	int arrive;
	boolean arrived;

	public patient(int arrive)
	{
		treats = new PriorityQueue<>();
		this.arrive = arrive;
		this.arrived = false;
	}

	public void add(treat t)
	{
		treats.add(t);
	}

	public int treat()
	{
		return treats.remove().dur;
	}

	public boolean finished()
	{
		return treats.size() == 0;
	}

	public int compareTo(patient o)
	{
		if(arrived)
		{
			int temp = o.treats.peek().pri - this.treats.peek().pri;

			if(temp != 0)
				return temp;
		}

		return this.arrive - o.arrive;
	}
}

class doc implements Comparable<doc>
{
	patient p;
	int end;
	boolean finished;

	public doc(patient p, int clock)
	{
		treat(p, clock);
		finished = false;
	}

	public void treat(patient p, int clock)
	{
		this.p = p;
		this.end = clock + p.treat();
	}

	public int compareTo(doc o)
	{
		if(finished)
		{
			return p.arrive - o.p.arrive;
		}
		return this.end - o.end;
	}
}

public class emergency
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int docNum = in.nextInt(), time = in.nextInt();
		int c = 0;

		while(true)
		{
			c++;

			if(docNum == 0 && time == 0)
				break;

			System.out.format("Case %d:\n", c);

			int arrive = in.nextInt();

			PriorityQueue<patient> waitingRoom = new PriorityQueue<>();
			PriorityQueue<patient> arrivals = new PriorityQueue<>();
			PriorityQueue<doc> docs = new PriorityQueue<>();

			while(true)
			{
				if(arrive == -1)
					break;

				patient p = new patient(arrive);
				int pri = in.nextInt(), dur = in.nextInt();

				while(true)
				{
					if(pri == 0 && dur == 0)
						break;

					p.add(new treat(pri, dur));

					pri = in.nextInt();
					dur = in.nextInt();
				}

				arrivals.add(p);

				arrive = in.nextInt();
			}

			if(time < arrivals.peek().arrive)
			{
				time = arrivals.peek().arrive;
			}

			while(arrivals.peek() != null && time >= arrivals.peek().arrive)
			{
				patient p = arrivals.remove();
				p.arrived = true;
				waitingRoom.add(p);
			}

			while(available(docs, docNum) && waitingRoom.size() > 0)
			{
				docs.add(new doc(waitingRoom.remove(), time));
			}

			while(moreToServe(waitingRoom, arrivals, docs))
			{
				if(arrivals.peek() == null || (docs.peek() != null && docs.peek().end < arrivals.peek().arrive))
				{
					if(docs.peek() == null)
					{
						while(available(docs, docNum) && waitingRoom.size() > 0)
						{
							docs.add(new doc(waitingRoom.remove(), time));
						}
					}

					else
					{
						ArrayList<doc> done = new ArrayList<>();
						doc d = docs.remove();
						d.finished = true;
						time = d.end;
						done.add(d);

						while(docs.peek() != null && docs.peek().end == time)
						{
							d = docs.remove();
							d.finished = true;
							done.add(d);
						}

						Collections.sort(done);

						for(doc temp : done)
						{
							if(temp.p.finished())
							{
								System.out.format("Patient %d released at clock = %d\n", temp.p.arrive, time);
							}

							else
							{
								waitingRoom.add(temp.p);
							}
						}

						while(available(docs, docNum) && waitingRoom.size() > 0)
						{
							docs.add(new doc(waitingRoom.remove(), time));
						}
					}
				}

				else if(arrivals.peek() != null)
				{
					patient p = arrivals.remove();
					time = p.arrive;
					p.arrived = true;
					waitingRoom.add(p);

					while(available(docs, docNum) && waitingRoom.size() > 0)
					{
						docs.add(new doc(waitingRoom.remove(), time));
					}
				}

				else
				{
					while(available(docs, docNum) && waitingRoom.size() > 0)
					{
						docs.add(new doc(waitingRoom.remove(), time));
					}
				}
			}

			docNum = in.nextInt();
			time = in.nextInt();
		}
	}

	public static boolean available(PriorityQueue<doc> docs, int docNum)
	{
		return docs.size() < docNum;
	}

	public static boolean moreToServe(PriorityQueue<patient> waitingRoom, PriorityQueue<patient> arrivals, PriorityQueue<doc> docs)
	{
		return waitingRoom.size() > 0 || arrivals.size() > 0 || docs.size() > 0;
	}
}
