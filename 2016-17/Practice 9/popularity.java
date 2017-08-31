//Adam Doussan AD844156 12/03/2016

import java.io.*;
import java.util.*;

public class popularity
{
	boolean [][] matrix;
	HashMap<String, Integer> indexes;
	HashSet<String> nameList;

	popularity()
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			System.out.println("Social Network " + (i + 1) + ":");

			int names = in.nextInt();

			matrix = new boolean [names][names];
			indexes = new HashMap<>();
			nameList = new HashSet<>();

			in.nextLine();
			for(int j = 0; j < names; j++)
			{
				String name = in.next();
				indexes.put(name, indexes.size());
				nameList.add(name);
			}

			int friends = in.nextInt();

			in.nextLine();
			for(int j = 0; j < friends; j++)
			{
				String a = in.next();
				String b = in.next();
				int aIndex = indexes.get(a);
				int bIndex = indexes.get(b);

				matrix[aIndex][bIndex] = true;
				matrix[bIndex][aIndex] = true;
			}

			int rival = in.nextInt();

			in.nextLine();
			for(int j = 0; j < rival; j++)
			{
				String rivalN = in.next();

				if(nameList.contains(rivalN))
				{
					boolean skip = false;

					for(int k = 1; k < names; k++)
					{
						int myF = dfs(indexes.get("You"), k);
						int rivF = dfs(indexes.get(rivalN), k);

						if(myF > rivF)
						{
							System.out.println(rivalN + " " + k);
							skip = true;
							break;
						}
					}

					if(!skip)
					{
						System.out.println(rivalN + " is just too cool");
					}
				}
				
				else
				{
					System.out.println(rivalN + " 1");
				}
			}
		}
	}

	public int dfs(int start, int depth)
	{
		boolean[] visited = new boolean[matrix.length];

		return dfs(start, depth, visited);
	}

	public int dfs(int start, int depth, boolean [] visited)
	{
		if(depth == 0)
			return 0;

		visited[start] = true;
		int count = 0; 

		for(int i = 0; i < visited.length; i++)
		{
			if(matrix[start][i] && !visited[i])
			{
				count += 1 + dfs(i, depth - 1, visited);
			}
		}

		visited[start] = false;

		return count;
	}

	public static void main(String [] args)
	{
		new popularity();
	}
}
