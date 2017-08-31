// Adam Doussan AD844156 02/04/2017

import java.io.*;
import java.util.*;

public class rps
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		String p1 = in.nextLine();
		String p2 = in.nextLine();

		while(true)
		{
			if(p1.equals("E") && p2.equals("E"))
				break;



			p1 = in.nextLine();
			p2 = in.nextLine();
		}
	}
}
