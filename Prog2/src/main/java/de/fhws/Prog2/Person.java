package de.fhws.Prog2;

public class Person
{
	String vorname, nachname;
	Adresse adresse;
	
	public Person(String vorname, String nachname, String strasse, String hausnummer, String postleitzahl, String ort)
	{
		if(!Character.isUpperCase(vorname.charAt(0))) throw new RuntimeException("Invalid Arguement");
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = new Adresse(strasse, hausnummer, postleitzahl, ort);
	}
}
