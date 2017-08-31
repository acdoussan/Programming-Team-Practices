//Adam Doussan AD844156 07/12/2017

import java.io.*;
import java.util.*;

public class fuel
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int stops = in.nextInt();
		int c = 0;

		while(stops != 0)
		{
			c++;

			int [] fuel = new int [stops];
			int [] cost = new int [stops];

			for(int i = 0; i < stops; i++)
				fuel[i] = in.nextInt();
			for(int i = 0; i < stops; i++)
				cost[i] = in.nextInt();

			int [] costLeft = new int [stops];
			int [] costRight = new int [stops];
			int [] fuelLeft = new int [stops];
			int [] fuelRight = new int [stops];

			int sum = 0;
			for(int i = 1; i < stops; i++)
			{
				sum += cost[i-1];
				costLeft[i] = sum;
			}

			sum = 0;
			for(int i = stops-2; i >= 0 ; i--)
			{
				sum += cost[i+1];
				costRight[i] = sum;
			}

			sum = 0;
			for(int i = 1; i < stops; i++)
			{
				sum += fuel[i-1];
				fuelLeft[i] = sum;
			}

			sum = 0;
			for(int i = stops-2; i >= 0 ; i--)
			{
				sum += fuel[i+1];
				fuelRight[i] = sum;
			}

			StringBuilder ans = new StringBuilder();

			for(int i = 0; i < stops; i++)
			{
				if(fuel[i] >= cost[i])
					if(fuel[i] - cost[i] + fuelRight[i] >= costRight[i] &&
					   fuelLeft[i] >= costLeft[i])
						ans.append(" " + (i+1));
			}

			System.out.format("Case %d:%s\n", c, ans.toString());

			stops = in.nextInt();
		}
	}
}
