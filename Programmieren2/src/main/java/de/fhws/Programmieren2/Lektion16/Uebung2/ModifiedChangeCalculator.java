package de.fhws.Programmieren2.Lektion16.Uebung2;

public class ModifiedChangeCalculator implements ChangeCalculator
{
	public int[] getChange(int euros, int cent)
	{
		Coin[] changeCoinArray = Coin.values();
		int[] resultChangeArray = new int[8];
		int fullChangeInCents = euros * 100 + cent;
		
		for(int i = changeCoinArray.length-1; i >= 0; i--)
		{
			int currentCoin = changeCoinArray[i].value;
			
			resultChangeArray[i] = (int)(fullChangeInCents / currentCoin);	
			fullChangeInCents %= currentCoin;
		}
		
		return resultChangeArray;
	}
}
