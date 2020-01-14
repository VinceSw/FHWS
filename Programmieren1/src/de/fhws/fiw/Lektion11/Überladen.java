package de.fhws.fiw.Lektion11;

public class Überladen
{

	public static void main(String[] args)
	{
		int eingabeIntPos = 15;
		int eingabeIntNeg = -15;
		float eingabeFloatPos = 15;
		float eingabeFloatNeg = -15;
		double eingabeDoublePos = 15;
		double eingabeDoubleNeg = -15;
		short eingabeShortPos = 15;
		short eingabeShortNeg = -15;
		long eingabeLongPos = 15;
		long eingabeLongNeg = -15;
		
		System.out.println("Betrag von " + eingabeIntPos +  ":\t " + betrag(eingabeIntPos) + " (int)");
		System.out.println("Betrag von " + eingabeIntNeg +  ": \t" + betrag(eingabeIntNeg) + " (int)");
		System.out.println("Betrag von " + eingabeFloatPos +  ": \t" + betrag(eingabeFloatPos) + " (float)");
		System.out.println("Betrag von " + eingabeFloatNeg +  ": \t" + betrag(eingabeFloatNeg) + " (float)");
		System.out.println("Betrag von " + eingabeDoublePos +  ": \t" + betrag(eingabeDoublePos) + " (double)");
		System.out.println("Betrag von " + eingabeDoubleNeg +  ": \t" + betrag(eingabeDoubleNeg) + " (double)");
		System.out.println("Betrag von " + eingabeShortPos +  ":  \t" + betrag(eingabeShortPos) + " (short)");
		System.out.println("Betrag von " + eingabeShortNeg +  ": \t" + betrag(eingabeShortNeg) + " (short)");
		System.out.println("Betrag von " + eingabeLongPos +  ":  \t" + betrag(eingabeLongPos) + " (long)");
		System.out.println("Betrag von " + eingabeLongNeg +  ": \t" + betrag(eingabeLongNeg) + " (long)");
		
	}
	
	public static int betrag(int eingabe)
	{
		if(eingabe < 0)
		{
			eingabe *= -1;
		}
		
		return eingabe;
	}
	
	public static float betrag(float eingabe)
	{
		if(eingabe < 0)
		{
			eingabe *= -1;
		}
		
		return eingabe;
	}
	
	public static double betrag(double eingabe)
	{
		if(eingabe < 0)
		{
			eingabe *= -1;
		}
		
		return eingabe;
	}
	
	public static short betrag(short eingabe)
	{
		if(eingabe < 0)
		{
			eingabe *= -1;
		}
		
		return eingabe;
	}
	
	public static long betrag(long eingabe)
	{
		if(eingabe < 0)
		{
			eingabe *= -1;
		}
		
		return eingabe;
	}

}
