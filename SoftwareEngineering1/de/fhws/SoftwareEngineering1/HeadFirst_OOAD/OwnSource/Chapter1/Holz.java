package de.fhws.SoftwareEngineering1.HeadFirst_OOAD.OwnSource.Chapter1;

public enum Holz
{
	ADIRONDACK, AHORN, COCOBOLO, ERLE, INDISCHER_PALISANDER, MAHAGONI, RIO_PALISANDER, SITKA, ZEDER;
	
	@Override
	public String toString()
	{
		switch (this)
		{
		case ADIRONDACK:
			return "Adirondack";
		case AHORN:
			return "Ahorn";
		case COCOBOLO:
			return "Cocobolo";
		case ERLE:
			return "Erle";
		case INDISCHER_PALISANDER:
			return "Ost-indischer Palisander";
		case MAHAGONI:
			return "Mahagoni";
		case RIO_PALISANDER:
			return "Brasilianischer Palisander";
		case SITKA:
			return "Sitka";
		case ZEDER:
			return "Zeder";
		default:
			return null;
		}
	}
}
