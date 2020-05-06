package de.fhws.Programmieren2.Lektion19.Uebung1;

public class GameWord
{
	private char[] soughtValue;
	
	public char[] getSoughtValue()
	{
		return soughtValue;
	}
	
	public void random()
	{
		/** Prepare the array soughtWord and fill it with a random word out of the array availableWords*/
		String[] availableWords =
			{ "Programmiersprache", "Informatik", "Java", "Klausur", "Basketball", "Bücher", "Musik", "Hackathon", "Surface",
					"Technik", "Technology", "Hangman", "Aufgabe", "Methode", "String", "Character", "Datentyp", "Klassen",
					"Diagramm" };
		
		int randomValue = (int)(Math.random()*availableWords.length);
		soughtValue = availableWords[randomValue].toUpperCase().toCharArray();
	}

}
