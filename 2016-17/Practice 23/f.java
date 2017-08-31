//Adam Doussan AD844156 05/13/2017

import java.io.*;
import java.util.*;

class node
{
	int num, parent;
	ArrayList<Integer> kids;

	public node(int num, parent)
	{
		this.num = num;
		this.parent = parent;
		kids = new ArrayList<>();
	}
}

public class f
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();

		node [] tree = new int [n];
		int root = -1;

		for(int i = 0; i < n; i++)
		{
			int node = in.nextInt();
			if(node == 0)
			{
				root = i;
				tree[i] = new node(i, -1);
			}
			else
			{
				tree[i] = new node(i, node);
				tree[node].kids.add(i);
			}
		}
	}
}
