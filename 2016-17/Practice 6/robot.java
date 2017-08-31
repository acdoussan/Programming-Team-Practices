//Adam Doussan AD844156 10/22/2016

import java.io.*;
import java.util.*;

class Point
{
	int x, y, penalty;

	Point(int x, int y, int penalty)
	{
		this.x = x;
		this.y = y;
		this.penalty = penalty;
	}
}

class Vertex implements Comparable<Vertex>
{
	int id;
	double dist;

	Vertex(int id, Double dist)
	{
		this.id = id;
		this.dist = dist;
	}

	public int compareTo(Vertex v)
	{
		double temp = this.dist - v.dist;
		if(temp > 0.0)
			return (int)Math.ceil(temp);
		return (int)Math.floor(temp);
	}
}

public class robot
{
	public static void main(String [] args)
	{
		new robot();
	}

	robot()
	{
		Scanner in = new Scanner(System.in);

		int numPoints = in.nextInt();

		while(numPoints != 0)
		{
			double [][] adjMat = new double[numPoints + 2][numPoints + 2];
			fillBottom(adjMat);

			ArrayList<Point> points = new ArrayList<>();
			points.add(new Point(0,0,0));

			for(int i = 0; i < numPoints; i++)
			{
				points.add(new Point(in.nextInt(),in.nextInt(),in.nextInt()));
			}

			points.add(new Point(100,100,0));

			for(int i = 0; i < adjMat.length; i++)
			{
				for(int j = i+1; j < adjMat[0].length; j++)
				{
					adjMat[i][j] = dist(points.get(i), points.get(j)) + 1;

					for(int k = j - 1; k >= i + 1; k--)
					{
						adjMat[i][j] += points.get(k).penalty;
					}
				}
			}

			//printMatrix(adjMat);

			System.out.format("%.3f\n", dik(adjMat));

			numPoints = in.nextInt();
		}
	}

	public void printMatrix(double [][] adjMat)
	{
		for(int i = 0; i < adjMat.length; i++)
		{
			for(int j = 0; j < adjMat[0].length; j++)
			{
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void fillBottom(double [][] adjMat)
	{
		for(int i = 0; i < adjMat.length; i++)
			for(int j = 0; j <= i; j++)
				adjMat [i][j] = -1;
	}

	// distance from p to q
	public double dist(Point p, Point q)
	{
		int xDist = q.x - p.x;
		int yDist = q.y - p.y;

		// Avoid problems
		if(xDist < 0)
			xDist *= -1;
		if(yDist < 0)
			yDist *= -1;

		return(Math.sqrt( (Math.pow(xDist,2)) + (Math.pow(yDist,2)) ));
	}

	public double dik(double [][] adjMat)
	{
		double [] dist = new double [adjMat.length];
		boolean [] visited = new boolean [adjMat.length];
	
		Arrays.fill(dist, Double.MAX_VALUE);
		dist[0] = 0.0;

		PriorityQueue<Vertex> heap = new PriorityQueue<>();

		for(int i = 0; i < adjMat.length; i++)
			heap.add(new Vertex(i, dist[i]));

		while(!heap.isEmpty())
		{
			Vertex v = heap.remove();
			if(visited[v.id]) continue;

			//System.out.println(v.id + " Visited");

			visited[v.id] = true;

			for(int i = 0; i < adjMat.length; i++)
			{
				if(adjMat[v.id][i] > 0 && !visited[i] && (v.dist + adjMat[v.id][i]) < dist[i])
				{
					//System.out.println("updating " + i + " to dist " + (v.dist + adjMat[v.id][i]) + " from " + dist[i]);
					dist[i] = v.dist + adjMat[v.id][i];
					heap.add(new Vertex(i, v.dist + adjMat[v.id][i]));
				}
				else
				{
					//System.out.println(v.dist + adjMat[v.id][i] + " not less than " + dist[i]);
				}
			}
		}

		return dist[adjMat.length - 1];
	}
}



