// Adam Doussan AD844156 04/15/2017

import java.io.*;
import java.util.*;

class node
{
	public int w;
	ArrayList<Integer> kids;

	public node(int w)
	{
		this.w = w;
		kids = new ArrayList<>();
	}
}

public class d
{
	public static node [] tree;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		tree = new node [run];
		tree [0] = new node(in.nextInt());
		in.nextInt();

		for(int i = 1; i < run; i++)
		{
			tree[i] = new node(in.nextInt());
			tree[in.nextInt()-1].kids.add(i);
		}

		int [] ans = find(tree[0], new ArrayList<Integer>());

		System.out.println(ans.length);
	}

	public static int [] find (node root, ArrayList<Integer> seen)
	{
		if(root.kids.size() == 0)
			return new int [] {root.w};

		seen.add(root.w);
		ArrayList<Integer> possible = new ArrayList<>();

		for(int i = 0; i < root.kids.size(); i++)
		{
			possible.addAll(find(root.kids.get(i), seen));
		}

		
	}
}
