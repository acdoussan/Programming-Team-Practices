// Adam Doussan AD844156 04/15/2017

import java.io.*;
import java.util.*;

public class h
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int [][] mat = new int [n][n];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				mat[i][j] = -in.nextInt();

		fw(mat);

		for(int [] temp : mat)
			System.out.println(Arrays.toString(temp));

		long ans = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				ans = (ans + mat[i][j]) % 1000000007;

		System.out.println(-ans);
	}

	public static int [][] fw(int [][] adj)
	{
		int n = adj.length;
		int [][] m = adj;

		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					m[i][j] = Math.min(m[i][j], m[i][k] + m[k][j]);

		return m;
	}
}
