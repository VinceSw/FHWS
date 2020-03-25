package de.fhws.Programmieren2.Lektion15;

public class Quizpage
{
	
	public static void main(String[] args)
	{
		Quiz quiz = new Quiz();
		QuizQuestion[] textQuestions = quiz.getTextQuestions();
		QuizQuestion[] multiQuestions = quiz.getMultipleChoiceQuestions();
		
		String quizPage = mergeQuestions(textQuestions, multiQuestions);
		
		System.out.println(quizPage);
		
	}
	
	public static String mergeQuestions(QuizQuestion[] textQuestions, QuizQuestion[] multipleChoiceQuestions)
	{
		int amountQuestions = textQuestions.length + multipleChoiceQuestions.length;
		String quizPage = "";
		int amountText = 0;
		int amountMCQ = 0;
		
		for(int i = 0; i < amountQuestions; i++)
		{
			if(i % 2 == 0)
			{
				quizPage += textQuestions[amountText].quizQuestion;
				amountText++;
			}
			else
			{
				quizPage += multipleChoiceQuestions[amountMCQ].quizQuestion;
				amountMCQ++;
			}
		}
		
		return quizPage;
	}
}
