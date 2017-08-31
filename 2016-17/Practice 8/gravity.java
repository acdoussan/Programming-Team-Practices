//Adam Doussan AD844156 11/19/2016

import java.io.*;
import java.util.*;

public class gravity
{
	char [][] matrix;
	int row,col;

	gravity()
	{
		Scanner in = new Scanner(System.in);

		row = in.nextInt();
		col = in.nextInt();

		matrix = new char[row][col];

		in.nextLine();

		for(int i = 0; i < row; i++)
		{
			String temp = in.nextLine();

			for(int j = 0; j < col; j++)
				matrix[i][j] = temp.charAt(j);
		}

		solve();
		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
				
	}

	public void solve()
	{
		for(int i = row - 2; i >= 0; i--)
		{
			for(int j = 0; j < col; j++)
			{
				if(matrix[i][j] == 'o')
					for(int k = i + 1; k < row; k++)
					{
						if(matrix[k][j] == '#' || matrix[k][j] == 'o')
							break;

						swap(k,j);
					}
			}
		}
			
	}

	public void swap(int k, int j)
	{
		char temp = matrix[k][j];
		matrix[k][j] = matrix[k-1][j];
		matrix[k-1][j] = temp;
	}

	public static void main(String [] args)
	{
		new gravity();
	}
}
