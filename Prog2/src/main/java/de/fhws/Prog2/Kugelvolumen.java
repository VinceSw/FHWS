package de.fhws.Prog2;

public class Kugelvolumen
{
	public static double berechneKugelvolumen(double radius)
	{
		if(radius < 1) throw new RuntimeException("Invalid Argument");
		return 4/3*Math.PI*radius*radius*radius;
		
	}
}
