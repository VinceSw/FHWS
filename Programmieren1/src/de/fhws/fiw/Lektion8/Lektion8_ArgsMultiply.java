package de.fhws.fiw.Lektion8;

public class Lektion8_ArgsMultiply
{

	public static void main(String[] args)
	{
		if(args.length == 2)
		{
			System.out.println(multiplyArgs(args));
		}
		else
		{
			throw new IllegalArgumentException("Anzahl der Parameter stimmt nicht mit Anforderung " +
														"überein(2): " + args.length);
		}
	}

	public static double multiplyArgs(String[] args)
	{
		return Double.valueOf(args[0]) * Double.valueOf(args[1]);
	}
}
