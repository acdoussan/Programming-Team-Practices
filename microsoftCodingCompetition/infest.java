// Adam Doussan AD844156 09/01/2017

import java.io.*;
import java.util.*;

public class infest
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		ArrayList<char[]> board = new ArrayList<>();
		while(in.hasNext())
		{
			String line = in.nextLine();
			char[] row = new char[line.length()];

			for(int i = 0; i < line.length(); i++)
			{
				row[i] = line.charAt(i);
			}

			board.add(row);
		}

		boolean changed = true;

		while(changed)
		{
			changed = false;

			for(int i = 0; i < board.size(); i++)
			{
				for(int j = 0; j < board.get(i).length; j++)
				{
					if(board.get(i)[j] == '0' && infect(i,j,board))
					{
						board.get(i)[j] = '1';
						changed = true;
					}
				}
			}
		}

		for(int i = 0; i < board.size(); i++)
			for(int j = 0; j < board.get(0).length; j++)
				System.out.print(board.get(i)[j] + ((j == board.get(0).length - 1) ? "\n" : ""));
	}

	public static boolean infect(int i, int j, ArrayList<char[]> board)
	{
		int c = 0;

		try
		{
			if(board.get(i-1)[j] == '1')
				c++;
		}
		catch(Exception e)
		{
		}

		try
		{
			if(board.get(i+1)[j] == '1')
				c++;
		}
		catch(Exception e)
		{
		}

		try
		{
			if(board.get(i)[j+1] == '1')
				c++;
		}
		catch(Exception e)
		{
		}

		try
		{
			if(board.get(i)[j-1] == '1')
				c++;
		}
		catch(Exception e)
		{
		}

		return c >= 2;
	}
}
