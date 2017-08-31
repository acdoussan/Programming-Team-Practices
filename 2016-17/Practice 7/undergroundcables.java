//Adam Doussan AD844156 10/29/2016

import java.io.*;
import java.util.*;
import java.awt.Point;

class Vertex implements Comparable<Vertex>
{
	int id; double dist;

	Vertex(int id, double dist)
	{
		this.id = id;
		this.dist = dist;
	}

	public int compareTo(Vertex v)
	{
		double temp = this.dist - v.dist;

		if(temp < 0)
			return (int)Math.floor(temp);

		return (int)Math.ceil(temp);
	}
}

public class undergroundcables
{
	double [][] matrix;
	int N;
	ArrayList<Point> points;

	undergroundcables()
	{
		Scanner in = new Scanner(System.in);

		N = in.nextInt();

		while(N != 0)
		{
			points = new ArrayList<>();

			for(int i = 0; i < N; i++)
			{
				points.add(new Point(in.nextInt(), in.nextInt()));
			}

			matrix = new double [N][N];

			for(int row = 0; row < N; row++)
				for(int col = 0; col < N; col++)
					matrix[row][col] = dist(points.get(col), points.get(row));

			double ans = prims();

			System.out.format("%.2f\n", ans);

			N = in.nextInt();
		}
	}

	public double dist(Point a, Point b)
	{
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}

	public double prims()
	{
		double runningSum = 0;
		boolean [] visited = new boolean [N];

		PriorityQueue<Vertex> minHeap = new PriorityQueue<>();
		minHeap.add(new Vertex(0, 0.0));

		
		while(!(minHeap.isEmpty()))
		{
			Vertex current = minHeap.remove();

			if(visited[current.id])
				continue;

			visited[current.id] = true;
			runningSum += current.dist;

			for(int i = 0; i < N; i++)
			{
				// This is potentially wasteful but i don't care
				if(!visited[i])
					minHeap.add(new Vertex(i, matrix[current.id][i]));
			}
		}
		
		return runningSum;
	}

	public static void main(String [] args)
	{
		new undergroundcables();
	}
}
