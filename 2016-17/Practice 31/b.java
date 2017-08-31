//Adam Doussan AD844156 07/15/2017

import java.io.*;
import java.util.*;

class myInt
{
	int val; boolean used;

	public myInt(int val)
	{
		this.val = val;
	}

	public String toString()
	{
		return Integer.toString(val);
	}
}

public class b
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int size = in.nextInt();

			ArrayList<myInt> [] pageNum = new ArrayList [size];

			for(int i = 0; i < size; i++)
				pageNum[i] = new ArrayList<>();

			boolean pass = true;

			for(int i = 0; i < size; i++)
			{
				myInt holder = new myInt(in.nextInt());
		
				if(holder.val >= size || pass == false)
				{
					pass = false;
					continue;
				}

				if(inRange(holder.val, size))
					pageNum[holder.val].add(holder);

				if(inRange(size - holder.val - 1, size))
					pageNum[size - holder.val - 1].add(holder);
			}

			if(pass)
			{
				for(int i = 0; i < (size/2)+1; i++)
				{
					if(pageNum[i].size() < 2)
					{
						pass = false;
						break;
					}
				}

				//if(size%2 == 1 && pass)
				//	if(pageNum[(size/2) + 1].size() == 0)
				//		pass = false;
				//pass = solve(pageNum, 0);
			}
			if(pass)
				System.out.format("Case %d: yes\n", rr);
			else
				System.out.format("Case %d: no\n", rr);
		}
	}

	public static boolean inRange(int test, int size)
	{
		return test >= 0 && test < size;
	}

	public static boolean solve(ArrayList<myInt> [] pageNum, int depth)
	{
		if(depth == pageNum.length)
			return true;

		for(myInt temp : pageNum[depth])
		{
			if(!temp.used)
			{
				temp.used = true;

				if(solve(pageNum, depth+1))
					return true;

				temp.used = false;
			}
		}

		return false;
	}
}
