package de.fhws.fiw.Lektion11;

import java.util.Arrays;
import java.util.Random;

public class TicTacToe3D
{
	static boolean[][][] gameField = new boolean[3][3][3];

	public boolean[][][] getGameField()
	{
		return gameField;
	}

	public static void fillGameField(boolean[][][] gameField)
	{
		boolean arrayContains = false;
		
		
		for(int i = 0; i < gameField.length; i++)
		{
			int anzahlX = 0;
			int anzahlO = 0;
			
			for(int j = 0; j < gameField[i].length; j++)
			{	
				int randomInt; 
				int[] speicher = new int[gameField[i][j].length];
				Arrays.fill(speicher, speicher.length);
				
				for(int n = 0; n < speicher.length; n++)
				{
					randomInt = getRandomInt(3);
					
					for(int m = 0; m < speicher.length; m++)
					{
						if(speicher[m] == randomInt)
						{
							arrayContains = true;
						}
					}
					
					if(arrayContains)
					{
						arrayContains = false;
						n--;
					}
					else
					{
						speicher[n] = randomInt;
					}
				}
				
				for(int k = 0; k < gameField[i].length; k++)
				{			
					if(anzahlX > anzahlO)
					{
						gameField[i][j][speicher[k]] = false;
						anzahlO++;
					}
					else
					{
						gameField[i][j][speicher[k]] = true;
						anzahlX++;
					}
				}
			}
		}
	}
	
	private static int getRandomInt(int range)
	{
		final Random randomInt = new Random();
		return randomInt.nextInt(range);
	}

	public static void main(String[] args)
	{
		fillGameField(gameField);
		outputGamefield(gameField);
	}

	public static void outputGamefield(boolean[][][] gameField)
	{
		char resultXO;
		for(int i = 0; i < gameField.length; i++)
		{
			System.out.println((i + 1) + ".Ebene:");
			for(int j = 0; j < gameField[i].length; j++)
			{
				for(int k = 0; k < gameField[i][j].length; k++)
				{
					resultXO = gameField[i][j][k] == true ? 'X' : 'O';
					System.out.print(resultXO + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
