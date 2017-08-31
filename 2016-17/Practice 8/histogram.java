//Adam Doussan AD844156 11/19/2016

import java.io.*;
import java.util.*;

public class histogram
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int run2 = in.nextInt();

			for(int j = 0; j < run2; j++)
				System.out.print('=');

			System.out.println();
		}
	}
}
