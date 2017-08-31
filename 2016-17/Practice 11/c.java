//Adam Doussan AD844156 01/14/2017

import java.io.*;
import java.util.*;

public class c
{

	public static ArrayList<HashSet<String>>conComp = new ArrayList<>();
	HashMap<String,HashSet<String>> langToPeople = new HashMap<>();

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		ArrayList<String> lines = new ArrayList<>();
		boolean [][] matrix = new boolean[run][run];

		for(int i = 0; i < run; i++)
		{
			lines.add(in.nextLine());
		}

		for(int i = 0; i < run; i++)
		{
			String line = lines.get(i);
			Scanner thisLine = new Scanner(line);
			String name = thisLine.next();

			while(thisLine.hasNext())
			{
				String lang = thisLine.next();
				HashSet<String> people;

				if(langToPeople.containsKey(lang))
					people = langToPeople.get(lang);
				else
					people = new HashSet<>();

				if(!people.contains(name))
					people.add(name);
					

				for(int j = i + 1; j < run; j++)
				{
					String line2 = lines.get(j);
					Scanner thisLine2 = new Scanner(line2);
					String name2 = thisLine2.next();

					while(thisLine2.hasNext())
					{
						String lang2 = thisLine2.next();

						if(lang.equals(lang2))
						{
							people.add(name2);
						}
					}
				}
			}
		}

		int smallest = Integer.MAX_VALUE;

		for(String lang : langToPeople.keySet())
		{
			if(langToPeople.get(lang).size())
		}



/*
		boolean[] visited = new boolean[run];

		dfs(matrix, visited, null, 0, 0);

		if(conComp.size() == 1)
		{
			System.out.println(0);
			return;
		}

		int smallest = Integer.MAX_VALUE;

		for(HashSet<Integer> comp : conComp)
		{
			for(Integer i : comp)
			{
				System.out.println(i);
			}
			System.out.println();
			if(comp.size() < smallest)
				smallest = comp.size();
			
		}

		System.out.println(smallest);
	}

	// count connected components dfs
	public static void dfs(boolean[][] matrix, boolean[] visited, HashSet<Integer> currentSet, int depth, int last)
	{
		if(depth == visited.length)
			return;

		for(int i = 0; i < visited.length; i++)
		{
			if(depth == 0)
			{
				if(!visited[i])
				{
					if(currentSet != null)
						conComp.add(currentSet);

					currentSet = new HashSet<Integer>();

					visited[i] = true;
					currentSet.add(i);

					dfs(matrix, visited, currentSet, depth + 1, i);
				}
			}

			else if(matrix[last][i] && !visited[i])
			{
				currentSet.add(i);
				visited[i] = true;

				dfs(matrix, visited, currentSet, depth + 1, i);
			}
		}

		if(depth == 0)
		{
			conComp.add(currentSet);
		}
	}
}
