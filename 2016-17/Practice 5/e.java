//Adam Doussan AD844156 10/15/2016

import java.io.*;
import java.util.*;

class Node
{
	Point data;
	Node left,right;

	Node(Point data)
	{
		this.data = data;
	}
}

class Point implements Comparable<Point>
{
	int p, q;

	Point(int p, int q)
	{
		this.p = p;
		this.q = q;
	}

	public int compareTo(Point data)
	{
		if(data.p == this.p && data.q == this.q)
			return 0;

		// arbitrary, dont care about ordering
		return 1;
	}

	public int hashCode()
	{
		Integer temp1 = p, temp2 = q;
		return temp1.hashCode() + temp2.hashCode();
	}
}

class BinTree()
{
	Node root;
	ArrayList<Node> skip;
	HashMap<Point, Integer> answers;

	BinTree()
	{
		Point start = new Point(1,1);
		root = new Node(temp);
		answers = new HashMap<>();
		answers.add(temp,1);
		skip = new ArrayList<>();
		skip.add(root);
	}

	public int search(int p, int q)
	{
		Point search = new Point(p,q);

		while(!(answers.containsKey(search)))
		{
			getNextLevel();
		}

		return answers.get(search);
	}

	public void getNextLevel()
	{
		ArrayList<Node> temp = new ArrayList<>();
		int offset = answers.get(skip.get(0).data);


		for(int i = 0; i < skip.size(); i++)
		{
			Node temp = skip.get(i);
			Point dataLeft = new Point(temp.data.p, temp.data.p + temp.data.q);
			Point dataRight = new Point(temp.data.p + temp.data.q, temp.data.q);
			temp.left = new Node(dataLeft);
			temp.right = new Node(dataRight);
		}
	}
}

public class e
{
	public static void main(String [] args)
	{
		new e();
	}

	e()
	{
		Scanner in = new Scanner(System.in);
		BinTree = new BinTree();

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			System.out.print(Integer.parseInt(in.next()) + " ");

			String temp = in.next();
			temp = temp.replace('/', ' ');

			Scanner annoying = new Scanner(temp);

			int p = annoying.nextInt();
			int q = annoying.nextInt();

			int ans = BinTree.search(p,q);

			System.out.println(ans);
		}
			
	}
}
