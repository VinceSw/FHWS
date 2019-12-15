package de.fhws.fiw.Lektion8;

public class Lektion8_Rechner
{

	public static void main(String[] args)
	{
		System.out.println(calculateArgs(args));

	}
	
	public static double calculateArgs(String[] args)
	{
		int argsLength = args.length-1;
		String operator = args[argsLength];
		double result = 0d;
		
		if(operator.equals("+"))
		{
			result = addArgs(args);
		}
		else if(operator.equals("-"))
		{
			result = subtractArgs(args);
		}
		
		return result;
	}

	public static double addArgs(String[] args)
	{
		double result = Double.valueOf(args[0]);
		
		for(int i = 1; i < args.length - 1;i++)
		{
			result += Double.valueOf(args[i]);
		}
		
		return result;
	}
	
	public static double subtractArgs(String[] args)
	{
		double result = Double.valueOf(args[0]);
		
		for(int i = 1; i < args.length - 1;i++)
		{
			result -= Double.valueOf(args[i]);
		}
		
		return result;
	}
}
