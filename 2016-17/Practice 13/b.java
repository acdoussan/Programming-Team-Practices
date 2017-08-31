//Adam Doussan AD844156 01/28/2017

import java.io.*;
import java.util.*;

public class b
{
	public static HashMap<Character, Integer> atoi;

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();
		in.nextLine();

		atoi = new HashMap<>();
		atoi.put('0', 0);
		atoi.put('1', 1);
		atoi.put('2', 2);
		atoi.put('3', 3);
		atoi.put('4', 4);
		atoi.put('5', 5);
		atoi.put('6', 6);
		atoi.put('7', 7);
		atoi.put('8', 8);
		atoi.put('9', 9);
		atoi.put('A', 10);
		atoi.put('C', 11);
		atoi.put('D', 12);
		atoi.put('E', 13);
		atoi.put('F', 14);
		atoi.put('H', 15);
		atoi.put('J', 16);
		atoi.put('K', 17);
		atoi.put('L', 18);
		atoi.put('M', 19);
		atoi.put('N', 20);
		atoi.put('P', 21);
		atoi.put('R', 22);
		atoi.put('T', 23);
		atoi.put('V', 24);
		atoi.put('W', 25);
		atoi.put('X', 26);


		for(int i = 0; i < run; i++)
		{
			String test = in.nextLine();
			Scanner thisTest = new Scanner(test);
			String pref = thisTest.next();
			test = thisTest.next();

			StringBuilder ans = new StringBuilder();

			for(int j = 0; j < test.length(); j++)
			{
				switch(test.charAt(j))
				{
					case 'B':
						ans.append(8);
						break;

					case 'G':
						ans.append('C');
						break;

					case 'I':
						ans.append(1);
						break;

					case 'O':
						ans.append(0);
						break;

					case 'Q':
						ans.append(0);
						break;

					case 'S':
						ans.append(5);
						break;

					case 'U':
						ans.append('V');
						break;

					case 'Y':
						ans.append('V');
						break;

					case 'Z':
						ans.append(2);
						break;

					default:
						ans.append(test.charAt(j));
						break;
				}
			}

			String thisAns = ans.toString();
			//System.out.println(thisAns);

			long check;
			check = 		 (2 * atoi.get(thisAns.charAt(0))) +
							 (4 * atoi.get(thisAns.charAt(1))) +
							 (5 * atoi.get(thisAns.charAt(2))) +
							 (7 * atoi.get(thisAns.charAt(3))) +
							 (8 * atoi.get(thisAns.charAt(4))) +
							 (10 * atoi.get(thisAns.charAt(5))) +
							 (11 * atoi.get(thisAns.charAt(6))) +
							 (13 * atoi.get(thisAns.charAt(7)));

			check %= 27;
			//System.out.println(check);

			if(check != atoi.get(thisAns.charAt(8)))
			{
				System.out.println(pref + " Invalid");
				continue;
			}

			long finAns = 0;

			for(int j = 0; j < test.length() - 1; j++)
			{
				finAns *= 27;
				finAns += atoi.get(test.charAt(j));
			}

			System.out.println(pref + " " + finAns);
		}		
	}
}
