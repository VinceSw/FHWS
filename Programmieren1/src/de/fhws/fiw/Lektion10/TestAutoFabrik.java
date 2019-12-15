package de.fhws.fiw.Lektion10;

import de.fhws.fiw.Lektion9.Auto;

public class TestAutoFabrik
{

	public static void main(String[] args)
	{
		AutoFabrik carPlant = new AutoFabrik();
		carPlant.produziere("Ford", "Mustang", 3300, "Black", 165, "Fastback", 1965);
		carPlant.produziere("Chevrolet", "Impala", 7000, "Black", 317, "Hardtop", 1968);
		carPlant.produziere("Chevrolet", "Camaro", 6500, "Yellow", 280, "Coupe", 1966);
		
		System.out.println(carPlant.producedCars);
		
		System.out.println(Auto.anzahlAutos);
	}

}
