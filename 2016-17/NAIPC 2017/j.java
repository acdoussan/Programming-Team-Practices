// Adam Doussan AD844156 04/15/2017

import java.io.*;
import java.util.*;

public class j
{
	String goal1 = "BW";
	String goal2 = "WB";
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String start = in.nextLine();

		int bc = 0;
		int wc = 0;

		for(int i = 0; i < start.length(); i++)
		{
			if(start.charAt(i) == 'B')
				bc++;
			else
				wc++;
		}

		if(bc == wc)
			System.out.println("1");
		else
			System.out.println("0");
	}
/*
	public static boolean bfs(String start)
	{
		HashSet<String> seen = new HashSet<>();
		Queue q = new ArrayDeque<>();

		while(!q.isEmpty())
		{
			String next = q.remove();

			if(seen.contains(next)) continue;
			seen.add(next);

			
		}
	}
*/
}
