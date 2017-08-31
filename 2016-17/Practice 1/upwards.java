//Adam Doussan AD844156 09/10/2016

import java.io.*;
import java.util.*;

public class upwards
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		for(int i = 0; i < run; i++)
		{
			int level = in.nextInt();
			int numChars = in.nextInt();
			int rank = in.nextInt();

			char [] word = new char[numChars];
			
			for(int j = 1; j < word.length; j++)
			{
				int temp = word[j - 1] + (level + 1);
				word[j] = (char) temp;
			}

			char [] ans = getUpward(word, rank, level);

			for(int j = 0; j < ans.length; j++)
				ans[j]+='a';
			for(int j = 0; j < ans.length; j++)
				System.out.print(ans[j]);
			System.out.println();
		}
	}

	public static char [] getUpward(char [] start, int rank, int level)
	{
		for(int i = 0; i < rank - 1; i++)
		{
			start[start.length - 1]++;
			
			for(int j = 0; j < start.length; j++)
				System.out.format("%d", (int)start[j]);
			System.out.println();

			for(int j = start.length - 1; j >= 0; j--)
			{
				if((start[j]) % (25 - ((start.length - 1) - j)) == 0)
				{
					if(j == 0)
						break;
					start[j - 1]++;
					int temp = start[j - 1] + level + 1;
					start[j] = (char)temp;
					//start = fixUpward(start,level);
				}
			}
		}

		return start;
	}

	public static char []fixUpward(char [] fix, int level)
	{
		for(int i = 0; i < fix.length - 1; i++)
		{
			while(fix[i] >= fix[i + 1] - level)
				fix[i + 1]++;
		}

		return fix;
	}

	public static char [] genCombsHelper(char [] addIndexes, int numRuns, int level)
	{

		for(int i = 0; i < numRuns - 1; i++)
		{

			for(int j = 0; j < addIndexes.length; j++)
				System.out.format("%c", addIndexes[j] + 'a');
			System.out.println();			

			addIndexes[addIndexes.length - 1]++;

			// fix overflows
			for(int j = addIndexes.length - 1; j >= 0; j--)
			{
				if((addIndexes[j]) % (25 - ((level + 1) * ((addIndexes.length - 1) - j))) == 0)
				{
					System.out.println((int)addIndexes[j] + " % 25 == 0");
					if(j == 0)
						break;
					System.out.println((int)addIndexes[j - 1] + "++");
					System.out.println((int)addIndexes[j] + " = 0");
					addIndexes[j - 1]++;
					addIndexes[j] = 0;
				}
			}

			//fix ascending order
			for(int j = 0; j < addIndexes.length - 1; j++)
			{
				if(addIndexes[j] >= (addIndexes[j + 1] - (level)))
				{
					addIndexes[j + 1] = addIndexes[j];
					addIndexes[j + 1] += level + 1;
				}
			}
		}
		
		return addIndexes;
	}
}
