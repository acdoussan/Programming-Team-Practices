//Adam Doussan AD844156 12/03/2016

import java.io.*;
import java.util.*;

public class cd
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run1 = in.nextInt(), run2 = in.nextInt();
		while(run1 != 0 || run2 != 0)
		{
			HashSet<Integer> cds = new HashSet<>();

			for(int i = 0; i < run1; i++)
			{
				cds.add(in.nextInt());
			}

			int count = 0;

			for(int i = 0; i < run2; i++)
			{
				if (cds.contains(in.nextInt()))
					count++;
			}

			System.out.println(count);

			run1 = in.nextInt(); run2 = in.nextInt();
		}
	}
}
