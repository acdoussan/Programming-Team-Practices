// Adam Doussan AD844156 09/23/2017

import java.io.*;
import java.util.*;

class person
{
	char name;
	HashSet<Character> likes;
	HashSet<Character> tol;

	public person(char name)
	{
		this.name = name;
		likes = new HashSet<>();
		tol = new HashSet<>();
	}
}

class pair
{
	person m;
	person w;

	public pair(person m, person w)
	{
		this.m = m;
		this.w = w;
	}

	public int getHap()
	{
		if(m.likes.contains(w.name) && w.likes.contains(m.name))
			return 4;

		if(m.tol.contains(w.name) && w.tol.contains(m.name) ||
		   m.tol.contains(w.name) && w.likes.contains(m.name) ||
		   m.likes.contains(w.name) && w.tol.contains(m.name))
			return 3;

		if(w.tol.contains(m.name))
			return 2;

		if(m.tol.contains(w.name))
			return 1;

		return 0;
	}
}

public class party
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();
		int c = 0;

		while(run > 0)
		{
			HashMap<Character, person> getP = new HashMap<>();
			ArrayList<person> men = new ArrayList<>();
			ArrayList<person> women = new ArrayList<>();

			in.nextLine();
			c++;

			for(int rr = 1; rr <= run; rr++)
			{
				String rule = in.nextLine();

				if(!getP.containsKey(rule.charAt(0)))
				{
					person p = new person(rule.charAt(0));
					getP.put(rule.charAt(0), p);

					if(Character.isUpperCase(rule.charAt(0)))
						women.add(p);
					else
						men.add(p);
				}

				if(!getP.containsKey(rule.charAt(2)))
				{
					person p = new person(rule.charAt(2));

					getP.put(rule.charAt(2), p);

					if(Character.isUpperCase(rule.charAt(2)))
						women.add(p);
					else
						men.add(p);
				}

				if(rule.charAt(1) == 'L')
					getP.get(rule.charAt(0)).likes.add(rule.charAt(2));
				else
					getP.get(rule.charAt(0)).tol.add(rule.charAt(2));
			}

			ArrayList<ArrayList<pair>> tests = new ArrayList<>();

			genTests(tests, men, women, new boolean[men.size()], new boolean [women.size()], 0, new ArrayList<>());

			int max = 0;

			for(int i = 0; i < tests.size(); i++)
			{
				max = Math.max(max, eval(tests.get(i)));
			}

			System.out.format("Party %d has a maximum happiness quotient of %d\n", c, max);

			run = in.nextInt();
		}
	}

	public static void genTests (ArrayList<ArrayList<pair>> tests, ArrayList<person> men, ArrayList<person> women, boolean [] usedm, boolean [] usedw, int depth, ArrayList<pair> runAns)
	{
		if(depth >= usedm.length || depth >= usedw.length)
		{
			ArrayList<pair> ans = new ArrayList<>();

			for(pair p : runAns)
				ans.add(p);

			tests.add(ans);

			return;
		}

		if(usedm.length < usedw.length)
		{
			for(int i = 0; i < usedm.length; i++)
			{
				if(!usedm[i])
				{
					for(int j = 0; j < usedw.length; j++)
					{
						if(!usedw[j])
						{
							usedm[i] = true;
							usedw[j] = true;
							runAns.add(new pair(men.get(i), women.get(j)));

							genTests(tests, men, women, usedm, usedw, depth+1, runAns);

							runAns.remove(runAns.size()-1);
							usedm[i] = false;
							usedw[j] = false;
						}
					}
				}
			}
		}

		else
		{
			for(int j = 0; j < usedw.length; j++)
			{
				if(!usedw[j])
				{
					for(int i = 0; i < usedm.length; i++)
					{
						if(!usedm[i])
						{
							usedm[i] = true;
							usedw[j] = true;
							runAns.add(new pair(men.get(i), women.get(j)));

							genTests(tests, men, women, usedm, usedw, depth+1, runAns);

							runAns.remove(runAns.size()-1);
							usedm[i] = false;
							usedw[j] = false;
						}
					}
				}
			}
		}
	}

	public static int eval(ArrayList<pair> test)
	{
		int ans = 0;

		for(pair p : test)
			ans += p.getHap();

		return ans;
	}
}
