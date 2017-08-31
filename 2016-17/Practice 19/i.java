// Adam Doussan AD844156 04/01/2017

import java.io.*;
import java.util.*;

public class i
{
	public static void main(String [] args)
	{
		Scanner inn = new Scanner(System.in);

		int run = inn.nextInt();

		for(int i = 0; i < run; i++)
		{
			HashSet<String> in = new HashSet<>();
			HashSet<String> out = new HashSet<>();			

			for(int j = 0; j < 16; j++)
			{
				String test1 = inn.next();
				String test2 = inn.next();
				int g1 = inn.nextInt();
				int g2 = inn.nextInt();

				if(g1 < g2)
				{
					if(in.contains(test1))
						in.remove(test1);
					out.add(test1);

					if(!out.contains(test2))
						in.add(test2);
				}

				else
				{
					if(in.contains(test2))
						in.remove(test2);
					out.add(test2);

					if(!out.contains(test1))
						in.add(test1);
				}
			}

			for(String temp : in)
				System.out.println(temp);
		}
	}
}
