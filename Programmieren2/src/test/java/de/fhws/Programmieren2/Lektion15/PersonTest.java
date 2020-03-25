package de.fhws.Programmieren2.Lektion15;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import de.fhws.Programmieren2.Lektion15.Person;
import de.fhws.Programmieren2.Lektion15.Professor;
import de.fhws.Programmieren2.Lektion15.Student;

class PersonTest
{

//	@Test
//	void testPersonAssertOutput()
//	{
//		Person[] p = getPersons();
//		
//		//Redirecting console output (gibTaetigkeitAus()) to ByteArrayOutputStream
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(outContent));
//		
//		for(Person person : p)
//		{
//			//Clearing any previous buffered content from ByteArrayOutputStream outContent before 
//			//writing new content to outContent
//			outContent.reset();
//			person.gibTaetigkeitAus();
//			
//			if(person instanceof Student)
//			{				
//				assertEquals(Student.STUDIERT_STRING + System.getProperty("line.separator"), outContent.toString());
//			}
//			else if(person instanceof Professor)
//			{
//				assertEquals(Professor.LEHRT_STRING + System.getProperty("line.separator"), outContent.toString());
//			}
//		}
//		System.out.println();
//	}
	
	@Test
	void testPersonConsoleOutput()
	{
		Person[] p = getPersons();
		
		for(Person pe : p)
		{
			pe.gibTaetigkeitAus();
		}
	}
	
	private Person[] getPersons()
	{
		Person[] p = new Person[100];
		
		for(int i = 0; i < 100; i++)
		{
			p[i] = (i % 2 == 0) ? new Student() : new Professor();
		}
		
		return p;
	}

}
