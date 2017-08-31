// Adam Doussan AD844156 04/07/2017

import java.io.*;
import java.util.*;

public class pancake
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int run = in.nextInt();

		for(int i = 1; i <= run; i++)
		{
			String test = in.next();
			int flip = in.nextInt();

			BitSet state = new BitSet(test.length());
			BitSet lookingFor = new BitSet(test.length());

			lookingFor.set(0, test.length());
			String goal = lookingFor.toString();

			for(int j = 0; j < test.length(); j++)
				if(test.charAt(j) == '+')
					state.set(j);

			if(goal.equals(state.toString()))
			{
				System.out.format("Case #%d: %d\n", i, 0);
				continue;
			}

			HashMap<String, Integer> seen = new HashMap<>();

			Queue<byte[]> q = new ArrayDeque<>();

			seen.put(state.toString(), 0);
			q.add(state.toByteArray());
			int ans = -1;

			while(!q.isEmpty())
			{
				state = BitSet.valueOf(q.remove());
				String thisState = state.toString();
				//System.out.println(thisState);

				for(int j = 0; j <= test.length() - flip; j++)
				{
					state.flip(j, j + flip);
					String thisTest = state.toString();

					if(seen.containsKey(thisTest))
					{
						state.flip(j, j + flip);
						continue;
					}

					if(thisTest.equals(goal))
					{
						ans = seen.get(thisState) + 1;
						break;
					}
		
					seen.put(thisTest, seen.get(thisState)+1);
					q.add(state.toByteArray());
					state.flip(j, j + flip);
				}

				if(ans != -1)
					break;
			}
			

			if(ans == -1)
				System.out.format("Case #%d: IMPOSSIBLE\n", i);
			else
				System.out.format("Case #%d: %d\n", i, ans);
		}
	}
}
