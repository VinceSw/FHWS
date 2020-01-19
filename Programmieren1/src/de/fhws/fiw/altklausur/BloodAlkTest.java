package de.fhws.fiw.altklausur;

public class BloodAlkTest
{

	public static void main(String[] args)
	{
		widmarkTest bloodTest = new widmarkTest();
		final int drinkVol = 1000;
		final float alcVol = 0.05f;
		final int personWeightInKG = 70;
		final String personType = "m";
		float alcMass = bloodTest.berechneMasse(drinkVol, alcVol);
		float alcConcentration = bloodTest.berechneAlkKonzentration(alcMass, personWeightInKG, personType);
		
		System.out.println("Aufgenommene Alkoholmasse: \t" + alcMass);
		System.out.println("Alkoholkonzentration im Blut: \t" + alcConcentration + "\n");
		
		if(alcConcentration >= 0.5)
		{
			System.out.println("Sie dürfen kein Auto mehr fahren!!!");
		}
		else if(alcConcentration >= 0.3)
		{
			System.out.println("Sie sollten kein auto mehr fahren!!!");
		}
	}

}
