package de.fhws.Programmieren2.Lektion20.Uebung2;

public enum Cardsymbol
{
	KREUZ("Kreuz"), PIK("Pik"), KARO("Karo"), HERZ("Herz");
	
	private String value;
	
	private Cardsymbol(String s)
	{
		this.value = s;
	}
	
	public String getValue()
	{
		return this.value;
	}
}
