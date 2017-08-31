// Adam Doussan AD844156 03/04/2017

import java.io.*;
import java.util.*;

class Item implements Comparable<Item>
{
	String name;
	HashSet<String> canKill;

	Item(String name)
	{
		this.name = name;
		canKill = new HashSet<>();
	}

	public int compareTo(Item a)
	{
		return a.canKill.size() - this.canKill.size();
	}
}

public class dragons
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int dragons = in.nextInt();

			HashMap<String, Integer> atoi = new HashMap<>();
			ArrayList<Item> items = new ArrayList<>();

			for(int j = 0; j < dragons; j++)
			{
				String name = in.next();
				String pos = in.next();
				String weap = in.next();

				if(atoi.containsKey(pos))
				{
					items.get(atoi.get(pos)).canKill.add(name);
				}

				else
				{
					Item temp = new Item(pos);
					temp.canKill.add(name);
					atoi.put(temp.name, items.size());
					items.add(temp);
				}

				if(atoi.containsKey(weap))
				{
					items.get(atoi.get(weap)).canKill.add(name);
				}

				else
				{
					Item temp = new Item(weap);
					temp.canKill.add(name);
					atoi.put(temp.name, items.size());
					items.add(temp);
				}
			}

			Collections.sort(items);

			int ans = 0;
			HashSet<String> seen = new HashSet<>();

			while(items.size() != 0)
			{
				Item temp = items.remove(0);
				HashSet<String> drags = temp.canKill;
				boolean eval = false;

				for(String drag : drags)
				{
					//System.out.println(drag);

					if(!seen.contains(drag))
					{
						eval = true;
						seen.add(drag);
					}
				}

				if(eval)
					ans++;
			}

		System.out.println(ans);

		}
	}
}
