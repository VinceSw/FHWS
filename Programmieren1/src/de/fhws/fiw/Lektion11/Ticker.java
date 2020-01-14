package de.fhws.fiw.Lektion11;

public class Ticker
{
	private char[] nachricht; 
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public Ticker()
	{
		nachricht = new char[200];
		resetNachricht(' ');
	}
	
	public Ticker(int groesse)
	{
		if(groesse <= 0)
		{
			nachricht = new char[200];
		}
		else
		{
			nachricht = new char[groesse];
		}
		
		resetNachricht(' ');
	}
	
	public char[] resetNachricht(char zeichen)
	{
		for(int n = 0; n < this.nachricht.length; n++)
		{
			this.nachricht[n] = zeichen;
		}
		
		return this.nachricht;
	}
	
	public char[] resetNachricht()
	{
		for(int n = 0; n < this.nachricht.length; n++)
		{
			this.nachricht[n] = '+';
		}
		
		return this.nachricht;
	}
	
	public int getGroesse()
	{
		return this.nachricht.length;
	}
	
	public void setNachricht(char[] nachricht)
	{
		for(int i= 0; i < this.nachricht.length; i++)
		{
			if(i >= nachricht.length)
			{
				this.nachricht[i] = '+';
			}
			else
			{
				this.nachricht[i] = nachricht[i];
			}
		}
	}
	
	public String getNachricht()
	{
		String nachrichtKopie = String.copyValueOf(this.nachricht);
		
		return nachrichtKopie;
	}
	
	public void rotateNachricht(int distance)
	{
		int distIter = distance;
		char[] nachrichtTemp = getNachricht().toCharArray();
		
		for(int j = 0; j < this.nachricht.length; j++)
		{
			if(distIter < this.nachricht.length)
			{
				this.nachricht[j] = this.nachricht[(distIter)];
				distIter++;
			}
			else
			{
				break;
			}
		}
		
		distIter -= distance;
		for(int k = 0; k < (distance); k++)
		{
			this.nachricht[distIter] = nachrichtTemp[k];
			distIter++;
		}
	}
}
