// Adam Doussan AD844156 02/04/2017

import java.io.*;
import java.util.*;

public class dup
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String test = in.nextLine();

		while(!test.equals("0"))
		{
			Scanner temp = new Scanner(test);

			int run = temp.nextInt();

			ArrayList<Integer> thisReq = new ArrayList<>();

			for(int i = 0; i < run; i++)
			{
				thisReq.add(temp.nextInt());
			}

			int prev = thisReq.get(0);

			System.out.print(prev + " ");

			for(int i = 1; i < thisReq.size(); i++)
			{
				if(thisReq.get(i) != prev)
					System.out.print(thisReq.get(i) + " ");
				prev = thisReq.get(i);
			}

			System.out.println("$");

			test = in.nextLine();
		}
	}
}
