package de.fhw.fiw.prog1.lektion2;

public class Lektion2_Uebung1 {

	public static void main(String[] args) {
		//Definitions 
		int r = 5;
		final float PI = (float) Math.PI;
		
		//Calculations
		float diskArea = (float) (PI * Math.pow(r, 2));
		float circlePeriphery = 2 * PI * r;
		float sphericalVolume = (float) (4f/3f * PI * Math.pow(r, 3));
		
		//Output
		System.out.println("Radius: \t\t\t" + r + "\n");
		System.out.println("Area of the disk: \t\t" + diskArea);
		System.out.println("Periphery of the circle: \t" + circlePeriphery);
		System.out.println("Spherical volume: \t\t" + sphericalVolume);
	}

}
