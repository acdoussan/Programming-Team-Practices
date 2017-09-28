// Adam Doussan AD844156 09/23/2017

import java.io.*;
import java.util.*;

public class nonogram
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int gr = in.nextInt();
		in.nextLine();

		while(gr != 0)
		{
			char [][] grid = new char [gr][gr];

			for(int i = 0; i < gr; i++)
			{
				String line = new String(in.nextLine());

				for(int j = 0; j < gr; j++)
					grid[i][j] = line.charAt(j);
			}

			for(int i = 0; i < gr; i++)
			{
				int count = 0;
				boolean counting = false;
				ArrayList<Integer> ans = new ArrayList<>();

				for(int j = 0; j < gr; j++)
				{
					if(grid[i][j] == '.' && counting == true)
					{
						ans.add(count);
						count = 0;
						counting=false;
					}

					if(grid[i][j] == 'X')
					{
						count++;
						counting = true;
					}
				}

				if(counting)
					ans.add(count);

				if(ans.size() == 0)
					System.out.println(0);
				else
				{
					for(int j = 0; j < ans.size(); j++)
						System.out.print(ans.get(j) + ((j == ans.size()-1) ? "\n" : " "));	
				}
			}

			for(int i = 0; i < gr; i++)
			{
				int count = 0;
				boolean counting = false;
				ArrayList<Integer> ans = new ArrayList<>();

				for(int j = 0; j < gr; j++)
				{
					if(grid[j][i] == '.' && counting == true)
					{
						ans.add(count);
						count = 0;
						counting=false;
					}

					if(grid[j][i] == 'X')
					{
						count++;
						counting = true;
					}
				}

				if(counting)
					ans.add(count);

				if(ans.size() == 0)
					System.out.println(0);
				else
				{
					for(int j = 0; j < ans.size(); j++)
						System.out.print(ans.get(j) + ((j == ans.size()-1) ? "\n" : " "));	
				}
			}

			gr = in.nextInt();
			in.nextLine();

		}
	}
}
