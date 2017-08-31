//Adam Doussan AD844156 09/10/2016

import java.io.*;
import java.util.*;

public class shuffle
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			int length = in.nextInt();

			//get rid of nothing
			in.nextLine();

			String leftS = in.nextLine();
			String rightS = in.nextLine();
			String goalS = in.nextLine();

			char [] left = stringToChar(leftS);
			char [] right = stringToChar(rightS);
			char [] leftStart = stringToChar(leftS);
			char [] rightStart = stringToChar(rightS);
			char [] goal = stringToChar(goalS);

			int numRuns = 0;

			while(true)
			{
				numRuns++;

				char [] test = shuffle(left,right);

				if(Arrays.equals(test,goal))
				{
					System.out.format("%d %d%n", i+1, numRuns);
					break;
				}

				left = Arrays.copyOfRange(test,0,(test.length / 2));
				right = Arrays.copyOfRange(test,(test.length / 2), test.length);

				if(Arrays.equals(left,leftStart) && Arrays.equals(right,rightStart))
				{
					System.out.format("%d %d%n",i+1,-1);
					break;
				}
					
			}

			
		}
	}

	public static char [] stringToChar(String temp)
	{
		char [] retval = new char [temp.length()];
		
		for(int i = 0; i < temp.length(); i++)
			retval[i] = temp.charAt(i);

		return retval;
	}

	public static char [] shuffle(char [] left, char [] right)
	{
		char [] retval = new char [left.length + right.length];
		int nextLeft = 0;
		int nextRight = 0;

		for(int i = 0; i < left.length + right.length; i+=2)
		{
			retval[i] = right[nextRight++];
			retval[i+1] = left[nextLeft++];
		}

		return retval;
	}
}
