package de.fhws.fiw.Lektion9;

public class Pizza
{
	String name;
	float[][]durchmPreis;
	
	public String getName()
	{
		return this.name;
	}
	
	public String setName(String name)
	{
		return this.name = name;
	}
	
	public float[][] getDurchmPreis()
	{
		return this.durchmPreis;
	}
	
	public int getDurchmesser(int index)
	{
		return (int)this.durchmPreis[index][0];
	}
	
	public float getPrice(int index)
	{
		return this.durchmPreis[index][1];
	}
	
	public float[][] setDurchmPreis(float[] durchmesser, float[] preis)
	{
		for(int i = 0; i < durchmPreis.length; i++)
		{
			this.durchmPreis[i][0] = durchmesser[i];
			if(i < preis.length)
			{
				this.durchmPreis[i][1] = preis[i];
			}
			else
			{
				this.durchmPreis[i][1] = 0f;
			}
		}
		
		return this.durchmPreis;
	}
	
	public Pizza(String name, float[][] durchmPreis)
	{
		this.name = name;
		this.durchmPreis = durchmPreis;
	}
}
