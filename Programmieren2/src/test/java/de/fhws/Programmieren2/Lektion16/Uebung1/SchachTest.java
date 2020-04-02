package de.fhws.Programmieren2.Lektion16.Uebung1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SchachTest
{

	@Test
	void testDameGibErlaubteFelder()
	{
		Dame d = new Dame(5, 4);
		LaeuferImpl l = new LaeuferImpl(5, 4);
		TurmImpl t = new TurmImpl(5, 4);
		boolean[][] dameBrett = d.gibErlaubteFelder().brett;
		boolean[][] laeuferBrett = l.gibErlaubteFelder().brett; 
		boolean[][] turmBrett = t.gibErlaubteFelder().brett;
				
		for(int j = 0; j < dameBrett.length; j++)
		{
			for(int i = 0; i < dameBrett[j].length; i++)
			{
				if(laeuferBrett[j][i] == true || turmBrett[j][i] == true)
				{
					assertTrue(dameBrett[j][i]);
				}
				else
				{
					assertFalse(dameBrett[j][i]);
				}
			}
		}
	}
	
//	@Test
//	void testeTurm()
//	{
//		boolean[][] turm = new boolean[8][8];
//		for(int i = 0; i < turm.length; i++)
//		{
//			for(int j = 0; j < turm[i].length; j++)
//			{
//				if(i == 4)
//				{
//					turm[i][j] = true;
//				}
//				else if(j == 5)
//				{
//					turm[i][j] = true;
//				}
//				else
//				{
//					turm[i][j] = false;
//				}
//			}
//		}
//	}
		
	@Test
	void testVisualDameGibErlaubteFelder()
	{
		Dame d = new Dame(5, 4);
		LaeuferImpl l = new LaeuferImpl(5, 4);
		TurmImpl t = new TurmImpl(5, 4);
		boolean[][] dameBrett = d.gibErlaubteFelder().brett;
		boolean[][] laeuferBrett = l.gibErlaubteFelder().brett; 
		boolean[][] turmBrett = t.gibErlaubteFelder().brett;
		
		outputBrett(dameBrett);
		outputBrett(laeuferBrett);
		outputBrett(turmBrett);
	}
	
	public void outputBrett(boolean[][] inputBrett)
	{
		System.out.println();
		for(int j = 0; j < inputBrett.length; j++)
		{
			for(int i = 0; i < inputBrett[j].length; i++)
			{
				if(inputBrett[j][i] == true) System.out.print("x ");
				else System.out.print("o ");
			}
			System.out.println();
		}
	}
}
