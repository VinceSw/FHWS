package de.fhws.SoftwareEngineering1.HeadFirst_OOAD.OwnSource.Chapter1;

public enum Hersteller
{
	COLLINGS, FENDER, GIBSON, MARTIN, OLSON, PRS, RYAN, BELIEBIG;
	
	@Override
	public String toString()
	{
		switch (this)
		{
		case COLLINGS:
			return "Collings";
		case FENDER:
			return "Fender";
		case GIBSON:
			return "Gibson";
		case MARTIN:
			return "Martin";
		case OLSON:
			return "Olson";
		case PRS:
			return "PRS";
		case RYAN:
			return "Ryan";
		case BELIEBIG:
			return "Beliebig";
		default:
			return null;
		}
	}
}
