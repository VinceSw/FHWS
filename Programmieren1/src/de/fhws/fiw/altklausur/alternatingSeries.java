package de.fhws.fiw.altklausur;

public class alternatingSeries
{
	public static void series(int tries)
	{
		int k = 1;
		double seriesResult = 0d;
		
		while(k <= tries)
		{
			seriesResult = Math.pow(-1, k + 1) / k;
			k++;
		}
		
		System.out.println(seriesResult);
	}
	
	public static void main(String[] args)
	{
		series(10000);
	}

}
