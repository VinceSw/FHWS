package de.fhws.Prog2;

public class Adresse
{
	String strasse, ort, hausnummer, postleitzahl;
	
	public Adresse(String strasse, String hausnummer, String postleitzahl, String ort)
	{
		if(!Character.isUpperCase(strasse.charAt(0)) || !Character.isUpperCase(ort.charAt(0)) ||
				!Character.isDigit(hausnummer.charAt(0)))
			throw new RuntimeException("Invalid Arguement");
		
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
	}
}
