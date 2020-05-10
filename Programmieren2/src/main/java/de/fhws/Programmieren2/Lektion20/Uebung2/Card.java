package de.fhws.Programmieren2.Lektion20.Uebung2;

public class Card implements Comparable<Card>
{
	Cardtype type;
	Cardsymbol symbol;

	public Cardtype getType()
	{
		return type;
	}

	public Cardsymbol getSymbol()
	{
		return symbol;
	}
	
	public Card(Cardtype type, Cardsymbol symbol)
	{
		this.type = type;
		this.symbol = symbol;
	}
	
	@Override
	public int compareTo(Card c)
	{
		int prioSymbolThis = prioritizeSymbol(this.symbol), prioSymbolC = prioritizeSymbol(c.symbol); 
		int prioTypeThis = prioritizeType(this.type), prioTypeC = prioritizeType(c.type);
		
		if(this.symbol.equals(Cardsymbol.KREUZ) && this.type.equals(Cardtype.BUBE)) return -1;
		if(c.symbol.equals(Cardsymbol.KREUZ) && c.type.equals(Cardtype.BUBE)) return 1;
		if(this.type.equals(Cardtype.BUBE))
		{
			if(!c.type.equals(Cardtype.BUBE)) 
			{
				return -1;
			}
			else if(prioSymbolThis < prioSymbolC)
			{
				return 1;
			}
			else
			{
				return 1;
			}
		}
		if(c.type.equals(Cardtype.BUBE)) return 1;
		if(prioSymbolThis < prioSymbolC)
		{
			return 1;
		}
		else if(prioSymbolThis > prioSymbolC)
		{
			return -1;
		}
		else
		{
			if(prioTypeThis < prioTypeC)
			{
				return 1;
			}
			else if(prioTypeThis > prioTypeC)
			{
				return -1;
			}
			
			return this.compareTo(c);
		}
	}
	
	private int prioritizeType(Cardtype cT)
	{
		switch (cT)
		{
			case BUBE :
				return 8;
			case ASS : 
				return 7;
			case ZEHN :
				return 6;
			case KOENIG :
				return 5;
			case DAME :
				return 4;
			case NEUN :
				return 3;
			case ACHT :
				return 2;
			case SIEBEN :
				return 1;
			default :
				throw new IllegalArgumentException("Value is not allowed");
		}
	}
	
	private int prioritizeSymbol(Cardsymbol cS)
	{
		
		switch (cS)
		{
			case KREUZ : 
				return 4;
			case PIK :
				return 3;
			case HERZ :
				return 2;
			case KARO :
				return 1;
			default :
				throw new IllegalArgumentException("Value is not allowed");
		}
	}
}
