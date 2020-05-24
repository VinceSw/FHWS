package de.fhws.Programmieren2.Lektion21.Uebung4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ExamTest
{

	@Test
	void test()
	{
		Exam exam = new Exam();
		try
		{
			exam.readQuestions();
			exam.toTest();
		}
		catch(IOException e)
		{
			if(e instanceof FileNotFoundException)
				e.printStackTrace();
			else
				fail("Unexpected error occured");
		}
	}

}
