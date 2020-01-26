package de.fhws.fiw.altklausur;

public class Nettorechner
{
	
	public static float berechneNettopreis(float brutto, float mwst)
	{
		float netto = 0f;
		mwst = mwst + 1;
		
		netto = brutto / mwst;
		
		return netto;
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(berechneNettopreis(1.07f, 0.07f));

	}

}
