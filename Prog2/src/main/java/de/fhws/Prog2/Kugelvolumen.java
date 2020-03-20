package de.fhws.Prog2;

public class Kugelvolumen
{
	public static double berechneKugelvolumen(double radius)
	{
		return 4/3*Math.PI*radius*radius*radius;
	}
	
	public static void main(String[] args)
	{
		System.out.println(berechneKugelvolumen(0));
		System.out.println(berechneKugelvolumen(1));
		System.out.println(berechneKugelvolumen(5));
		System.out.println(berechneKugelvolumen(-1));
	}
}
