//Adam Doussan AD844156 05/20/2017

import java.io.*;
import java.util.*;

class box
{
	public int [] dim;

	public box(int a, int b, int c)
	{
		dim = new int [3];
		dim[0] = a;
		dim[1] = b;
		dim[2] = c;
	}
}

public class a
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int numBox = in.nextInt();
		int count = 0;

		while(numBox != 0)
		{
			count++;

			box [] boxes = new box [numBox];

			for(int i = 0; i < numBox; i++)
				boxes[i] = new box(in.nextInt(), in.nextInt(), in.nextInt());

			int ans = perm(boxes, new boolean [numBox], new int [numBox], 0, -1);

			System.out.format("Case %d: %d\n", count, ans);

			numBox = in.nextInt();
		}
	}

	public static int perm(box [] boxes, boolean [] visited, int [] rot, int depth, int last)
	{
		if(depth == boxes.length)
		{
			return depth;
		}

		int ans = depth;

		if(depth == 0)
		{
			for(int i = 0; i < boxes.length; i++)
			{
				visited[i] = true;
				for(int j = 0; j < 3; j++)
				{
					rot[i] = j;
					ans = Math.max(ans, perm(boxes, visited, rot, depth+1, i));
				}
				visited[i] = false;
			}
		}

		else
		{
			for(int i = 0; i < boxes.length; i++)
			{
				if(!visited[i])
				{
					for(int j = 0; j < 3; j++)
					{
						if((boxes[last].dim[rot[last]] >= boxes[i].dim[j] &&
							boxes[last].dim[(rot[last]+1) % 3] >= boxes[i].dim[(j+1) % 3]) ||
							(boxes[last].dim[rot[last]] >= boxes[i].dim[(j+1) % 3] &&
							boxes[last].dim[(rot[last]+1) % 3] >= boxes[i].dim[j]))
						{
							rot[i] = j;
							visited[i] = true;
							ans = Math.max(ans, perm(boxes, visited, rot, depth+1, i));
							visited[i] = false;
						}
					}
				}
			}
		}

		return ans;
	}
}
