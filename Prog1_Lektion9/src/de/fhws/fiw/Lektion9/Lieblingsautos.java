package de.fhws.fiw.Lektion9;

public class Lieblingsautos
{

	public static void main(String[] args)
	{

		Auto[] cars = new Auto[4];
		cars[0] = new Auto("Ford", "Mustang", 3300, "Black", 165, "Fastback", 1965);

		cars[1] = new Auto("Chevrolet", "Impala", 7000, "Black", 317, "Hardtop", 1968);

		cars[2] = new Auto("Chevrolet", "Camaro", 6500, "Yellow", 280, "Coupe", 1966);
		
		int n = 0;
		float max = cars[0].getHubraum();

		for (int i = 0; i < cars.length; i++)
		{
			float hubraum = cars[i].getHubraum();
			if ( hubraum > max)
			{
				max = hubraum;
				n = i;
			}
		}

		System.out.println("Marke: \t\t" + cars[n].getMarke());
		System.out.println("Modell:\t\t" + cars[n].getModell());
		System.out.println("Hubraum(l):\t" + cars[n].getHubraum());
		System.out.println("Farbe:\t\t" + cars[n].getFarbe());
		System.out.println("Leistung(KW):\t" + cars[n].getLeistungKW());
		System.out.println("Karosserie:\t" + cars[n].getKarosserie());
		System.out.println("Baujahr:\t" + cars[n].getBaujahr());
	}

}
