//Adam Doussan AD844156 05/20/2017

import java.io.*;
import java.util.*;

public class c
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 1; i <= run; i++)
		{
			int [][] hex = new int[7][6];

			for(int j = 0; j < 7; j++)
			{
				for(int k = 0; k < 6; k++)
				{
					hex[j][k] = in.nextInt();
				}
			}

			boolean[] used = new boolean[7];
			int [] ans = new int[7];
			int [] rot = new int[7];

			if(!runAns(hex, 0, used, ans, rot))
				System.out.println("Case " + i + ": No solution");

			else
			{
				System.out.print("Case " + i + ":");
				printAns(ans);
			}
		}
	}

	public static boolean runAns(int[][] hex, int depth, boolean [] used, int [] ans, int [] rot)
	{
		if(depth == 7)
		{
			//System.out.println("Here");
			//printAns(ans);

			if(hex[ans[6]][(1 + rot[ans[6]]) % 6] == hex[ans[1]][(4 + rot[ans[1]]) % 6])
				return true;

			return false;
		}

		for(int i = 0; i < 7; i++)
		{
			//printAns(ans);

			if(depth == 0)
			{
				for(int j = 0; j < 6; j++)
				{
					if(hex[i][j] == 1)
					{
						rot[i] = j;
						ans[0] = i;
						used[i] = true;
						if(runAns(hex, depth + 1, used, ans, rot))
							return true;
						used[i] = false;
					}
				}
			}

			else if(depth == 1)
			{
				for(int j = 0; j < 6; j++)
				{
					if(hex[ans[0]][rot[ans[0]]] == hex[i][(3 + j) % 6] && used[i] == false)
					{
						rot[i] = j;
						used[i] = true;
						ans[1] = i;

						if(runAns(hex, depth + 1, used, ans, rot))
							return true;

						used[i] = false;
					}
				}
			}

			else
			{
				for(int j = 0; j < 6; j++)
				{
					if(hex[ans[0]][(depth - 1 + rot[ans[0]]) % 6] == hex[i][(depth + 2 + j) % 6] && used[i] == false)
					{
						if(hex[ans[depth - 1]][(depth + rot[ans[depth - 1]]) % 6] == hex[i][(depth + 3 + j) % 6])
						{
							rot[i] = j;
							used[i] = true;
							ans[depth] = i;

							if(runAns(hex, depth + 1, used, ans, rot))
								return true;

							used[i] = false;
						}
					}
				}
			}
		}

		return false;
	}

	public static void printAns(int [] ans)
	{
		for(int i = 0; i < ans.length; i++)
			System.out.print(" " + ans[i]);
		System.out.println();
	}
}
