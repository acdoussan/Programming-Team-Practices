//Adam Doussan AD844156 01/21/2017

import java.io.*;
import java.util.*;

public class steg
{
	final public static char [] convert = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
														'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
														'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
														'X', 'Y', 'Z', '\'', ',', '-', '.', '?'};

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String next = in.nextLine();
		
		StringBuilder currentBits = new StringBuilder();

		while(!next.equals("#"))
		{
			if(next.equals("*"))
			{
				while((currentBits.length() % 5) != 0)
					currentBits.append("0");

				process(currentBits.toString());
				currentBits = new StringBuilder();
			}

			for(int i = 1; i < next.length() - 1; i++)
			{
				if(next.charAt(i) == ' ')
				{
					int count = 1;
					i++;

					while(next.charAt(i) == ' ')
					{
						count++;
						i++;
					}

					if(count % 2 == 0)
						currentBits.append("1");
					else
						currentBits.append("0");
				}
			}

			next = in.nextLine();
		}
	}

	public static void process(String bits)
	{
		ArrayList<String> ans = new ArrayList<>();

		for(int i = 0; i < bits.length(); i += 5)
		{
			ans.add(bits.substring(i, i+5));
		}

		for(int i = 0; i < ans.size(); i++)
			System.out.print(getAns(ans.get(i)));
		System.out.println();
	}

	public static char getAns(String bits)
	{
		int index = 0;//(bits.charAt(0) == '0') ? 0 : 1;

		for(int i = 0; i < bits.length(); i++)
		{
			index *= 2;

			if(bits.charAt(i) == '1')
				index++;
		}
		//System.out.println(index);

		return convert[index];
	}
}
