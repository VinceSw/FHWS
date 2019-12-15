package de.fhws.fiw.Lektion3;

public class Lektion3_�bung4
{

	public static void main(String[] args)
	{
		// Generate random number between 1 and 6 
		int rolled = (int)(Math.random() * 6 + 1);
		String messageText;
		
		if(rolled == 1)
		{
			messageText = "Eins gew�rfelt";
		}
		else if(rolled == 2)
		{
			messageText = "Zwei gew�rfelt";
		}
		else if(rolled == 3)
		{
			messageText = "Drei gew�rfelt";
		}
		else if(rolled == 4)
		{
			messageText = "Vier gew�rfelt";
		}
		else if(rolled == 5)
		{
			messageText = "F�nf gew�rfelt";
		}
		else if (rolled == 6)
		{
			messageText = "Sechs gew�rfelt";
		}
		else
		{
			//Throw exception if 
			throw new IllegalArgumentException(rolled + " is not a valid Integer");
		}
		
		System.out.println(rolled);
		System.out.println(messageText);
	}

}
