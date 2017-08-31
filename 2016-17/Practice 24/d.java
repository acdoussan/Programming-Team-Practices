//Adam Doussan AD844156 05/20/2017

import java.io.*;
import java.util.*;

class order implements Comparable<order>
{
	public int [] me;

	public order(int [] me)
	{
		this.me = new int [me.length];

		for(int i = 0; i < me.length; i++)
			this.me[i] = me[i];
	}


	public String toString()
	{
		StringBuilder temp = new StringBuilder();

		for(int i = 0; i < me.length; i++)
			temp.append(me[i] + " ");

		return temp.toString().trim();
	}

	public int compareTo(order o)
	{
		for(int i = 0; i < me.length; i++)
			if(me[i] != o.me[i])
				return me[i] - o.me[i];
		return 0;
	}
}

public class d
{
	public static HashMap<Integer, String> itoa = new HashMap<>();
	public static HashMap<String, Integer> atoi = new HashMap<>();
	public static PriorityQueue<order> list = new PriorityQueue<>();

	public static void main(String [] args)
	{
		gen(new int [6], 0, 0);
		int count = 0;
		//System.out.println(list.size());

		while(!list.isEmpty())
		{
			order temp = list.remove();
			atoi.put(temp.toString(), count);
			itoa.put(count, temp.toString());
			count++;
		}

		Scanner in = new Scanner(System.in);
		String command = in.next();
		count = 0;

		while(!command.equals("e"))
		{
			count++;
			if(command.equals("m"))
			{
				StringBuilder temp = new StringBuilder();

				for(int i = 0; i < 6; i++)
					temp.append(in.nextInt() + " ");

				System.out.println("Case " + count + ": " + atoi.get(temp.toString().trim()));
			}

			else
			{
				System.out.println("Case " + count + ": " + itoa.get(in.nextInt()));
			}

			command = in.next();
		}
	}

	public static void gen(int [] ans, int depth, int sum)
	{
		if(depth == 6)
		{
			if(sum == 15)
				list.add(new order(ans));
			return;
		}

		for(int i = 0; i < 16; i++)
		{
			if(!(sum+i > 15))
			{
				ans[depth] = i;
				gen(ans, depth+1, sum+i);
			}
		}
		/*
		int [] current = {0,0,0,0,0,15};
		int count = 0;
		String temp = makeString(current);

		atoi.put(temp, count);
		itoa.put(count++, temp);

		while(current[0] != 15)
		{
			
		}
		*/
	}
}
