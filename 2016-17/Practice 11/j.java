//Adam Doussan AD844156 01/14/2017

import java.io.*;
import java.util.*;

public class j
{
	public static HashMap<Integer,String> names;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int stops = in.nextInt();
		in.nextLine();

		HashMap<String,Integer> indexes = new HashMap<>();
		names = new HashMap<>();

		ArrayList<String> lines = new ArrayList<>();

		for(int i = 0; i < stops; i++)
		{
			String temp = in.nextLine();

			lines.add(temp);

			Scanner walker = new Scanner(temp);

			while(walker.hasNext())
			{
				String stop = walker.next();

				if(!indexes.containsKey(stop))
				{
					indexes.put(stop, indexes.size());
					names.put(indexes.get(stop), stop);
				}
			}
		}

		boolean [][] matrix = new boolean [indexes.size()][indexes.size()];

		for(int i = 0; i < lines.size(); i++)
		{
			String test = lines.get(i);
			Scanner strTest = new Scanner(test);

			String thisStop = strTest.next();

			if(!indexes.containsKey(thisStop))
			{
				indexes.put(thisStop, indexes.size());
				names.put(indexes.get(thisStop), thisStop);
			}

			while(strTest.hasNext())
			{
				String link = strTest.next();

				if(!indexes.containsKey(link))
				{
					indexes.put(link, indexes.size());
					names.put(indexes.get(link), link);
				}

				matrix[indexes.get(thisStop)][indexes.get(link)] = true;
				matrix[indexes.get(link)][indexes.get(thisStop)] = true;
			}
		}

		String start = in.next();
		String des = in.next();

		if(!indexes.containsKey(start) || !indexes.containsKey(des))
		{
			System.out.println("no route found");
			return;
		}

		boolean[] visited = new boolean[indexes.size()];
		int [] ans = new int[indexes.size()];

		visited[indexes.get(start)] = true;
		ans[0] = indexes.get(start);

		if(!dfs(matrix, visited, ans, indexes.get(des), 1))
			System.out.println("no route found");

	}

	public static boolean dfs(boolean[][] matrix, boolean[] visited, int[] ans, int dest, int depth)
	{
		if(ans[depth - 1] == dest)
		{
			printAns(ans, depth);
			return true;
		}

		if(depth == visited.length)
			return false;

		for(int i = 0; i < visited.length; i++)
		{
			if(matrix[ans[depth - 1]][i] && !visited[i])
			{
				ans[depth] = i;
				visited[i] = true;

				if(dfs(matrix, visited, ans, dest, depth + 1))
					return true;

				visited[i] = false;
			}
		}

		return false;
	}

	public static void printAns(int[] ans, int depth)
	{
		for(int i = 0; i < depth; i++)
			System.out.print(names.get(ans[i]) + ((i == depth - 1) ? '\n' : ' '));
	}
}
