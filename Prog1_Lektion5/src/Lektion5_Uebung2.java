import java.util.Scanner;

public class Lektion5_Uebung2
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie die Basis an: ");
		double b = Double.valueOf(inputScan.nextLine());
		System.out.print("\nBitte geben Sie den Exponenten ein: ");
		int n = Integer.valueOf(inputScan.nextLine());
		double produkt = 1;
		
		do
		{
			produkt *= b;
			n--;
		}while(n > 0);
		
			System.out.println("Ergebnis: " + produkt);
	}

}
