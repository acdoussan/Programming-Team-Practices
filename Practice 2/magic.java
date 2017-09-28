// Adam Doussan AD844156 09/23/2017

import java.io.*;
import java.util.*;

public class magic
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			long test = in.nextInt();

			HashSet<Character> seen = new HashSet<>();

			int count = 0;
			while(seen.size() < 10)
			{
				count++;

				long t1 = test*count;

				String temp = Long.toString(t1);

				for(int i = 0; i < temp.length(); i++)
					seen.add(temp.charAt(i));
			}

			System.out.println(count);
		}
	}
}
