//Adam Doussan AD844156 01/14/2017

import java.io.*;
import java.util.*;

public class i
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		for(int i = 0; i < run; i++)
		{
			String test = in.nextLine();

			if(test.startsWith("Simon says"))
				System.out.println(test.substring(10));
		}
	}
}
