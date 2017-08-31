//Adam Doussan AD844156 11/19/2016

import java.io.*;
import java.util.*;

public class panoptes
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int p = in.nextInt();
		float sum = 0;
		float thresh = 0;
		boolean skip = false;

		float [] obs = new float[n];

		for(int i = 0; i < n; i++)
		{
			obs[i] = in.nextFloat();
			sum += obs[i];
		}

		thresh = (float)((sum / n) * .8);

		for(int i = p; i < (n / 2) ; i++)
		{

			for(int j = 0; j < i ; j++)
			{
				skip = false;

				for(int k = j; k < n - j; k += i)
				{
					if(obs[k] >= thresh)
					{
						skip = true;
						break;
					}
				}

				if(!skip)
					break;
			}

			if(!skip)
			{
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);
	}
}
