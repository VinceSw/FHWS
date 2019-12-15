package de.fhws.fiw.Lektion2;

public class Lektion2_Uebung2 {

	public static void main(String[] args) {
		//Definition of necessary variables
		float xsqr = 3.00f;
		float p = 5.00f;
		float q = 1.00f;
		float x1 = 0.00f;
		float x2 = 0.00f;
		
		//prepare values for pq-formula
		if (p != 0 && q != 0)
		{
			p /= xsqr;
			q /= xsqr;
			xsqr /= xsqr;
		}
		
		try
		{
			//Calculating the pq-formula
			x1 = (-p/2) + (float)Math.sqrt((Math.pow((p/2), 2) - q));
			x2 = (-p/2) - (float)Math.sqrt((Math.pow((p/2), 2) - q));			
			
		} catch(ArithmeticException ae) {
			//Output in case the "try"-block throws an arithmetic exception
			throw new ArithmeticException(ae.getMessage());
			
		}
		
		//Output for results
		System.out.println("xsqr: \t" + xsqr + "\np: \t" + p + "\nq: \t" + q + "\n");
		System.out.println("\nErgebnis x1: " + x1);
		System.out.println("Ergebnis x2: " + x2);
		
		
	}
}

