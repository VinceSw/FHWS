package de.fhws.fiw.Lektion4;

public class Lektion4_Uebung4
{

	public static void main(String[] args)
	{
		float gradCelsius = 0.0f;
		
		System.out.println("Fahrenheit\t\t\tCelsius");
		
		for(float gradFahrenheit = 0; gradFahrenheit <= 300; gradFahrenheit++)
		{
			gradCelsius = 5.0f/9.0f * (gradFahrenheit - 32);
			System.out.println(String.format("%.2f", gradFahrenheit) + "\t\t\t" + String.format("%.2f", gradCelsius));
		}

	}

}
