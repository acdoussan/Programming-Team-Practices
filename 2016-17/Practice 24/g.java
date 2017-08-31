//Adam Doussan AD844156 05/20/2017

import java.io.*;
import java.util.*;

class conversion
{
	long left, right;
	String to;

	public conversion(long left, long right, String to)
	{
		this.left = left; this.right = right; this.to = to;
	}

	public conversion mult(conversion o)
	{
		conversion temp = new conversion(left*o.left, right*o.right, o.to);
		//temp.simplify();
		return temp;
	}

	public void simplify()
	{
		long temp = gcd(left,right);
		left = left/temp;
		right = right/temp;
	}

	public static long gcd(long a, long b)
	{
		return (b == 0) ? a : gcd(b, a%b);
	}
}

public class g
{
	public static conversion [][] convert;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int numConv = in.nextInt();
		int count = 0;

		while(numConv != 0)
		{
			count++;
			convert = new conversion[8][8];
			HashMap<String, Integer> atoi = new HashMap<>();
			HashMap<Integer, String> itoa = new HashMap<>();

			for(int i = 0; i < numConv; i++)
			{
				int leftVal = in.nextInt();
				String leftName = in.next();
				in.next();
				int rightVal = in.nextInt();
				String rightName = in.next();

				if(!atoi.containsKey(leftName))
				{
					atoi.put(leftName, atoi.size());
					itoa.put(itoa.size(), leftName);
				}

				if(!atoi.containsKey(rightName))
				{
					atoi.put(rightName, atoi.size());
					itoa.put(itoa.size(), rightName);
				}
///*
				convert[atoi.get(leftName)][atoi.get(rightName)] = new conversion(rightVal, leftVal, rightName);
				convert[atoi.get(rightName)][atoi.get(leftName)] = new conversion(leftVal, rightVal, leftName);
//*/
/*
				convert[atoi.get(leftName)][atoi.get(rightName)] = new conversion(leftVal, rightVal, rightName);
				convert[atoi.get(rightName)][atoi.get(leftName)] = new conversion(rightVal, leftVal, leftName);
*/
			}

			int req = in.nextInt();
			String have = in.next();
			int start = atoi.get(have);
			ArrayList<conversion> possible = new ArrayList<>();

			dfs(start, 0, null, possible, new boolean [8]);

			double bestRate = Double.MAX_VALUE;
			String bestConv = null;
			long ans = 0;

			for(conversion c : possible)
			{
				long need = (long)Math.ceil((req * c.left) / ((double)c.right));
				double thisRate = (need * (((double)c.right) / c.left)) / req;
/*
				if(count == 913)
				{
					System.out.println(c.left);
					System.out.println(c.right);
					System.out.println(need);
					System.out.println(thisRate);
				}
*/
				if(thisRate < bestRate && need <= 100000)
				{
					bestRate = thisRate;
					bestConv = c.to;
					ans = need;
				}
			}

			System.out.format("Case %d: %d %s\n", count, ans, bestConv);

			numConv = in.nextInt();
		}
	}

	public static void dfs(int current, int depth, conversion last,
							ArrayList<conversion> possible, boolean [] visited)
	{
		if(depth == 0)
		{
			visited[current] = true;
			for(int i = 0; i < 8; i++)
			{
				if(convert[current][i] != null && !visited[i] && i != current)
				{
					visited[i] = true;
					conversion next = convert[current][i];
					possible.add(next);
					dfs(i, depth+1, next, possible, visited);
					visited[i] = false;
				}
			}
		}

		else
		{
			for(int i = 0; i < 8; i++)
			{
				if(convert[current][i] != null && !visited[i])
				{
					visited[i] = true;
					conversion next = last.mult(convert[current][i]);
					possible.add(next);
					dfs(i, depth+1, next, possible, visited);
					visited[i] = false;
				}
			}
		}
	}
}
