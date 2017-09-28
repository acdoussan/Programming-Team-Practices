import java.util.*;

public class editor {
	final public static int oo = (int) 1e9;
	
	public static int [] dx = {1,0,-1,0};
	public static int [] dy = {0,1,0,-1};
	
	public static void main(String [] args)
	{	
		Scanner in = new Scanner(System.in);
		
		int run = in.nextInt();
		
		for(int rr = 0; rr<run; rr++)
		{
			int rows = in.nextInt();
			
			int [][] dist = new int[rows][];

			for(int i = 0; i < rows; i++)
			{
				dist[i] = new int [in.nextInt()+1];
			}
			int x = in.nextInt()-1;
			int y = in.nextInt();
			bfs(dist, x, y);
			
			System.out.println(dist[in.nextInt()-1][in.nextInt()]);
		}
	}
	
	public static void bfs(int [][] dist, int x, int y)
	{
		for(int i = 0; i < dist.length; i++)
		{
			for(int j = 0; j < dist[i].length; j++)
			{
				dist[i][j] = oo;
			}
		}
		
		PriorityQueue<call> pq = new PriorityQueue<>();
		pq.add(new call(x,y,0));
		
		while(!pq.isEmpty())
		{
			call cur = pq.remove();
			//System.out.println(cur.x + " " + cur.y);
			
			if(dist[cur.x][cur.y] <= cur.d)
				continue;
			
			dist[cur.x][cur.y] = cur.d;
			
			genCalls(pq, cur, dist);
		}
		
	}
	
	public static void genCalls(PriorityQueue<call> pq, call cur, int [][] dist)
	{
		call[] calls = new call[4];
		calls[0] = new call(cur.x+1, cur.y, cur.d+1);
		calls[1] = new call(cur.x-1, cur.y, cur.d+1);
		calls[2] = new call(cur.x, cur.y+1, cur.d+1);
		calls[3] = new call(cur.x, cur.y-1, cur.d+1);
		
		if(calls[0].x >= dist.length)
			calls[0] = null;
		if(calls[0] != null && calls[0].y >= dist[calls[0].x].length)
			calls[0].y = dist[calls[0].x].length-1;
		
		if(calls[1].x < 0)
			calls[1] = null;
		if(calls[1] != null && calls[1].y >= dist[calls[1].x].length)
			calls[1].y = dist[calls[1].x].length-1;
		
		if(calls[2].y >= dist[calls[2].x].length)
		{
			if(calls[2].x+1 >= dist.length)
				calls[2] = null;
			else
			{
				calls[2].y = 0;
				calls[2].x += 1; 
			}
		}
			
		
		if(calls[3].y < 0)
		{
			if(calls[3].x-1 < 0)
				calls[3] = null;
			else
			{
				calls[3].x -= 1;
				calls[3].y = dist[calls[3].x].length-1;
			}
		}
		
		for(int i = 0; i < 4; i++)
			if(calls[i] != null)
				pq.add(calls[i]);
	}
}

class call implements Comparable<call>
{
	int x, y, d;
	
	public call(int x, int y, int d)
	{
		this.x=x;this.y=y;this.d=d;
	}
	
	public int compareTo(call o)
	{
		return this.d-o.d;
	}
}
