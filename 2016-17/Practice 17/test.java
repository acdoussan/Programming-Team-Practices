// Adam Doussan AD844156 03/04/2017

import java.io.*;
import java.util.*;

public class test
{
	public static void main(String [] args)
	{
		System.out.println(10000);
		for(int i = 0; i < 10000; i++)
		{
			System.out.format("%d %d\n", 1000, (int)(Math.random() * 11));
			for(int j = 0; j < 1000; j++)
			{
				System.out.print((int)(Math.random()*10 + 1) + " ");
			}
			System.out.println();
		}
	}
}
