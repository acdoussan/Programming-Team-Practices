//Adam Doussan AD844156 11/19/2016

import java.io.*;
import java.util.*;

public class periodic
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String per = in.nextLine();
		int ans;
		boolean skip = false;

		for(int i = 1; i < per.length(); i++)
		{
			ans = i;
			skip = false;

			if(per.length() % ans != 0)
			{
				skip = true;
				continue;
			}

			char [] test = new char[ans];
			for(int j = 0; j < ans; j++)
				test[j] = per.charAt(j);

			for(int j = ans, rot = 1; j < per.length(); j += ans)
			{
				for(int k = 0; k < ans; k++)
				{
					if(per.charAt(j+k) != test[(j+k-rot) % ans])
					{
						//System.out.println(per.charAt(j+k) + " Not equal to " + test[(j+k+rot) % ans]);
						skip = true;
						break;
					}
					//System.out.println(per.charAt(j+k) + " equal to " + test[(j+k+rot) % ans]);
				}

				if(skip) break;
				rot++;
			}
			//System.out.println();
			if(skip)
				continue;
			else
			{
				System.out.println(ans);
				break;
			}
		}
		if(skip)
			System.out.println(per.length());
	}
}
