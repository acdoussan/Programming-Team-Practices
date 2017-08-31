//Adam Doussan AD844156 01/28/2017

import java.io.*;
import java.util.*;

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 1; i <= run; i++)
		{
			int set = in.nextInt();
			int length = in.nextInt();
			int [] array = new int [length];
	
			for(int j = 0; j < length; j++)
			{
				array[j] = in.nextInt();
			}

			int [] sorted = Arrays.copyOf(array, length);
			Arrays.sort(sorted);

			int lookingFor = 0;
			int ans = 0;

			for(int j = 0; j < length; j++)
			{
				if(array[j] == sorted[lookingFor])
				{
					ans++;
					lookingFor++;
				}
			}

			System.out.println(set + " " + (length - ans));
		}
	}

}
