import java.util.*;
import java.io.*;

public class typing {
	public static char [][] let = { {'a','b','c','d','e','f','g','h','i'}, 
									{'j','k','l','m','n','o','p','q','r'},
									{'s','t','u','v','w','x','y','z'}};

	public static int [] dx = {1,0,-1,0,1,-1,1,-1};
	public static int [] dy = {0,1,0,-1,1,-1,-1,1};
	
	public static void main(String [] args)
	{

		
		Scanner in = new Scanner(System.in);
		
		int run = in.nextInt();
		
		for(int rr=0; rr<run; rr++)
		{
			String a = in.next();
			String b = in.next();
			
			if(a.length() != b.length())
			{
				System.out.println(3);
				continue;
			}

			boolean ident = true;
			boolean sim = true;
			for(int i = 0; i < a.length(); i++)
			{
				
				if(a.charAt(i) == b.charAt(i))
				{
					continue;
				}
				
				else if(similar(a.charAt(i), b.charAt(i)))
				{
					
					ident = false;
				}
				
				else
				{
					//System.out.format("%c %c\n", a.charAt(i), b.charAt(i));
					ident=false;
					sim = false;
					break;
				}
			}
			
			if(ident)
			{
				System.out.println(1);
			}
			
			else if(sim)
			{
				System.out.println(2);
			}
			
			else
			{
				System.out.println(3);
			}
		}
	}
	
	public static boolean similar(char a, char b)
	{
		int[] idx = get(a);
		//System.out.println(Arrays.toString(idx));
		for(int i = 0; i < 8; i++)
		{
			try
			{
				if(let[ idx[0]+dx[i] ][ idx[1]+dy[i] ] == b)
					return true;
			}
			catch(Exception e)
			{
				
			}
		}
		
		return false;
	}
	
	public static int[] get(char a)
	{
		int [] ans = new int [2];
		if(a <= 'i')
		{
			ans[0] = 0;
			ans[1] = a - 'a';
		}
		
		else if(a <= 'r')
		{
			ans[0] = 1;
			ans[1] =  a - 'j';
		}
		
		else
		{
			ans[0] = 2;
			ans[1] = a - 's';
		}
		
		
		return ans;
	}
}
