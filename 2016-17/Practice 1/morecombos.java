//Adam Doussan AD844156 09/10/2016

import java.io.*;
import java.util.*;

public class morecombos
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int numBags = in.nextInt();
			int numChoose = in.nextInt();

			ArrayList<int[]> bagList = new ArrayList<>();

			for(int j = 0; j < numBags; j++)
			{
				int numCandies = in.nextInt();

				int [] bag = new int [numCandies];

				for(int k = 0; k < numCandies; k++)
				{
					bag[k] = in.nextInt();
				}

				bagList.add(bag);
			}

			int answer = getCombsHelper(bagList, numChoose);

			System.out.println(answer);
			
		}
		
	}

	public static int getCombsHelper(ArrayList<int[]> packs, int numToAdd)
	{
		int [] addIndexes = new int [numToAdd];
		ArrayList<Integer> combs = new ArrayList<>();

		for(int i = 0; i < numToAdd; i++)
			addIndexes[i] = i;

		while(addIndexes[0] <= packs.size() - numToAdd)
		{
			int [] temp = new int [35];
			
			//for(int i = 0; i < addIndexes.length; i++)
			//	System.out.format("%d ", addIndexes[i]);
			//System.out.println();

			for(int i = 0; i < addIndexes.length; i++)
				for(int j = 0; j < packs.get(addIndexes[i]).length; j++)
					temp[packs.get(addIndexes[i])[j]]++;

			int numUnique = 0;

			for(int i = 0; i < temp.length; i++)
				if(temp[i] > 0)
					numUnique++;

			combs.add(numUnique);

			addIndexes[addIndexes.length - 1]++;

			// fix overflows
			for(int i = addIndexes.length - 1; i >= 0; i--)
			{
				if(addIndexes[i] % (packs.size() - ((addIndexes.length - 1) - i)) == 0 && addIndexes[i] != 0)
				{
					if(i == 0)
						break;
					addIndexes[i - 1]++;
					addIndexes[i] = 0;
				}
			}

			//fix ascending order
			for(int i = 0; i < addIndexes.length - 1; i++)
			{
				while(addIndexes[i] >= addIndexes[i + 1])
					addIndexes[i + 1]++;
			}
		}

		int answer = 0;
		
		for(int test : combs)
			if(test > answer)
				answer = test;

		return answer;
	}
}
