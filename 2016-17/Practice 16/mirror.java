// Adam Doussan AD844156 02/18/2017

import java.io.*;
import java.util.*;

public class mirror
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String test = in.nextLine();

		while(!test.equals("#"))
		{
			StringBuilder ans = new StringBuilder();

			boolean skip = false;

			for(int i = test.length() - 1; i >= 0; i--)
			{
				char ch = test.charAt(i);

				if(ch == 'b')
					ans.append("d");

				else if(ch == 'd')
					ans.append("b");

				else if(ch == 'p')
					ans.append("q");

				else if(ch == 'q')
					ans.append("p");

				else if(ch == 'i')
					ans.append("i");

				else if(ch == 'o')
					ans.append("o");

				else if(ch == 'v')
					ans.append("v");

				else if(ch == 'w')
					ans.append("w");

				else if(ch == 'x')
					ans.append("x");

				else
				{
					skip = true;
					System.out.println("INVALID");
					break;
				}
			}

			if(!skip)
				System.out.println(ans);

			test = in.nextLine();
		}
	}
}
