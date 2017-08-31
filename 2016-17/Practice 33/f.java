// Adam Doussan AD844156 07/29/2017

import java.io.*;
import java.util.*;

public class f
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int [] gregLeap = new int [10000];
		int [] julLeap = new int [10000];
		int [] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		int [] runMonth = new int [13];

		for(int i = 1; i < 13; i++)
			runMonth[i] = runMonth[i-1] + daysInMonth[i-1];

		for(int i = 1; i < 10000; i++)
		{
			if(i % 4 == 0)
				julLeap[i] = julLeap[i-1] + 1;
			else
				julLeap[i] = julLeap[i-1];

			if(i % 4 == 0 && !(i % 100 == 0 && !(i % 400 == 0)))
				gregLeap[i] = gregLeap[i-1] + 1;
			else
				gregLeap[i] = gregLeap[i-1];
		}

		while(in.hasNextLine())
		{
			String temp = in.nextLine();

			int year = Integer.parseInt(temp.substring(0,4));
			int month = Integer.parseInt(temp.substring(5,7));
			int day = Integer.parseInt(temp.substring(8,10));

			//System.out.println(year + " " + month + " " + day);

			int greg = gregLeap[year];
			int jul = julLeap[year];

			int daysPassed = jul + ((year-1)*365) + runMonth[month-1] + day-1;

			if(year % 4 == 0 && (month < 2 || month == 2 && day <= 29))
				daysPassed--;

			int ansy = 1, ansm = 1, ansd = 1;

			while(daysPassed > ((ansy % 4 == 0 && !(ansy % 100 == 0 && !(ansy % 400 == 0))) ? 366 : 365))
			{
				daysPassed -= ((ansy % 4 == 0 && !(ansy % 100 == 0 && !(ansy % 400 == 0))) ? 366 : 365);
				ansy++;
			}

			while(daysPassed > daysInMonth[ansm-1] + ((ansm == 2 && ansy % 4 == 0 && !(ansy % 100 == 0 && !(ansy % 400 == 0))) ? 1 : 0))
			{
				daysPassed -= daysInMonth[ansm-1] + ((ansm == 2 && ansy % 4 == 0 && !(ansy % 100 == 0 && !(ansy % 400 == 0))) ? 1 : 0);
				ansm++;
			}

			ansd = daysPassed;
/*
			if(ansd == 0)
			{
				if(ansm == 1)
				{
					ansy--;
					ansm = 12;
					ansd = daysInMonth[11];
				}

				else
				{
					ansm--;
					ansd = daysInMonth[ansm - 1] + ((ansm == 2 && ansy % 4 == 0 && !(ansy % 100 == 0 && !(ansy % 400 == 0))) ? 1 : 0);
				}
			}

*/
			System.out.format("%04d-%02d-%02d\n", ansy, ansm, ansd);
		}
	}
}
