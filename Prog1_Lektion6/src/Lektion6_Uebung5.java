import java.util.Scanner;

public class Lektion6_Uebung5
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie die Basis ein: \t");
		float inputBase = Float.valueOf(inputScan.nextLine());
		System.out.print("Bitte geben Sie den Exponenten ein: \t");
		int inputExponent = Integer.valueOf(inputScan.nextLine());
		
		System.out.println("Ergebnis: " + raiseToPower(inputBase, inputExponent));

	}
	
	public static double raiseToPower(float base, int exponent)
	{
		double x = base;
		
		if(exponent == 0)
		{
			return 1d;
		}
		else
		{
			x *= raiseToPower(base, --exponent);
		}
		
		return x;
		
	}

}
