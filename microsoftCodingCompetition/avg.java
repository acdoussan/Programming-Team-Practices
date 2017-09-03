// Adam Doussan AD844156 09/01/2017

import java.io.*;
import java.util.*;

public class avg
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			String test = in.nextLine();
			test = test.replaceAll(",", " ");

			Scanner temp = new Scanner(test);

			int count = 0;
			int total = 0;
			while(temp.hasNext())
			{
				count++;
				total+=temp.nextInt();
			}

			System.out.println(Math.round(((double)total)/count));
		}
	}
}
