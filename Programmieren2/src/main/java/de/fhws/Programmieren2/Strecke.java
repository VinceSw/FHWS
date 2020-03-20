package de.fhws.Programmieren2;

public class Strecke
{
	int a, b;
	
	public Strecke(int a, int b)
	{
		if(a < 0 || b < 0) throw new RuntimeException("Invalid Arguement");
		
		if(a < b)
		{
			this.a = a;
			this.b = b;
		}
		else
		{
			this.a = b;
			this.b = a;
		}
	}

	public boolean isCrossing(Strecke strecke)
	{
		boolean isCrossing = false;
		if((this.a > strecke.a && this.a < strecke.b) || (this.b > strecke.a && this.b < strecke.b) ||
				(strecke.a > this.a && strecke.b < this.b)) 
		{
			isCrossing = true;
		}
		
		return isCrossing;
	}
	
	@Override
	public String toString()
	{
		String strecke = "" + a;
		int difference = b - a;
		
		if(a < b)
		{
			for(int i = 0; i < difference - 1; i++)
			{
				strecke += '-';
			}
			
			strecke += b;
		}

		return strecke;
	}
}
