package de.fhws.fiw.altklausur;

public class PrintQuadrat
{

	public static void printQuadrat(int zeilen)
	{
		String output ="";
		
		for(int i = 0; i < zeilen; i++)
		{
			output += "*";
			
			for(int j = 1; j < zeilen; j++)
			{
				if(i == 0 || i == zeilen-1)
				{
					output += "*";
				}
				else
				{
					output += " ";
				}
			}
			
			output += "*\n";
		}
		
		System.out.println(output);
	}
	
	
	public static void main(String[] args)
	{
		printQuadrat(15);

	}

}
