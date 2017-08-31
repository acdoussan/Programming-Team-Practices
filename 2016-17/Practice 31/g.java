//Adam Doussan AD844156 07/15/2017

import java.io.*;
import java.util.*;

public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();
		in.nextLine();

		for(int rr = 1; rr <= run; rr++)
		{
			String test = in.nextLine();

			int y = 0, z = 0;

			for(int i = 0; i < test.length() - 1; i++)
			{
				if(test.charAt(i) == 'S')
				{	
					if(test.charAt(i+1) == 'S')
					{
						y++;
					}
					else
					{
						z++;
					}
				}
			}

			//if(test.charAt(test.length() - 2) != 'S' && test.charAt(test.length() - 1) == 'S')
			//	z++;

			System.out.format("Case %d: %d / %d\n", rr, y, z);
		}
	}
}
