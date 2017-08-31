//Adam Doussan AD844156 09/10/2016

import java.io.*;
import java.util.*;

public class change
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
	
		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int numPacks = in.nextInt();
			int [] packs = new int [numPacks];

			for(int j = 0; j < numPacks; j++)
			{
				packs[j] = in.nextInt();
			}

			Arrays.sort(packs);
			
			boolean done = false;
			int startNum = packs[0];

			if(startNum != 1)
			{
				for(int j = 0; j < packs.length; j+=(startNum + 1))
				{
					for(int k = 0; k < startNum + 1; k++)
						if(packs[k + j] != startNum)
				}
			}
			else
			{
				for(int j = 1; j < packs.length; j++)
				{
					if(j == 1)
					{
						if(sumNumsOverRange(packs, j) < packs[j] - startNum)
						{
							System.out.format("Set #%d: %d%n", i+1, sumNumsOverRange(packs, j) );
							done = true;
							break;
						}
					}
					else if(sumNumsOverRange(packs, j) < packs[j] - startNum)
					{
						System.out.format("Set #%d: %d%n", i+1, sumNumsOverRange(packs, j) + 1);
						done = true;
						break;
					}
				}

				if(!done)
					System.out.format("Set #%d: %d%n", i+1, sumNumsOverRange(packs, packs.length) + 1);
			}
			/*
			ArrayList<Integer> combs = genCombs(packs);

			Set<Integer> hs = new HashSet<>();
			
			// get rid of duplicates
			hs.addAll(combs);
			combs.clear();
			combs.addAll(hs);

			
			Collections.sort(combs);

			//for(int temp : combs)
			//	System.out.println(temp);

			int j;
			boolean skip = false;

			for(j = 0; j < combs.size(); j++)
				if(j+1 != combs.get(j))
				{
					System.out.format("Set #%d: %d%n", i+1, j+1);
					skip = true;
					break;
				}

			if(!skip)
				System.out.format("Set #%d: %d%n", i+1, j+1);
			*/
		}
	
	
	}

	public static int sumNumsOverRange(int [] pack, int stop)
	{
		int retval = 0;

		for(int i = 0; i < stop; i++)
		{
			retval += pack[i];
		}

		return retval;
	}

	public static ArrayList<Integer> genCombs(int [] packs)
	{
		ArrayList<Integer> combs = new ArrayList<>();


		combs.addAll(genCombsHelper(packs, 1));

		/*
		for(int i = 0; i < packs.length; i++)
			combs.add(packs[i]);

		for(int i = 0; i < packs.length - 1; i++)
			for(int j = i; j < packs.length; j++)
				combs.add(packs[i] + packs[j]);
		*/

		return combs;
	}

	public static ArrayList<Integer> genCombsHelper(int [] packs, int numToAdd)
	{
		int [] addIndexes = new int [numToAdd];
		ArrayList<Integer> combs = new ArrayList<>();

		for(int i = 0; i < numToAdd; i++)
			addIndexes[i] = i;

		while(addIndexes[0] <= packs.length - numToAdd)
		{
			int temp = 0;
			
			//for(int i = 0; i < addIndexes.length; i++)
			//	System.out.format("%d ", addIndexes[i]);
			//System.out.println();

			for(int i = 0; i < addIndexes.length; i++)
				temp += packs[addIndexes[i]];

			combs.add(temp);

			addIndexes[addIndexes.length - 1]++;

			// fix overflows
			for(int i = addIndexes.length - 1; i >= 0; i--)
			{
				if(addIndexes[i] % (packs.length - ((addIndexes.length - 1) - i)) == 0 && addIndexes[i] != 0)
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

		if(packs.length > numToAdd)
		{
			combs.addAll(genCombsHelper(packs,numToAdd + 1));
		}
		
		return combs;
	}
}
