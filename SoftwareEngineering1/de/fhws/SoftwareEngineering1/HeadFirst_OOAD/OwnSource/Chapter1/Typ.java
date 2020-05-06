package de.fhws.SoftwareEngineering1.HeadFirst_OOAD.OwnSource.Chapter1;

public enum Typ
{
	ELEKTRISCH, AKUSTISCH;
	
	@Override
	public String toString()
	{
		switch (this)
		{
		case ELEKTRISCH:
			return "elektrisch";
		case AKUSTISCH:
			return "akustisch";
		default:
			return null;
		}
	}
}
