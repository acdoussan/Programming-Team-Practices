//Adam Doussan AD844156 07/08/2017

import java.io.*;
import java.util.*;

class atom implements Comparable<atom>
{
	int count; String type;

	public atom(String type, int count)
	{
		this.type = type;
		this.count = count;
	}

	public int compareTo(atom o)
	{
		return this.type.compareTo(o.type);
	}

	public String toString()
	{
		return count+type;
	}

	public int hashCode()
	{
		return type.hashCode();
	}
}

public class chemistry
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			String form = in.nextLine();

			TreeMap<String, Integer> atomCount = new TreeMap<>();

			solve(form, atomCount);

			int count = 0;

			StringBuilder ans = new StringBuilder();

			for(String key : atomCount.keySet())
			{
				count++;

				int val = atomCount.get(key);

				if(count == 1)
				{
					ans.append(((val == 1) ? "" : val) + key);
				}

				else
				{
					ans.append("+" + ((val == 1) ? "" : val) + key);
				}
			}

			System.out.println(ans.toString());
		}
	}

	public static void solve(String form, TreeMap<String, Integer> atomCount)
	{
		Stack<HashMap<String, atom>> s = new Stack<>();
		s.add(new HashMap<>());

		for(int i = 0; i < form.length(); i++)
		{
			if(form.charAt(i) == '(')
			{
				s.push(new HashMap<>());
			}

			else if(form.charAt(i) == ')')
			{
				int mult = 0;

				while(i+1 < form.length() && Character.isDigit(form.charAt(i+1)))
				{
					mult *= 10;
					mult += form.charAt(i+1) - '0';
					i++;
				}

				HashMap<String, atom> atoms = s.pop();

				for(String temp : atoms.keySet())
				{
					atom a = atoms.get(temp);

					if(mult != 0)
					{
						a.count *= mult;
					}

					if(!s.isEmpty())
					{
						if(s.peek().containsKey(a.type))
							s.peek().get(a.type).count += a.count;
						else
							s.peek().put(a.type, a);
					}

					//atomCount.put(a.type, a.count);
				}
			}

			else
			{
				String name = form.charAt(i)+"";

				while(i+1 < form.length() && Character.isLowerCase(form.charAt(i+1)))
				{
					name += form.charAt(i+1)+"";
					i++;
				}

				int mult = 0;

				while(i+1 < form.length() && Character.isDigit(form.charAt(i+1)))
				{
					mult *= 10;
					mult += form.charAt(i+1) - '0';
					i++;
				}

				//atomCount.put(name, ((mult == 0) ? 1 : mult));

				atom newAtom = new atom(name, ((mult == 0) ? 1 : mult));

				if(!s.isEmpty())
				{
					if(s.peek().containsKey(newAtom.type))
						s.peek().get(newAtom.type).count += newAtom.count;
					else
						s.peek().put(newAtom.type, newAtom);
				}
			}
		}

		HashMap<String, atom> atoms = s.pop();

		for(String temp : atoms.keySet())
		{
			atom a = atoms.get(temp);
			atomCount.put(a.type, a.count);
		}
	}
}
