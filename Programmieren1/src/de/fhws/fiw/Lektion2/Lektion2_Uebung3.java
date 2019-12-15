package de.fhws.fiw.Lektion2;

import java.time.LocalTime;

public class Lektion2_Uebung3 {

	public static void main(String[] args) {
		LocalTime lTime = LocalTime.now();
		int stunden = lTime.getHour();
		int minuten = lTime.getMinute();
		int sekunden = lTime.getSecond();
		
		int sekSeitMitternacht = ((stunden*60)+ minuten) * 60 + sekunden;
		int sekBisMitternacht  = ((((23-stunden)*60) + (60 - minuten)) * 60) - sekunden;
		float prozentVergangen   = 100.00f / (float) (24 * Math.pow(60, 2)) * sekSeitMitternacht;
		
		System.out.println("Stunden:\t" + stunden + "\nMinuten:\t" + minuten + "\nSekunden:\t" + sekunden + "\n-------------------------------------------------");
		
		System.out.println("Vergangene Sekunden seit Mitternacht: \t" + sekSeitMitternacht);
		System.out.println("Verbleibende Sekunden bis Mitternacht: \t" + sekBisMitternacht);
		System.out.println("Zeit seit Mitternacht in %: \t\t" + prozentVergangen);
	}

}
