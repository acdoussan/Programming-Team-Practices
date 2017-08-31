//Adam Doussan AD844156 05/27/2017

import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();

		while(test != 0)
		{
			int [] swapped = new int[test];
			HashMap<String, Integer> atoi = new HashMap<>();

			for(int i = 0; i < test; i++)
				atoi.put(in.next(), i);

			long ans = 0;

			for(int i = 0; i < test; i++)
				swapped[i] = atoi.get(in.next());

			System.out.println(mergeSort(swapped, 0, test));

			test = in.nextInt();
		}
	}

	public static long mergeSort(int [] arr, int start, int stop)
	{
		if(stop-start <= 1)
			return 0;

		int mid = (stop-start) / 2 + start;

		long ans = mergeSort(arr, start, mid) + mergeSort(arr, mid, stop);

		int sidx = 0, midx = 0;
		while(start + sidx < mid)
		{
			if(mid + midx == stop)
				break;

			if(arr[start + sidx] < arr[mid+midx])
			{
				sidx++;
			}
			else
			{
				ans += mid-start-sidx;
				midx++;
			}
		}

		Arrays.sort(arr, start, stop);

		return ans;
	}
}


/*
//Adam Doussan AD844156 05/27/2017

import java.io.*;
import java.util.*;

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();

		while(test != 0)
		{
			String [] first = new String[test];
			String [] second = new String[test];
			HashMap<String, HashSet<String>> f = new HashMap<>();
			HashMap<String, HashSet<String>> s = new HashMap<>();

			for(int i = 0; i < test; i++)
				first[i] = in.next();
			for(int i = 0; i < test; i++)
				second[i] = in.next();

			genPairs(first, f);
			genPairs(second, s);

			long ans = 0;

			for(String key : f.keySet())
			{
				if(s.containsKey(key))
				{
					HashSet<String> ss = s.get(key);

					for(String v : f.get(key))
					{
						if(!ss.contains(v))
							ans++;
					}
				}
				else
				{
					ans += f.get(key).size();
				}
			}

			System.out.println(ans);

			test = in.nextInt();
		}
	}

	public static void genPairs(String [] set, HashMap<String, HashSet<String>> pairs)
	{
		for(int i = 0; i < set.length; i++)
		{
			for(int j = i+1; j < set.length; j++)
			{
				if(!pairs.containsKey(set[i]))
					pairs.put(set[i], new HashSet<>());
				pairs.get(set[i]).add(set[j]);
			}
		}	
	}
}
*/
