//Adam Doussan AD844156 10/01/2016

import java.io.*;
import java.util.*;

public class sumprimes
{

	public static void main(String [] args)
	{
		new run();
	}

	class run
	{
		public run()
		{
			Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		Primes prime = new Primes();

		for(int i = 0; i < run; i++)
		{
			int start = in.nextInt(), stop = in.nextInt();
			int sum = 0;
			int test = prime.next();

			while(test < stop)
			{
				if(test > start)
					sum += test;
				test = prime.next();
			}
			
			prime.reset();
		}
		}
	}

	class Primes
	{
		ArrayList<Integer> primes;
		int index;

		public Primes()
		{
			primes = new ArrayList<>();

			for(int i = 0; i < Math.pow(10,7); i++)
				if(isPrime(i))
					primes.add(i);

			index = 0;
		}


		public boolean isPrime(int n)
		{
		 
			if (n%2==0) return false;
		 
			for(int i=3;i*i<=n;i+=2)
			{
				if(n%i==0)
				return false;
		 	}
		 return true;
		}

		public int next()
		{
			return primes.get(index++);
		}

		public void reset()
		{
			index = 0;
		}
	}
}
