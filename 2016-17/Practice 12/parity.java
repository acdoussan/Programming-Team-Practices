//Adam Doussan AD844156 01/21/2017

import java.io.*;
import java.util.*;

public class parity
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String test = in.nextLine();

		while(!test.equals("#"))
		{
			int count = 0;

			for(int i = 0; i < test.length() - 1; i++)
			{
				if(test.charAt(i) == '1')
					count++;
			}

			String ans;

			if(test.charAt(test.length() - 1) == 'e')
			{
				if((count % 2) == 0)
					ans = test.substring(0,test.length() - 1) + "0";
				else
					ans = test.substring(0,test.length() - 1) + "1";
			}

			else
			{
				if((count % 2) == 1)
					ans = test.substring(0,test.length() - 1) + "0";
				else
					ans = test.substring(0,test.length() - 1) + "1";
			}

			System.out.println(ans);

			test = in.nextLine();
		}
	}
}
