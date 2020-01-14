package de.fhws.fiw.Lektion11;

public class Textdokument
{
	private char[][] textdokument;
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public String getTextdokument()
	{
		String stringTextdokument = "";
		
		for(int i = 0; i < this.textdokument.length; i++)
		{
			stringTextdokument += String.copyValueOf(this.textdokument[i]) + "\n";
		}
		
		return stringTextdokument;
	}
	
	public Textdokument()
	{
		this.textdokument = new char[1][1];
	}
	
	public Textdokument(char[][] newTextDoc)
	{
		this.textdokument = newTextDoc;
	}
	
	public int zaehleZeichen()
	{
		int anzahlZeichen = 0;
		
		for(int i = 0; i < this.textdokument.length; i++)
		{
			for(int j = 0; j < this.textdokument[i].length; j++)
			{
				if(this.textdokument[i][j] != ' ')
				{
					anzahlZeichen++;
				}
			}
		}
		
		return anzahlZeichen;
	}
	
	public boolean vertauscheZeilen(int line1, int line2)
	{
		boolean isValid = true;
		
		if(line1 > 0 && line2 > 0 && line1 <= this.textdokument.length && line2 <= this.textdokument.length)
		{
			char[] temp = this.textdokument[line1];
			this.textdokument[line1] = this.textdokument[line2];
			this.textdokument[line2] = temp;
		}
		else
		{
			isValid = false;
		}
		
		return isValid;
	}
	
	public void fuegeEinTextdokument(char[][] newTextDoc, int startingPos)
	{
		int lengthNewDoc = newTextDoc.length + this.textdokument.length;
		char[][] temp = new char[lengthNewDoc][];

		if(startingPos <= this.textdokument.length)
		{
			int newDocIndex = 0;
			int textDocIndex = 0;
			
			for(int i = 0; i < lengthNewDoc; i++)
			{
				if(i >= startingPos && i < (startingPos + newTextDoc.length))
				{
					temp[i] = newTextDoc[newDocIndex];
					newDocIndex++;
				}
				else
				{
					temp[i] = this.textdokument[textDocIndex];
					textDocIndex++;
				}
			}
			
			this.textdokument = temp;
		}
		else
		{
			throw new IllegalArgumentException("Startposition darf nicht höher als länge des Gesamtdokumentes sein!");
		}
	}

}
