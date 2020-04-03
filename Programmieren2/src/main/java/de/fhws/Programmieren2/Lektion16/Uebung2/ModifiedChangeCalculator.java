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
		
		if(!checkChange(resultChangeArray, euros*100+cent))
		{
			SimpleChangeCalculator scc = new SimpleChangeCalculator();
			scc.getChange(euros, cent);
		}
		
		return resultChangeArray;
	}
	
	public boolean checkChange(int[] changeArray, int fullChangeInCents)
	{
		int result = 0;
		Coin[] coins = Coin.values();
		
		for(int i = 0; i < changeArray.length; i++)
		{
			result += changeArray[i] * coins[i].value;
		}
		
		if(result == fullChangeInCents) return true;
		
		return false;
	}
}
