package de.fhws.fiw.altklausur;

public class VielfacheVon3
{

	public static int vielfacheVonDrei(int[] number)
	{
		int amountMultiples = 0;
		
		for(int i = 0; i < number.length; i++)
		{
			if(number[i] % 3 == 0 && number[i] != 0)
			{
				amountMultiples++;
			}
		}
		
		return amountMultiples;
	}
	
	public static void main(String[] args)
	{
		int[] number = new int[10];
		number[0]= -3;
		number[1]= -1;
		number[2]= 0;
		number[3]= 2;
		number[4]= 3;
		number[5]= 7;
		number[6]= 9;
		number[7]= 44;
		number[8]= 39;
		number[9]= 123;
		System.out.println(vielfacheVonDrei(number));

	}

}
