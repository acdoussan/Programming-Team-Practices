//Adam Doussan AD844156 10/29/2016

import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex>
{
	int id, aCost, bCost, diff;

	Vertex(int id, int aCost, int bCost)
	{
		this.id = id;
		this.aCost = aCost;
		this.bCost = bCost;
		this.diff = bCost - aCost;
	}

	public int compareTo(Vertex v)
	{
		return this.diff - v.diff;
	}

	public String toString()
	{
		return String.format("[%d,%d,%d,%d]", id, aCost, bCost, diff);
	}
}

public class balloons
{
	balloons()
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt(), A = in.nextInt(), B = in.nextInt();

		while(true)
		{
			if(run == 0 && A == 0 && B == 0)
				break;

			int [] need = new int[run];
			Vertex [] points = new Vertex[run];
			

			for(int i = 0; i < run; i++)
			{
				need[i] = in.nextInt();
				points[i] = new Vertex(i, in.nextInt(), in.nextInt());
			}

			int dist = 0;
			
			Arrays.sort(points);

			int aIndex = points.length - 1, bIndex = 0;
			boolean updated = true;

			while(updated)
			{
				updated = false;

				if(points[aIndex].diff >= 0 && A > 0)
				{
					if(A - need[points[aIndex].id] >= 0)
					{
						A -= need[points[aIndex].id];
						dist += need[points[aIndex].id] * points[aIndex].aCost;
						need[points[aIndex].id] = 0;
					}
					else
					{
						need[points[aIndex].id] -= A;
						dist += A * points[aIndex].aCost;
						A = 0;

						B -= need[points[aIndex].id];
						dist += need[points[aIndex].id] * points[aIndex].bCost;
						need[points[aIndex].id] = 0;
					}

					updated = true;
					aIndex--;
				}

				if(points[bIndex].diff <= 0 && B > 0)
				{
					if(B - need[points[bIndex].id] >= 0)
					{
						B -= need[points[bIndex].id];
						dist += need[points[bIndex].id] * points[bIndex].bCost;
						need[points[bIndex].id] = 0;
					}
					else
					{
						need[points[bIndex].id] -= B;
						dist += B * points[bIndex].bCost;
						B = 0;

						A -= need[points[bIndex].id];
						dist += need[points[bIndex].id] * points[bIndex].aCost;
						need[points[bIndex].id] = 0;
					}

					updated = true;
					bIndex++;
				}
			}

			if(B == 0)
			{
				for(; aIndex >= bIndex; aIndex--)
				{
					A -= need[points[aIndex].id];
					dist += need[points[aIndex].id] * points[aIndex].aCost;
					need[points[aIndex].id] = 0;
				}
			}

			if(A == 0)
			{
				for(; bIndex <= aIndex; bIndex++)
				{
					B -= need[points[bIndex].id];
					dist += need[points[bIndex].id] * points[bIndex].bCost;
					need[points[bIndex].id] = 0;
				}
			}

			System.out.println(dist);

			run = in.nextInt(); A = in.nextInt(); B = in.nextInt();
		}
	}

	public static void main(String [] args)
	{
		new balloons();
	}
}
