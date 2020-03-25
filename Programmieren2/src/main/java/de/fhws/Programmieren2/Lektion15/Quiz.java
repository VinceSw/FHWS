package de.fhws.Programmieren2.Lektion15;

public class Quiz
{
	private QuizQuestion[] textQuestions;
	private QuizQuestion[] multipleChoiceQuestions;
	
	public QuizQuestion[] getTextQuestions()
	{
		return textQuestions;
	}

	public QuizQuestion[] getMultipleChoiceQuestions()
	{
		return multipleChoiceQuestions;
	}
	
	
	public Quiz()
	{
		textQuestions = generateTextQuestion();
		multipleChoiceQuestions = generateMultipleChoiceQuestion();
	}
	
	
	
	public QuizTextQuestion[] generateTextQuestion()
	{
		QuizTextQuestion[] textQuestion = new QuizTextQuestion[6];
		textQuestion[0] = new QuizTextQuestion("Was ist die Hauptstadt von Deutschland?");
		textQuestion[1] = new QuizTextQuestion("Wie lautet die hexadezimale Zahl 1BF6 zur Basis 10?");
		textQuestion[2] = new QuizTextQuestion("Was ist der Unterschied zwischen einem Compiler und einem Interpreter?");
		textQuestion[3] = new QuizTextQuestion("Woraus besteht das JDK?");
		textQuestion[4] = new QuizTextQuestion("Wofür wird JUNIT verwendet?");
		textQuestion[5] = new QuizTextQuestion("Wofür wird ein Import-Befehl verwendet?");
		
		return textQuestion;
	}
	
	public QuizMultipleChoiceQuestion[] generateMultipleChoiceQuestion()
	{
		QuizMultipleChoiceQuestion[] multipleChoiceQuestion = new QuizMultipleChoiceQuestion[6];
		
		String question = "Wieviel Protonen hat ein Wasserstoffatom?";
		String[] answers = {"4", "2", "1", "0"};
		multipleChoiceQuestion[0] = new QuizMultipleChoiceQuestion(question, answers);
		
		question = "Welches der folgenden Schlüsselworte wird verwendet, um von eine Superklasse zu erben?";
		answers = new String[]{"super", "this", "throws", "extends"};
		multipleChoiceQuestion[1] = new QuizMultipleChoiceQuestion(question, answers);
		
		question = "Welche der folgenden Deklarationen ist die richtige,\n wenn die Klasse B von der Klasse A erben soll?";
		answers = new String[]{"class B + class A {}", "class B inherits class A {}", "class B extends A {}", "class B extends class A {}"};
		multipleChoiceQuestion[2] = new QuizMultipleChoiceQuestion(question, answers);
		
		question = "Alle Klassen in Java erben von welcher der folgenden Klassen?";
		answers = new String[]{" java.lang.class", "java.class.inherited", "java.class.object", "java.lang.Object"};
		multipleChoiceQuestion[3] = new QuizMultipleChoiceQuestion(question, answers);
		
		question = "Wie muss eine Variable deklariert werden, um zu verhindern, \ndass sie in einer Subklasse verwendet werden kann?";
		answers = new String[]{"private", "default", "static", "protected", "public"};
		multipleChoiceQuestion[4] = new QuizMultipleChoiceQuestion(question, answers);
		
		question = "Welches Schlüsselwort wird verwendet, wenn Superklasse und Subklasse den gleichen Variablennamen verwenden,\n "
				+ "aber die Variable der Superklasse verwendet werden soll?";
		answers = new String[]{"super", "this", "upper", "classname"};
		multipleChoiceQuestion[5] = new QuizMultipleChoiceQuestion(question, answers);
		
		return multipleChoiceQuestion;
	}
	
	
}
