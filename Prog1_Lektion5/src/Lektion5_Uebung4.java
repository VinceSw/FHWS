import java.util.Scanner;

public class Lektion5_Uebung4
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie eine Zahl ein: ");
		double x = Double.valueOf(inputScan.nextLine());
		double y = 1;
		double t;
		int counter = 0;
		
		do 
		{
			t = y;
			y = ((x/y) + y) / 2;
			counter++;
		}while(t-y != 0);
		
		System.out.println("----------------------------------------------\nWurzel: \t\t" + y);
		System.out.println("Wurzel Math.sqrt: \t" + Math.sqrt(x));
		inputScan.close();
	}

}
