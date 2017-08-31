// Adam Doussan AD844156 02/18/2017

import java.io.*;
import java.util.*;

public class voting
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String test = in.nextLine();

		while(!test.equals("#"))
		{
			int voters = test.length();
			int y = 0;
			int n = 0;
			int a = 0;

			for(int i = 0; i < voters; i++)
			{
				char vote = test.charAt(i);

				if(vote == 'Y')
					y++;
				if(vote == 'N')
					n++;
				if(vote == 'A')
					a++;
			}

			if(a >= (int)Math.ceil(((float)voters) / 2))
				System.out.println("need quorum");
			else if(y > n)
				System.out.println("yes");
			else if(y == n)
				System.out.println("tie");
			else
				System.out.println("no");


			test = in.nextLine();
		}
	}
}
