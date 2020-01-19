package de.fhws.fiw.altklausur;

public class widmarkTest
{
	
	public float berechneMasse(int drinkVol, float alcVol)
	{
		final float density = 0.8f;
		float mass = 0;
		
		mass = drinkVol * alcVol * density;
		
		return mass;
	}
	
	public float berechneAlkKonzentration(float alcMass, float personWeightInKG, String personType)
	{
		float alcConcentration = 0;
		float reductionFactor = 0;
		String persType = personType.toLowerCase();
		
		if(persType.equals("m") || persType.equals("w") || persType.equals("j"))
		{
			reductionFactor = getReductionFactor(persType);
		}
		else
		{
			System.out.println("Der eingegebene Personen-Typ ist ungültig: " + personType);
			return alcConcentration = -1f;
		}
		
		alcConcentration = alcMass / (personWeightInKG * reductionFactor);
		
		return alcConcentration;
	}
	
	private float getReductionFactor(String personType)
	{
		float reductionFactor = 0f;
		
		if(personType.toLowerCase().equals("m"))
		{
			reductionFactor = 0.7f;
		}
		else if(personType.toLowerCase().equals("w"))
		{
			reductionFactor = 0.6f;
		}
		else if(personType.toLowerCase().equals("j"))
		{
			reductionFactor = 0.5f;
		}
		else
		{
			throw new IllegalArgumentException("Wrong personType: " + personType);
		}
		
		return reductionFactor;
	}
	
}
