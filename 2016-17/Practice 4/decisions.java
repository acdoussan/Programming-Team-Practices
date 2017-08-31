//Adam Doussan AD844156 10/01/2016

import java.io.*;
import java.util.*;
import java.awt.Point;

public class decisions
{
	public static void main(String [] args)
	{
		new decisions();
	}
	
	decisions()
	{
		Scanner in = new Scanner(System.in);

		int left = in.nextInt();
		int right = in.nextInt();
		int count = 0;
		while(!(left == -1 && right == -1))
		{
			count++;
			System.out.println();
			System.out.format("Scenario #%d:%n", count);

			binTree tree = new binTree(left,right);

			int start = in.nextInt();
			
			left = in.nextInt();
			right = in.nextInt();

			while(!(left == -1 && right == -1 && start == -1))
			{
				tree.add(start,left,right);

				start = in.nextInt();
			
				left = in.nextInt();
				right = in.nextInt();
			}

			HashMap<Integer, Double> probabilities  = tree.getProbabilities();

			int test = in.nextInt();

			while(test != -1)
			{
				if(probabilities.containsKey(test))
					System.out.format("Location %d: %.2f %c%n", test, probabilities.get(test) * 100, '%');
				else
					System.out.format("Location %d: 0.00 %c%n", test, '%');

				test = in.nextInt();
			}

			if(probabilities.containsKey(test))
				System.out.format("Hotel: %.2f %c%n", probabilities.get(test) * 100, '%');
			else
				System.out.format("Hotel: 0.00 %c%n", '%');

			left = in.nextInt();
			right = in.nextInt();
		}
	}

	class binTree
	{
		Node root;
		
		HashMap<Integer, Double> probabilities;
		HashMap<Integer, ArrayList<Node>> faster;
		
		binTree(int left, int right)
		{
			root = new Node(-2, 0);
			root.left = new Node(left, 1);
			root.right = new Node(right, 1);

			probabilities = new HashMap<>();
			faster = new HashMap<>();

			probabilities.put(left,.5);
			probabilities.put(right,.5);

			ArrayList<Node> temp = new ArrayList<>();
			temp.add(root.left);
			
			faster.put(left, temp);

			temp = new ArrayList<>();
			temp.add(root.right);

			faster.put(right, temp);
		}

		public void add(int search, int left, int right)
		{
			ArrayList<Node> temp = faster.get(search);

			for(Node test : temp)
			{
				test.left = new Node(left, test.depth + 1);
				test.right = new Node(right, test.depth + 1);

				if(probabilities.containsKey(left))
				{
					probabilities.put(left , probabilities.get(left) + Math.pow(.5, test.depth + 1));
				}
				else
				{
					probabilities.put(left , Math.pow(.5, test.depth + 1));
				}

				if(probabilities.containsKey(right))
				{
					probabilities.put(right , probabilities.get(right) + Math.pow(.5, test.depth + 1));
				}
				else
				{
					probabilities.put(right , Math.pow(.5, test.depth + 1));
				}

				if(faster.containsKey(left))
				{
					ArrayList<Node> temp2 = faster.get(left);
					temp2.add(test.left);
					faster.put(left, temp2);
				}
				else
				{
					ArrayList<Node> noName = new ArrayList<>();
					noName.add(test.left);

					faster.put(left, noName);
				}
				if(faster.containsKey(right))
				{
					ArrayList<Node> temp2 = faster.get(right);
					temp2.add(test.right);
					faster.put(right, temp2);
				}
				else
				{
					ArrayList<Node> noName = new ArrayList<>();
					noName.add(test.right);

					faster.put(right, noName);
				}
			}
		
			//add(root, search, left, right, 0);	
		}
/*
		private void add(Node root, int search, int left, int right, int depth)
		{
			if(root == null)
				return;

			if(root.data == search)
			{
				root.left = new Node(left);
				root.right = new Node(right);

				if(probabilities.containsKey(root.left.data))
					probabilities.put(root.left.data , probabilities.get(root.left.data) + Math.pow(.5, depth + 1));
				else
					probabilities.put(root.left.data , Math.pow(.5, depth + 1));
				
				if(probabilities.containsKey(root.right.data))
					probabilities.put(root.right.data , probabilities.get(root.right.data) + Math.pow(.5, depth + 1));
				else
					probabilities.put(root.right.data , Math.pow(.5, depth + 1));
			}

			add(root.left, search, left, right, depth + 1);
			add(root.right, search, left, right, depth + 1);
		}*/

		public HashMap<Integer, Double> getProbabilities()
		{
			return probabilities;
		}

	}
	

	class Node
	{
		int data, depth;
		Node left, right, parent;

		Node(int data, int depth)
		{
			this.data = data;
			this.depth = depth;
		}
	}
}
