package de.fhws.Programmieren2.Lektion15;

public class QuizMultipleChoiceQuestion extends QuizQuestion
{
	public QuizMultipleChoiceQuestion(String quizQuestion, String[] quizAnswers)
	{
		if(quizQuestion == "" || quizAnswers == null) throw new RuntimeException("Invalid Arguement");
		
		super.quizQuestion = "\n" + quizQuestion + "\n\n";
		super.quizQuestion += "Antwortmöglichkeiten:\n";
		super.quizQuestion += buildAnswerChoiceString(quizAnswers);
	}
	
	public String buildAnswerChoiceString(String[] quizAnswers)
	{
		String result = ""; 
		
		for(int i = 0; i < quizAnswers.length; i++)
		{
			result += (char)(i+65) + ": " + quizAnswers[i] + "\n";
		}
		
		return result;
	}
}
