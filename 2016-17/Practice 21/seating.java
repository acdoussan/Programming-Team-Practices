// Adam Doussan AD844156 04/22/2017

import java.io.*;
import java.util.*;

public class seating
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int len = in.nextInt();

		while(len != 0)
		{
			String [] a = new String [len];
			String [] b = new String [len];

			for(int i = 0; i < len; i++)
				a[i] = in.next();
			for(int i = 0; i < len; i++)
				b[i] = in.next();

			HashMap<String, Integer> seen = new HashMap<>();

			int ans = 0;

			for(int i = 0; i < len; i++)
			{
				seen.put(a[i], i);
			}

			for(int i = 0; i < len; i++)
			{
				if(seen.get(b[i]) - i > 0)
					ans += seen.get(b[i]) - i;
			}

			System.out.println(ans);
			len = in.nextInt();
		}
	}
}
