package de.fhws.Programmieren2.Lektion20.Uebung1;


public class Card
{
	String type, symbol;

	public String getType()
	{
		return type;
	}

	public String getSymbol()
	{
		return symbol;
	}
	
	public Card(Cardtype type, Cardsymbol symbol)
	{
		this.type = type.getValue();
		this.symbol = symbol.getValue();
	}
}
