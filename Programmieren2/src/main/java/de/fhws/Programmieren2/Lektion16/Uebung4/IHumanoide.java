package de.fhws.Programmieren2.Lektion16.Uebung4;

public interface IHumanoide
{
	public void arbeiten();
	public Reaktion autofahren(Gefahrensituation gefahr);
	public Reaktion entscheide(Gefahrensituation gefahr);
}
