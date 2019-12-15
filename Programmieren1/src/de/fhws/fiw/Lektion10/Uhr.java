package de.fhws.fiw.Lektion10;

public class Uhr
{
	int std;
	int min;
	int sek;
	
	public int getStd()
	{
		return this.std;
	}
	
	public int getMin()
	{
		return this.min;
	}
	
	public int getSek()
	{
		return this.sek;
	}
	
	public void setUhr(int std, int min, int sek)
	{
		if(std > 23 || std < 0 || min > 59 || min < 0 || sek > 59 || sek < 0)
		{
			System.out.println("\nIhre Eingabe war ungültig.");
		}
		else
		{
			this.std = std;
			this.min = min;
			this.sek = sek;
		}
	}
	
	public void naechsteSek()
	{
		if(sek == 59)
		{
			if(min == 59)
			{
				if(std == 23)
				{
					std = 00;
				}
				else 
				{
					std++;
				}
				
				min = 00;
			}
			else
			{
				min++;
			}
			
			sek = 00;
		}
		else
		{
			sek++;
		}
	}
	
	public Uhr(int std, int min, int sek)
	{
		if(std > 23 || std < 0 || min > 59 || min < 0 || sek > 59 || sek < 0)
		{
			setUhr(12, 00, 00);
		}
		else
		{
			setUhr(std, min, sek);
		}
	}
}
