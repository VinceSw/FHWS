package de.fhws.Programmieren2.Lektion21.Uebung4;

public class Question {
	String text; //Fragentext
	
	public Question(String line)
	{
		text = line;
	}
	
	//Wandelt eine eingelesene Zeile in ein Question-Objekt um
	public static Question toQuestion(String line) 
	{ 
		Question question = new Question(line);
		return question;
	}
}
