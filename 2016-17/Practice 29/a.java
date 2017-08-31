//Adam Doussan AD844156 07/01/2017

import java.io.*;
import java.util.*;

public class a
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int quote = in.nextInt();
		in.nextLine();

		HashMap<Integer, String> itoa = new HashMap<>();

		for(int rr = 1; rr <= quote; rr++)
			itoa.put(rr, in.nextLine());

		int comm = in.nextInt();

		for(int i = 0; i < comm; i++)
		{
			int rule = in.nextInt();
			if(itoa.containsKey(rule))
				System.out.format("Rule %d: %s\n", rule, itoa.get(rule));
			else
				System.out.format("Rule %d: No such rule\n", rule);
		}
	}
}
