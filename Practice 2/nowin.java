// Adam Doussan AD844156 09/23/2017

import java.io.*;
import java.util.*;

class Player
{
	int score;
	int aces;

	public Player (char a, char b)
	{
		add(a);
		add(b);
	}

	public Player (Player p)
	{
		score = p.score;
		aces = p.aces;
	}

	// true = bust
	public boolean add (char toAdd)
	{
		if(Character.isLetter(toAdd))
		{
			if(toAdd == 'A')
			{
				score += 11;
				aces++;
			}

			else
			{
				score += 10;
			}
		}

		else
		{
			score += toAdd - '0';
		}

		while(score > 21 && aces > 0)
		{
			score -= 10;
			aces--;
		}

		return score > 21;
	}
}

public class nowin
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		String deck = in.nextLine();

		while(!deck.equals("JOKER"))
		{
			boolean canWin = false;

			Player p = new Player(deck.charAt(0), deck.charAt(2));
			Player d = new Player(deck.charAt(1), deck.charAt(3));

			deck = deck.substring(4);

			if(test(p, new Player(d), deck))
				canWin = true;

			// try progressive hits
			for(int i = 0; i < deck.length(); i++)
			{
				if(canWin)
					break;

				if(p.add(deck.charAt(i)))
					break;
				
				if(test(p, new Player(d), deck.substring(i+1)))
				{
					canWin = true;
					break;
				}
			}

			if(canWin)
				System.out.println("Yes");
			else
				System.out.println("No");

			deck = in.nextLine();
		}
	}

	public static boolean test(Player p, Player d, String deck)
	{
		int c = 0;
		while(d.score < 17)
		{
			d.add(deck.charAt(c++));
		}

		if(d.score > 21)
			return true;
		else
			return p.score >= d.score;
	}
}
