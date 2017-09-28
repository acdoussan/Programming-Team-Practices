import java.util.Scanner;

public class choose {
	public static void main(String [] args)
	{	
		//int [][] choose = chooseDP(10001);
	}
/*
	public static int [][] chooseDP(int n)
	{
		int [][] choose = new int [n][n];

		for(int i = 0; i < n; i++)
			for(int j = i; j < n; j++)
				choose[i][j] = ((i==j) ? 1 : 0);
		
		for(int i = 0; i < n; i++)
			choose[i][0] = 1;
		
		for(int i = 1; i < n; i++)
			for(int j = 1; j < i; j++)
				choose[i][j] = choose[i-1][j] + choose[i-1][j-1];
	}
	*/
}

