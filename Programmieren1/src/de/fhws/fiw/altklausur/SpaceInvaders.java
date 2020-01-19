package de.fhws.fiw.altklausur;

import java.util.Scanner;

public class SpaceInvaders
{
	char[][] gameField = new char[4][8];
	
	public SpaceInvaders()
	{
		int randomPos = (int)(Math.random() * 8);
		buildGamefield(randomPos);
		System.out.println(this.toString());
	}
	
	public int getPositionShip()
	{
		int lastColumn = gameField.length-1;
		int pos = 0;
				
		for(int j = 0; j < gameField[lastColumn].length; j++)
		{
			if(gameField[lastColumn][j] == 'V')
			{
				pos = j;
				break;
			}
		}
		
		return pos;
	}
	
	public void play()
	{
		Scanner inputScan = new Scanner(System.in);
		char inputChar = inputScan.nextLine().trim().charAt(0);
		int posShip = 0;
		
		while(inputChar != 'x' && inputChar != 'X')
		{
			posShip = getPositionShip();
			
			if(inputChar == 'a')
			{
				if(posShip > 0)
				{
					buildGamefield(posShip-1);
					System.out.println(this.toString());
				}
				else
				{
					System.out.println(this.toString());
				}
				
			}
			else if(inputChar == 'd')
			{
				if(posShip < 7)
				{
					buildGamefield(posShip+1);	
					System.out.print(this.toString());
				}
				else
				{
					System.out.println(this.toString());
				}
			}
			
			inputChar = inputScan.nextLine().trim().charAt(0);
		}
		
		inputScan.close();
	}
	
	public void buildGamefield(int pos)
	{
		for(int i = 0; i < gameField.length; i++)
		{
			for(int j = 0; j < gameField[i].length; j++)
			{
				if(i == 0)
				{
					gameField[i][j] = 'o';
				}
				else
				{
					if(i == gameField.length - 1 && j == pos)
					{
						gameField[i][j] = 'V';
					}
					else
					{
						gameField[i][j] = ' ';
					}
				}
			}
		}		
	}
	
	public String toString()
	{
		String output = "";
		
		for(int i = 0; i < this.gameField.length; i++)
		{
			for(char n : gameField[i])
			{
				output += n;
			}
			
			output += "\n";
		}

		return output;
	}
}
