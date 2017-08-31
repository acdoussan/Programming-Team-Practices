//Adam Doussan AD844156 10/22/2016

import java.io.*;
import java.util.*;

class Point
{
	double x, y;

	Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public String toString()
	{
		return String.format("x = %f y = %f", x, y);
	}
}

class Vector
{
	Point tail;
	double mag;
	double [] vec;
	
	Vector(Point x, Point y)
	{
		this.tail = x;
		vec = new double [2];
		vec[0] = y.x - x.x;
		vec[1] = y.y - x.y;
		mag = Math.sqrt(Math.pow(vec[0],2) + Math.pow(vec[1],2));
	}

	Vector(Vector v)
	{
		this.tail = v.tail;
		this.mag = v.mag;
		this.vec = new double [2];
		this.vec[0] = v.vec[0];
		this.vec[1] = v.vec[1];
	}

	public void mult(double k)
	{
		vec[0] *= k;
		vec[1] *= k;

		mag *= k;
	}

	public String toString()
	{
		return String.format("x = %f, y = %f", vec[0], vec[1]);
	}
}

public class euclid
{
	public static void main(String [] args)
	{
		new euclid();
	}

	euclid()
	{
		Scanner in = new Scanner(System.in);

		double [] inputs = new double [12];

		for(int i = 0; i < 12; i++)
		{
			inputs[i] = in.nextDouble();
		}

		while(!zeroCheck(inputs))
		{
			Point [] points = new Point[6];

			for(int i = 0; i < 12; i+=2)
			{
				points[i / 2] = new Point(inputs[i], inputs[i+1]);
			}

			Vector DE = new Vector(points[3], points[4]);
			Vector DF = new Vector(points[3], points[5]);
			System.out.println(DE);
			System.out.println(DF);

			double areaDEF = cross(DE,DF) / 2;
			System.out.println("Area " + areaDEF);

			Vector AB = new Vector(points[0], points[1]);
			Vector AC = new Vector(points[0], points[2]);
			Vector AH = new Vector(points[0], points[2]);
			AH.mult(.5);

			AH = binSearch(AB,AH,areaDEF);

			Point H = new Point(AH.vec[0] + AH.tail.x,AH.vec[1] + AH.tail.y);
			Point G = new Point(points[1].x, H.y);

			System.out.format("%.3f %.3f %.3f %.3f\n",G.x, G.y, H.x, H.y);

			for(int i = 0; i < 12; i++)
			{
				inputs[i] = in.nextDouble();
			}
			
		}
	}

	public boolean zeroCheck(double [] inputs)
	{
		for(int i = 0; i < 12; i++)
		{
			if(inputs[i] != 0.0)
				return false;
		}
		return true;
	}

	public double cross(Vector A, Vector B)
	{
		double [] Avec = A.vec;
		double [] Bvec = B.vec;

		return ((Avec[0] * Bvec[1]) - (Avec[1] * Bvec[0]));
	}

	public Vector binSearch(Vector AB,Vector AH, double key)
	{
		double start = Double.MIN_VALUE, end = Double.MAX_VALUE, look = ((end-start) / 2) + start;
		Vector v = null;
		double temp, test = 1;


		while(test > .0001)
		{
			v = new Vector(AH);
			v.mult(look);
			temp = cross(AB,v);

			if(temp < 0)
				temp *= -1;

			test = temp - key;

			if( test < .0001 )
				return v;

			if(temp > key)
			{
				end = look;
				look = ((end-start) / 2) + start;
			}
			else
			{
				start = look;
				look = ((end-start) / 2) + start;
			}
		}

		return v;
	}
}
