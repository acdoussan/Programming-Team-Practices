// Adam Doussan AD844156 02/04/2017

import java.io.*;
import java.util.*;

public class gnome
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		System.out.println("Gnomes:");

		for(int i = 0; i < run; i++)
		{
			String temp1 = in.nextLine();

			Scanner temp = new Scanner(temp1);

			ArrayList<Integer> nums = new ArrayList<>();

			while(temp.hasNext())
				nums.add(temp.nextInt());

			boolean up = true, down = true;
			int prev = nums.get(0);

			for(int j = 1; j < nums.size(); j++)
			{
				int temp2 = nums.get(j);

				if(temp2 < prev)
				{
					up = false;
				}

				if(temp2 > prev)
				{
					down = false;
				}

				prev = temp2;
			}

			if(up || down)
				System.out.println("Ordered");
			else
				System.out.println("Unordered");
		}
	}
}
