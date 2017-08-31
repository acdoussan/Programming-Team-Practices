//Adam Doussan AD844156 01/28/2017

import java.io.*;
import java.util.*;

class Point
{
	public int x,y;

	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public String toString()
	{
		return String.format("x=%d y=%d", x,y);
	}
}

public class g
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int run = in.nextInt();

		for(int i = 0; i < run; i++)
		{
			System.out.println(in.nextInt());

			int [][] board = new int[8][8];
			HashMap<Integer,Point> seen = new HashMap<>();

			for(int j = 0; j < 8; j++)
			{
				for(int k = 0; k < 8; k++)
				{
					board[j][k] = in.nextInt();
					if(board[j][k] != -1)
						seen.put(board[j][k], new Point(j,k));
				}
			}

			solve(board, seen, 1, null);
		}
	}

	public static boolean solve(int [][] board, HashMap<Integer, Point> seen, int depth, Point lastMove)
	{
		if(depth == 65)
		{

			if(checkAns(board))
			{
				printAns(board);
				return true;
			}

			System.out.println("Bad ans");
			return false;
		}
				

		if(depth == 1 && !seen.containsKey(1))
		{
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(board[i][j] == -1)
					{
						board[i][j] = 1;
						if(solve(board, seen, depth + 1, new Point(i,j)))
							return true;
						board[i][j] = -1;
					}
				}
			}
		}

		else if(depth == 1 || seen.containsKey(depth))
		{
			return solve(board, seen, depth + 1, seen.get(depth));
		}

		else
		{
			ArrayList<Point> attPoints = getAttackPoints(lastMove.x, lastMove.y);

			for(Point test : attPoints)
			{
				//System.out.println("Trying " + test);

				try
				{
					if(board[test.x][test.y] == -1)
					{
						board[test.x][test.y] = depth;
						if(solve(board, seen, depth + 1, test))
							return true;
						board[test.x][test.y] = -1;
					}
				}
				catch(Exception e)
				{
				}
			}
		}

		return false;
	}

	public static boolean checkAns(int [][] board)
	{
		int [] rowSums = new int[8];
		int [] colSums = new int[8];

		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				rowSums[i] += board[i][j];
				colSums[j] += board[i][j];
			}
		}

		for(int i = 0; i < 7; i++)
			if(!(rowSums[i] == rowSums[i + 1]))
				return false;
		for(int i = 0; i < 7; i++)
			if(!(colSums[i] == colSums[i + 1]))
				return false;

		return (colSums[0] == rowSums[0]);
	}

	public static void printAns(int [][] board)
	{
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				System.out.print(board[i][j] + ((i == 7) ? '\n' : ' '));
	}

	public static ArrayList<Point> getAttackPoints(int i, int j)
	{
		ArrayList<Point> testPoints = new ArrayList<>();

		testPoints.add(new Point((i + 1), (j + 2) ));
		testPoints.add(new Point((i + 2), (j + 1) ));
		testPoints.add(new Point((i - 1), (j - 2) ));
		testPoints.add(new Point((i - 2), (j - 1) ));
		testPoints.add(new Point((i + 1), (j - 2) ));
		testPoints.add(new Point((i - 1), (j + 2) ));
		testPoints.add(new Point((i + 2), (j - 1) ));
		testPoints.add(new Point((i - 2), (j + 1) ));

		return testPoints;
	}
}
