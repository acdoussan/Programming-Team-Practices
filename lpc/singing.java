import java.util.Scanner;

public class singing {
	public static void main(String [] args)
	{	
		Scanner in = new Scanner(System.in);
		
		int run = in.nextInt();
		
		for(int r = 0; r<run; r++)
		{
			//System.out.println("a");
			int t = in.nextInt();
			int s = in.nextInt();
			
			int [] songs = new int [s];
			
			for(int i = 0; i < s; i++)
			{
				songs[i] = in.nextInt();
			}
			
			long ans = 0;
			for(int i = 1; i < s; i++)
			{
				ans += Math.min(distFor(songs[i-1], songs[i], t), distBack(songs[i-1], songs[i], t));
			}
			
			System.out.println(ans);
		}
		System.out.flush();
	}
	
	public static int distFor(int from, int to, int len)
	{
		if(to <= from)
			return len-from + to - 1;
		else
			return to-from-1;
	}
	
	public static int distBack(int from, int to, int len)
	{
		if(to > from)
			return from + len - to + 1;
		else
			return from - to + 1;
	}
}
