//Adam Doussan AD844156 05/27/2017

import java.io.*;
import java.util.*;

public class l
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		char [] vow = {'a','i','y','e','o','u'};
		char [] cons = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p',
						'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};

		HashMap<Character, Character> conv = new HashMap<>();

		for(int i = 0; i < vow.length; i++)
			conv.put(vow[i], vow[((i-3)+vow.length)%vow.length]);
		for(int i = 0; i < cons.length; i++)
			conv.put(cons[i], cons[((i-10)+cons.length)%cons.length]);
		conv.put(' ', ' ');

		while(in.hasNextLine())
		{
			String test = in.nextLine();
			StringBuilder ans = new StringBuilder();

			for(int i = 0; i < test.length(); i++)
			{
				char temp = test.charAt(i);

				if(!Character.isAlphabetic(temp))
				{
					ans.append(temp);
					continue;
				}

				if(Character.isUpperCase(temp))
				{
					char temp1 = Character.toLowerCase(temp);

					ans.append(Character.toUpperCase(conv.get(temp1)));
				}
				else
				{
					ans.append(conv.get(temp));
				}
			}
	
			System.out.println(ans.toString());
		}
	}
}
