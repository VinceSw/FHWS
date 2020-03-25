package de.fhws.Programmieren2.Lektion15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuizTest
{

	@Test
	void testQuizMultipleChoiceQuestion()
	{
		String question = "Wieviel Protonen hat ein Wasserstoffatom?";
		String[] answers = new String[4];
		answers[0] = "4";
		answers[1] = "2";
		answers[2] = "1";
		answers[3] = "0";
		
		QuizMultipleChoiceQuestion qmcq = new QuizMultipleChoiceQuestion(question, answers);
		
		System.out.print(qmcq.quizQuestion);
		System.out.print("------------------------------------------------------------------------");
	}
	
	@Test
	void testQuizTextQuestion()
	{
		String question = "Was ist die Hauptstadt von Deutschland?";
		
		QuizTextQuestion qtq = new QuizTextQuestion(question);
		
		System.out.print(qtq.quizQuestion);
		System.out.print("------------------------------------------------------------------------");
	}
	
}
