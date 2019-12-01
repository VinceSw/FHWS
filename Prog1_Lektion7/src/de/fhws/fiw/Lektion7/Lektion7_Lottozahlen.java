package de.fhws.fiw.Lektion7;

public class Lektion7_Lottozahlen
{

	public static void main(String[] args)
	{
		getLotteryNumbers();
	}

	public static int[] getLotteryNumbers()
	{
		int[] lottoArray = new int[6];

		for (int i = 0; i < 6; i++)
		{
			int lottozahl = (int) (Math.random() * 49 + 1);
			boolean taken = alreadyTaken(lottoArray, lottozahl);
			
			boolean t2 = 1 == 2 ? true : false;

			if (!taken)
			{
				lottoArray[i] = lottozahl;
			} else
			{
				taken = false;
				i--;
			}
		}

		lottoArray = sortArray(lottoArray);
		
		displayLottNumbers(lottoArray);
		return lottoArray;
	}

	public static boolean alreadyTaken(int[] lottoArray, int lottozahl)
	{
		boolean taken = false;

		for (int j = 0; j < lottoArray.length; j++)
		{
			if (lottoArray[j] == lottozahl)
			{
				taken = true;
			}
		}

		return taken;
	}
	
	public static int[] sortArray(int[] lottoArray)
	{
		for (int i = 0; i < lottoArray.length - 1; i++) 
		{
			for (int j = i + 1; j < lottoArray.length; j++)
			{
				if(lottoArray[i] > lottoArray[j])
				{
					int temp = lottoArray[i];
					lottoArray[i] = lottoArray[j];
					lottoArray[j] = temp;
				}
			}
		}
		
		return lottoArray;
	}

	public static void displayLottNumbers(int[] lottoArray)
	{
		for(int i = 0; i < lottoArray.length; i++)
		{
			System.out.println((i+1) + ". Zahl: " + lottoArray[i]);
		}
	}
}
