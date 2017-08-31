//Adam Doussan AD844156 12/03/2016

import java.io.*;
import java.util.*;


public class bridges
{
	HashSet<String> buildings;
	HashMap<String, HashSet<String>> groups;

	bridges(Scanner in)
	{
		buildings = new HashSet<>();
		groups = new HashMap<>();

		int bridges = in.nextInt();

		in.nextLine();
		for(int i = 0; i < bridges; i++)
		{
			String a = in.next();
			String b = in.next();

			if(groups.containsKey(a) && groups.containsKey(b))
			{
				HashSet<String> aGr = groups.get(a);
				HashSet<String> bGr = groups.get(b);

				// Both already in same group
				if(aGr == bGr)
				{
					System.out.println(aGr.size());
					continue;
				}

				aGr.addAll(bGr);

				for(String temp : bGr)
				{
					groups.put(temp, aGr);
				}

				System.out.println(aGr.size());
			}

			else if(groups.containsKey(a))
			{
				HashSet<String> aGr = groups.get(a);

				aGr.add(b);

				groups.put(b, aGr);

				System.out.println(aGr.size());
			}

			else if(groups.containsKey(b))
			{
				HashSet<String> bGr = groups.get(b);

				bGr.add(a);

				groups.put(a, bGr);

				System.out.println(bGr.size());
			}

			else
			{
				HashSet<String> newGr = new HashSet<>();

				newGr.add(a);
				newGr.add(b);

				groups.put(a, newGr);
				groups.put(b, newGr);

				System.out.println(newGr.size());
			}
		}
	}

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
			new bridges(in);
	}

}
