//Adam Doussan AD844156 01/14/2017

import java.io.*;
import java.util.*;

public class b
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		for(int i = 0; i < run; i++)
			{

			int [] params = new int [5];

			for(int j = 0; j < 5; j++)
			{
				params[j] = in.nextInt();
			}

			double success = 1 - (((double)params[0] - 1.0) / (double)params[1]);
			double [] probs = new double[params[3] + 1];

			System.out.println(success);

			probs[0] = Math.pow(1.0 - success, probs.length) * choose(probs.length, 0);
			probs[probs.length - 1] = Math.pow(success, probs.length) * choose(probs.length, probs.length);

			System.out.println(probs[0]);

			for(int j = 1; j < probs.length - 1; j++)
			{
				probs[j] = (Math.pow(success,j) * Math.pow((1.0 - success),(probs.length - j))) * choose(probs.length, j);
				System.out.println(probs[j]);
			}

			System.out.println(probs[3]);

			double winProb = 0;
			double loseProb = 0;

			for(int j = params[2]; j < probs.length; j++)
			{
				winProb += probs[j];
			}

			for(int j = 0; j < params[2]; j++)
			{
				loseProb += probs[j];
			}

			double expect = (winProb * (double)params[4]) - loseProb;

			System.out.println(winProb);
			System.out.println(loseProb);
			System.out.println(expect);

			if(expect > 0)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

	public static int choose(int n, int k)
	{
		if(k == 0)
			return 1;
		if(n == k)
			return 1;
		if(n < k)
			return 0;

		return chooseHelp(n,k);
	}

	public static int chooseHelp(int n, int k)
	{
		if(k == 0)	return 1;
		return (n * chooseHelp((n - 1), (k - 1)) / k);
	}
}
