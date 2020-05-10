package de.fhws.Programmieren2.Lektion20.Uebung1;

public enum Cardtype
{
	EINS(1), ZWEI(2), DREI(3), VIER(4), FUENF(5), SECHS(6), SIEBEN(7), ACHT(8), NEUN(9), ZEHN(10), BUBE("Bube"), DAME("Dame"), KOENIG("Koenig"), ASS("Ass");
	
	private String value;
	
	private Cardtype(int value)
	{
		this.value = String.valueOf(value);
	}

	private Cardtype(String s)
	{
		this.value = s;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	
}
