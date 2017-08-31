//Adam Doussan AD844156 10/01/2016

import java.io.*;
import java.util.*;

public class lotto
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		while(run != 0)
		{
			int [] check = new int [49];
			boolean skip = false;

			for(int i = 0; i < run; i++)
				for(int j = 0; j < 6; j++)
					check[in.nextInt() - 1]++;

			for(int temp : check)
			{
				if(temp == 0)
				{
					System.out.println("No");
					skip = true;
					break;
				}
			}

			if(!skip)
				System.out.println("Yes");

			run = in.nextInt();
		}
	}
}
