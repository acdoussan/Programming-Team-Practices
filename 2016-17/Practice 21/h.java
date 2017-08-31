// Adam Doussan AD844156 04/22/2017

import java.io.*;
import java.util.*;

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		int d = in.nextInt();

		while(true)
		{
			if(a == 0 && d == 0)
				break;

			int lowestAtt = in.nextInt();

			for(int i = 1; i < a; i++)
				lowestAtt = Math.min(lowestAtt, in.nextInt());

			int [] def = new int [d];

			for(int i = 0; i < d; i++)
				def[i] = in.nextInt();

			Arrays.sort(def);

			if(def[1] > lowestAtt)
				System.out.println("Y");
			else
				System.out.println("N");

			a = in.nextInt();
			d = in.nextInt();
		}
	}
}
