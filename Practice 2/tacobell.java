// Adam Doussan AD844156 09/23/2017

import java.io.*;
import java.util.*;

class ans implements Comparable<ans>
{
	ArrayList<String> order;

	public ans (ArrayList<String> order)
	{
		this.order = order;
	}

	public int compareTo(ans o)
	{
		for(int i = 0; i < order.size(); i++)
		{
			if(order.get(i).compareTo(o.order.get(i)) != 0)
				return order.get(i).compareTo(o.order.get(i));
		}

		return 0;
	}

	public String toString()
	{
		StringBuilder temp = new StringBuilder();

		for(int i = 0; i < order.size(); i++)
		{
			temp.append(order.get(i) + " ");
		}

		return temp.toString().trim();
	}
}

public class tacobell
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int n = in.nextInt();
			int k = in.nextInt();
			in.nextLine();

			String [] words = new String [n];

			for(int i = 0; i < n; i++)
				words[i] = in.nextLine();

			ArrayList<ans> ans = new ArrayList<>();
			boolean [] take = new boolean [n];

			genCombs(words, ans, take, 0, 0, k);

			Collections.sort(ans);

			for(int i = 0; i < ans.size(); i++)
			{
				System.out.println(ans.get(i));
			}

			System.out.println();
		}
	}

	public static void genCombs(String[] words, ArrayList<ans> ans,
									boolean [] take, int depth, int taken, int goal)
	{
		if(depth == words.length)
		{
			if(taken == goal)
			{
				ArrayList<String> temp = new ArrayList<>();

				for(int i = 0; i < take.length; i++)
					if(take[i])
						temp.add(words[i]);

				Collections.sort(temp);
				ans.add(new ans(temp));
			}
			return;
		}

		take[depth] = true;
		genCombs(words,ans,take,depth+1, taken+1, goal);

		take[depth] = false;
		genCombs(words,ans,take,depth+1, taken, goal);
	}
}
