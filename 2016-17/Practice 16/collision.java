// Adam Doussan AD844156 02/18/2017

import java.io.*;
import java.util.*;

public class collision
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int board = in.nextInt();

		while(board != 0)
		{
			int queenCombs = in.nextInt();

			boolean [] diag1 = new boolean [board * 2 - 1];
			boolean [] diag2 = new boolean [board * 2 - 1];
			boolean [] rows = new boolean [board];
			boolean [] cols = new boolean [board];

			int collisions = 0;

			for(int i = 0; i < queenCombs; i++)
			{
				int k = in.nextInt();
				int x = in.nextInt() - 1;
				int y = in.nextInt() - 1;
				int s = in.nextInt();
				int t = in.nextInt();

				for(int j = 0; j < k; j++)
				{
					int qx = x + (j * s);
					int qy = y + (j * t);

					//System.out.format("Queen at x = %d, y = %d\n", qx, qy);

					if(cols[qx] == false)
						cols[qx] = true;
					else
						collisions++;

					if(rows[qy] == false)
						rows[qy] = true;
					else
						collisions++;

					if(diag1[qy - qx + board - 1] == false)
						diag1[qy - qx + board - 1] = true;
					else
						collisions++;

					if(diag2[qx + qy] == false)
						diag2[qx + qy] = true;
					else
						collisions++;
				}
			}

			System.out.println(collisions);

			board = in.nextInt();
		}
	}
}
