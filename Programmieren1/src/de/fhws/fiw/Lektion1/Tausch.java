package de.fhws.fiw.Lektion1;

public class Tausch {
	public static void main(String[] args) {
		int x = 5;
		int y = 7;
//Vor dem Tausch
		System.out.println("Wert von x vor dem Tausch: " + x);
		System.out.println("Wert von y vor dem Tausch: " + y + "\n");
//Tausch
		//Definition einer Hilfsvariable als Zwischenspeicher für den Tausch
		int zwischenvariable = x;
		x = y;
		y = zwischenvariable;
//Nach dem Tausch
		System.out.println("Wert von x nach dem Tausch: " + x);
		System.out.println("Wert von y nach dem Tausch: " + y);
	}
}
