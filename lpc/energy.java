
import java.util.*;
import java.io.*;

public class energy {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		int run = in.nextInt();
		
		for(int i = 0; i < run; i++)
		{
			int test = in.nextInt();
			
			long ans = (test <= 1000) ? a*test : (a * 1000) + (b * (test-1000));
			
			System.out.format("%d %d\n",test, ans);
		}
	}
}
