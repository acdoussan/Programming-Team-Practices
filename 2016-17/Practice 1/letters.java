//Adam Doussan AD844156 09/10/2016

import java.io.*;
import java.util.*;

public class letters
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int numRuns = 0;

		while(true)
		{
			numRuns++;

			String temp1 = in.nextLine().trim();
			String temp2 = in.nextLine().trim();

			if(temp1.equals("END") && temp2.equals("END"))
				break;

			int [] letters1 = new int [26];
			int [] letters2 = new int [26];

			for(int i = 0; i < temp1.length(); i++)
				letters1[temp1.charAt(i) - 'a']++;
			for(int i = 0; i < temp2.length(); i++)
				letters2[temp2.charAt(i) - 'a']++;

			boolean skip = false;
	
			for(int i = 0; i < 26; i++)
				if(letters1[i] != letters2[i])
				{
					System.out.format("Case %d: different%n", numRuns);
					skip = true;
					break;
				}

			if(!skip)
				System.out.format("Case %d: same%n", numRuns);

		}
	}
}
