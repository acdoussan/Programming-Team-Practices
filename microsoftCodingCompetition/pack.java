// Adam Doussan AD844156 09/01/2017

import java.io.*;
import java.util.*;

public class pack
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String params = in.nextLine();
		params = params.replaceAll(":", " ");

		Scanner param = new Scanner(params);		

		int nodeC = param.nextInt();
		boolean remove;

		if(param.next().equals("True"))
			remove=true;
		else
			remove=false;


		ArrayList<String[]> ans = new ArrayList<>();
		ans.add(new String[nodeC]);

		int idx = 0;
		int inputNodeCount = 0;
		int inputEmpty = 0;

		in.nextLine();
		while(in.hasNext())
		{
			if(idx >= nodeC)
			{
				ans.add(new String[nodeC]);
				idx = 0;
			}

			String line = in.nextLine();
			line = line.replaceAll("\t", "");
			line = line.replaceAll("\n", "");
			line = line.trim();

			if(line.equals("["))
			{
				inputNodeCount++;
				continue;
			}
			
			if(line.equals("]"))
				continue;

			if(line.equals(""))
			{
				inputEmpty++;

				if(remove)
					continue;
			}

			ans.get(ans.size()-1)[idx++] = line;

		}

		if(idx == 0)
			ans.remove(ans.size()-1);

		int outputEmpty = 0;
		for(int i = 0; i < ans.size(); i++)
		{
			for(int j = 0; j < nodeC; j++)
			{
				if(ans.get(i)[j] == null || ans.get(i)[j].equals(""))
					outputEmpty++;
			}
		}

		System.out.println(ans.size());
		System.out.println(ans.size() - inputNodeCount);
		System.out.println(outputEmpty - inputEmpty);
		System.out.println(outputEmpty);

		System.out.println("[");
		for(int i = 0; i < ans.size(); i++)
		{
			System.out.println("[");

			for(int j = 0; j < nodeC; j++)
			{
				System.out.println(((ans.get(i)[j] == null) ? "" : ans.get(i)[j]));
			}
			
			System.out.println("]");
		}
		System.out.println("]");
		System.out.println();
	}
}
