import java.util.Scanner;

public class Lektion6_Uebung3
{

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Bitte geben Sie die Größe des Baumes: ");
		int treeSize = Integer.valueOf(inputScan.nextLine());
		
		printStar(treeSize);
		
		inputScan.close();
	}
	
	public static void printStar(int treeSize)
	{
		for(int i = 1; i <= treeSize; i++)
		{
			for(int k = treeSize - i; k > 0; k--)
			{
				System.out.print(" ");
			}
			for(int j = 1; j <= i ; j++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
		}
	}

}
