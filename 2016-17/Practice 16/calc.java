// Adam Doussan AD844156 02/18/2017

import java.io.*;
import java.util.*;

public class calc
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		for(int i = 0; i < run; i++)
		{
			System.out.println("------+---------");
			System.out.println(" time | elapsed ");
			System.out.println("------+---------");

			int startH = in.nextInt();
			int startM = in.nextInt();
			int durH = in.nextInt();
			int durM = in.nextInt();

			if(startM != 0)
			{
				System.out.format("%2d:XX | XX - %d\n", startH, startM);
			}
			else
			{
				System.out.format("%2d:XX | XX\n", startH, startM);
			}

			int j;

			for(j = 0; j < durH; j++)
			{
				System.out.format("%2d:XX | XX + %d\n", ((startH + j) % 12) + 1, (60 - startM) + (60 * j));
			}

			if(startM + durM >= 60)
			{
				System.out.format("%2d:XX | XX + %d\n", ((startH + j) % 12) + 1, (60 - startM) + (60 * j));
			}
		}
	}
}
