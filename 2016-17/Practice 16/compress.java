// Adam Doussan AD844156 02/18/2017

import java.io.*;
import java.util.*;
import java.awt.Point;

public class compress
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int count = 0;

		while(n != 0)
		{
			count++;

			double perc = (double)in.nextInt();
			in.nextLine();

			int [][] matrix = new int [n][n];

			for(int i = 0; i < n; i++)
			{
				String temp = in.nextLine();

				for(int j = 0; j < n; j++)
					matrix [i][j] = Integer.parseInt(temp.charAt(j) + "");
			}

			int [][] ans = solve(matrix, n, perc);

			System.out.format("Image %d:\n", count);

			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					System.out.format("%d%s", ans[i][j], ((j == n - 1) ? "\n" : ""));

			n = in.nextInt();
		}
	}

	public static int [][] solve(int [][] matrix, int n, double thresh)
	{
		if(n == 1)
			return matrix;

		int [][] thisAns = new int [n][n];

		int count = 0;

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(matrix[i][j] == 1)
					count++;

		double thisPerc = (((double)count) / (n*n)) * 100;

		//System.out.println(thisPerc);
		//System.out.println(count);

		if(thisPerc >= thresh)
		{
			for(int [] temp : thisAns)
				Arrays.fill(temp ,1);
			return thisAns;
		}

		if(100 - thisPerc >= thresh)
		{
			for(int [] temp : thisAns)
				Arrays.fill(temp ,0);
			return thisAns;
		}

		int [][] q1 = new int [n / 2][n / 2];
		int [][] q2 = new int [n / 2][n / 2];
		int [][] q3 = new int [n / 2][n / 2];
		int [][] q4 = new int [n / 2][n / 2];

		// fill quads
		for(int i = n / 2; i < n; i++)
			for(int j = n / 2; j < n; j++)
				q1[i - (n / 2)][j - (n / 2)] = matrix[i][j];

		for(int i = 0; i < n / 2; i++)
			for(int j = n / 2; j < n; j++)
				q2[i][j - (n / 2)] = matrix[i][j];

		for(int i = n / 2; i < n; i++)
			for(int j = 0; j < n / 2; j++)
				q3[i - (n / 2)][j] = matrix[i][j];

		for(int i = 0; i < n / 2; i++)
			for(int j = 0; j < n / 2; j++)
				q4[i][j] = matrix[i][j];

		q1 = solve(q1, n / 2, thresh);
		q2 = solve(q2, n / 2, thresh);
		q3 = solve(q3, n / 2, thresh);
		q4 = solve(q4, n / 2, thresh);

		// merge quads
		for(int i = n / 2; i < n; i++)
			for(int j = n / 2; j < n; j++)
				thisAns[i][j] = q1[i - (n / 2)][j - (n / 2)];

		for(int i = 0; i < n / 2; i++)
			for(int j = n / 2; j < n; j++)
				thisAns[i][j] = q2[i][j - (n / 2)];

		for(int i = n / 2; i < n; i++)
			for(int j = 0; j < n / 2; j++)
				thisAns[i][j] = q3[i - (n / 2)][j];

		for(int i = 0; i < n / 2; i++)
			for(int j = 0; j < n / 2; j++)
				thisAns[i][j] = q4[i][j];

		return thisAns;
	}
}
