// Adam Doussan AD844156 09/01/2017

import java.io.*;
import java.util.*;

public class trans
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		while(in.hasNext())
		{
			String line = in.nextLine();

			Scanner temp = new Scanner(line);

			ArrayList<Integer> row = new ArrayList<>();
			while(temp.hasNext())
			{
				row.add(temp.nextInt());
			}

			mat.add(row);
		}

		for(int i = 0; i < mat.get(0).size(); i++)
		{
			for(int j = 0; j < mat.size(); j++)
			{
				System.out.print(mat.get(j).get(i) + ((j == mat.size() - 1) ? "\n" : " "));
			}
		}
				
	}
}
