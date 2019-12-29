package de.fhws.fiw.Lektion11;

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
		boolean lastTurn = false;
		
		for(int i = 0; i < gameField.length; i++)
		{
			for(int j = 0; j < gameField[i].length; j++)
			{
				int[] kSpeicher = new int[gameField[i][j].length];
				for(int m = 0; m < kSpeicher.length; m++)
				{
					int randomField = getRandomInt(3);
					if(kSpeicher[m] == 0)
					{
						kSpeicher[m] = randomField;
					}
				}
				
				
				for(int k = 0; k < gameField[i][j].length; k++)
				{
					if(lastTurn == false)
					{
						for(int m = 0; m < kSpeicher.length; m++)
						{
							if(kSpeicher[m] == 0 || m == kSpeicher.length)
							{
								gameField[i][j][m] = true;
								lastTurn = true;
							}
						}
					}
					else
					{
						for(int m = 0; m < kSpeicher.length; m++)
						{
							if(kSpeicher[m] == 0 || m == kSpeicher.length)
							{
								gameField[i][j][m] = false;
								lastTurn = false;
							}
						}
					}
				}
			}
		}
	}

	private static boolean hasHigherAmount(boolean[][][] gameField, int iIndex, int jIndex, boolean searchInd)
	{
		boolean hasHigherAmount = false;
		int countOccurenceTrue = 0;
		
		
		for(int k = 0; k < gameField[iIndex][jIndex].length; k++)
		{
			if(gameField[iIndex][jIndex][k] == searchInd)
			{
				countOccurenceTrue++;
			}
			else
			{
				countOccurenceTrue--;
			}
		}
		
		return hasHigherAmount = countOccurenceTrue > 0 ? true : false;
	}

	private static boolean getRandom()
	{
		final Random randomBool = new Random();
		return randomBool.nextBoolean();
	}
	
	private static int getRandomInt(int range)
	{
		final Random randomInt = new Random();
		return (randomInt.nextInt(range) + 1);
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
