//Adam Doussan AD844156 05/13/2017

import java.io.*;
import java.util.*;

public class j
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		String test = in.nextLine();
		String exp = in.nextLine();

		while(test.contains(exp))
			test = test.replaceAll(exp, "");

		if(test.length() != 0)
			System.out.println(test);
		else
			System.out.println("FRULA");
	}
}
