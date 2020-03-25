package de.fhws.Programmieren2.Lektion15;

public class QuizTextQuestion extends QuizQuestion
{
	public QuizTextQuestion(String quizQuestion)
	{
		super.quizQuestion = "\n" + quizQuestion + "\n\n";
		super.quizQuestion += "Antwort:\n\n\n";
	}
}
