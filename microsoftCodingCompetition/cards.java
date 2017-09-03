// Adam Doussan AD844156 09/01/2017

import java.io.*;
import java.util.*;

public class cards
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		in.nextLine();
		char[][] chars = {{'1','2','3'}, {'E', 'F', 'S'}, {'G', 'P', 'R'}, {'O', 'D', 'S'}};
		int c = 0;

		for(int rr = 0; rr < r; rr++)
		{
			c++;
			String line = in.nextLine();

			Scanner temp = new Scanner(line);
			String f = temp.next();
			String s = temp.next();


			ArrayList<HashSet<Character>> seen = new ArrayList<>();

			for(int i = 0; i < 4; i++)
				seen.add(new HashSet<>());

			seen.get(0).add(f.charAt(0));
			seen.get(1).add(f.charAt(1));
			seen.get(2).add(f.charAt(2));
			seen.get(3).add(f.charAt(3));

			seen.get(0).add(s.charAt(0));
			seen.get(1).add(s.charAt(1));
			seen.get(2).add(s.charAt(2));
			seen.get(3).add(s.charAt(3));

			String ans = "";

			for(int i = 0; i < 4; i++)
			{
				if(seen.get(i).size() == 1)
				{	
					for(char cc : seen.get(i))
						ans = ans + cc;
				}
				else
				{
					for(int j = 0; j < 3; j++)
					{
						if(!seen.get(i).contains(chars[i][j]))
						{
							ans = ans+chars[i][j];
							break;
						}
					}
				}
			}

			System.out.format("Group %d: %s\n", c, ans);
		}
	}
}
