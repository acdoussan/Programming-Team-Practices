//Adam Doussan AD844156 01/21/2017

import java.io.*;
import java.util.*;

public class serials
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println(in.nextLine());

		String test = in.nextLine();
		ArrayList<ArrayList<Object>> minRows = new ArrayList<>();

		while(true)
		{
			if(test.equals("0"))
			{
				flattenAns(minRows);
				printAns(minRows);
				test = in.nextLine();
				minRows = new ArrayList<>();

				if(test.equals("END"))
				{
					break;
				}

				System.out.println(test);
			}
			else
			{
				add(minRows, test);
			}

			test = in.nextLine();
		}
	}

	public static void printAns(ArrayList<ArrayList<Object>> minRows)
	{
		for(int i = 0; i < minRows.size(); i++)
		{
			for(int j = 0; j < minRows.get(i).size(); j++)
			{
				Object temp = minRows.get(i).get(j);

				if(temp instanceof String)
					System.out.print((String)minRows.get(i).get(j)
										  + ((j == minRows.get(i).size() - 1 ) ? '\n' : ' '));
				else
					System.out.print(Integer.toString((int)minRows.get(i).get(j))
										  + ((j == minRows.get(i).size() - 1 ) ? '\n' : ' '));
			}
		}
	}

	public static void add(ArrayList<ArrayList<Object>> minRows, String test)
	{
		Scanner walker = new Scanner(test);

		ArrayList<Object> thisReq = new ArrayList<>();

		thisReq.add(walker.nextInt());
		thisReq.add(walker.nextInt());
		thisReq.add(walker.next().trim());
		thisReq.add(walker.nextInt());

		if(minRows.size() == 0)
		{
			minRows.add(thisReq);
			return;
		}

		boolean added = false;

		for(int i = 0; i < minRows.size(); i++)
		{

			// new one ends before this one starts
			if((int)minRows.get(i).get(0) > (int)thisReq.get(1))
			{
				minRows.add(i, thisReq);
				added = true;
				break;
			}

			// starts before and ends within
			if((int)minRows.get(i).get(0) > (int)thisReq.get(0) &&
				(int)minRows.get(i).get(1) > (int)thisReq.get(1))
			{
				ArrayList<Object> split = minRows.get(i);
				ArrayList<Object> bottom = new ArrayList<>();

				bottom.add((int)thisReq.get(1) + 1);
				bottom.add(split.get(1));
				bottom.add(split.get(2));
				bottom.add(split.get(3));

				minRows.set(i, thisReq);
				minRows.add(i + 1, bottom);
		
				added = true;
				break;
			}


			// starts within and ends after
			if((int)minRows.get(i).get(0) < (int)thisReq.get(0) &&
				(int)minRows.get(i).get(1) < (int)thisReq.get(1))
			{
				int j = (i + 1 >= minRows.size()) ? i : i + 1;

				while((int)minRows.get(j).get(1) < (int)thisReq.get(1) &&
						 j + 1 < minRows.size())
					j++;

				ArrayList<Object> split = minRows.get(i);
				ArrayList<Object> top = new ArrayList<>();
				ArrayList<Object> end = minRows.get(j);

				top.add(split.get(0));
				top.add((int)thisReq.get(0) - 1);
				top.add(split.get(2));
				top.add(split.get(3));

				end.set(0, (int)thisReq.get(1) + 1);

				minRows.set(i, thisReq);

				for(int k = i+1; k <= j; k++)
					minRows.remove(i + 1);

				minRows.add(i + 1, end);
				minRows.add(i, top);
		
				added = true;
				break;
			}


			// new one starts at or within and ends at or within current
			if((int)minRows.get(i).get(0) <= (int)thisReq.get(0) && 
				(int)minRows.get(i).get(1) >= (int)thisReq.get(1))
			{
				for(int j = i; j < minRows.size(); j++)
				{
					if((int)minRows.get(j).get(1) > (int)thisReq.get(1))
					{
						// replace
						if(minRows.get(i).get(0) == thisReq.get(0) && minRows.get(j).get(1) == thisReq.get(1))
						{
							minRows.set(i, thisReq);
							added = true;

							for(int k = i+1; k <= j; k++)
								minRows.remove(i + 1);
							break;
						}

						// overwrite top
						else if((int)minRows.get(i).get(0) == (int)thisReq.get(0))
						{
							ArrayList<Object> split = minRows.get(j);
							ArrayList<Object> bottom = new ArrayList<>();

							bottom.add((int)thisReq.get(1) + 1);
							bottom.add(split.get(1));
							bottom.add(split.get(2));
							bottom.add(split.get(3));

							minRows.set(i, thisReq);

							for(int k = i+1; k <= j; k++)
								minRows.remove(i + 1);

							minRows.add(i + 1, bottom);
					
							added = true;
							break;
						}

						// overwrite bottom
						else if((int)minRows.get(j).get(1) == (int)thisReq.get(1))
						{
							ArrayList<Object> split = minRows.get(i);
							ArrayList<Object> top = new ArrayList<>();

							top.add(split.get(0));
							top.add((int)thisReq.get(0) - 1);
							top.add(split.get(2));
							top.add(split.get(3));

							minRows.set(i, thisReq);

							for(int k = i+1; k <= j; k++)
								minRows.remove(i + 1);

							minRows.add(i, top);
					
							added = true;
							break;
						}

						// split
						else
						{
							ArrayList<Object> splitT = minRows.get(i);
							ArrayList<Object> splitB = minRows.get(j);
							ArrayList<Object> top = new ArrayList<>();
							ArrayList<Object> bottom = new ArrayList<>();

							top.add(splitT.get(0));
							top.add((int)thisReq.get(0) - 1);
							top.add(splitT.get(2));
							top.add(splitT.get(3));

							bottom.add((int)thisReq.get(1) + 1);
							bottom.add(splitB.get(1));
							bottom.add(splitB.get(2));
							bottom.add(splitB.get(3));

							minRows.set(i, thisReq);

							for(int k = i+1; k <= j; k++)
								minRows.remove(i + 1);

							minRows.add(i + 1, bottom);
							minRows.add(i, top);
					
							added = true;
							break;
						}
					}

					if(added)
						break;
				}
			}

			if(added)
				break;

		}

		if(!added)
		{
			minRows.add(thisReq);
		}

		//printAns(minRows);
		//System.out.println();
	}

	public static void flattenAns(ArrayList<ArrayList<Object>> minRows)
	{
		for(int i = 0; i < minRows.size(); i++)
		{
			while(minRows.size() > i + 1 && 
					minRows.get(i).get(2).equals(minRows.get(i+1).get(2)) &&
					(int)minRows.get(i).get(3) == (int)minRows.get(i+1).get(3) && 
					(int)minRows.get(i).get(1) + 1 == (int)minRows.get(i+1).get(0))
			{
				minRows.get(i).set(1, minRows.get(i+1).get(1));
				minRows.remove(i+1);
			}
		}
	}
}
