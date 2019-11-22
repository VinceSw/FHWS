import java.util.Scanner;

public class Lektion6_Uebung2
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie eine Zahl ein: ");
		int inputNumber = Integer.valueOf(inputScan.nextLine());
		
		int fak = getFaculty(inputNumber);
		
		System.out.println("Fakultät von " + inputNumber + ":\t" + fak);
		inputScan.close();
	}
	
	public static int getFaculty(int inputNumber)
	{
		int result = 1; 
		if(inputNumber == 0)
		{
			return 1;
		}
		else
		{
			result = inputNumber * getFaculty(inputNumber - 1);
			return result;
		}
	}

}
