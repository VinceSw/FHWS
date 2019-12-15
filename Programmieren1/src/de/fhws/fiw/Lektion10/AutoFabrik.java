package de.fhws.fiw.Lektion10;

import de.fhws.fiw.Lektion9.Auto;

public class AutoFabrik
{
	int producedCars;
	
	public Auto produziere(String marke, String modell, int hubraum, String farbe, int leistung, String karosserie, int baujahr)
	{
		Auto cars = new Auto(marke, modell, hubraum, farbe, leistung, karosserie, baujahr);
		producedCars++;
		
		return cars;
	}
}
