//Adam Doussan AD844156 07/15/2017

import java.io.*;
import java.util.*;

public class z
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int rr = 1; rr <= run; rr++)
		{
			int cell = in.nextInt();
			boolean [] cells = new boolean [cell];

			for(int i = 1; i <= cell; i++)
			{
				for(int j = i; j <= cell; j += i)
				{
					//System.out.println(j);
					cells[j-1] = ((cells[j-1] == false) ? true : false);
				}
			}

			int ans = 0;
			for(int i = 0; i < cell; i++)
				if(cells[i]) ans++;

			System.out.println(ans);
		}
	}
}
