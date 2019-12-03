package de.fhws.fiw.Lektion8;

public class Lieblingsautos
{

	public static void main(String[] args)
	{
		Auto fordMustang = new Auto();
		fordMustang.Marke = "Ford";
		fordMustang.Modell = "Mustang";
		fordMustang.Baujahr = 1965;
		fordMustang.HubraumL = 3.3f;
		fordMustang.Farbe = "Schwarz";
		fordMustang.LeistungKW = 165;
		
		Auto chevroletImpala = new Auto();
		chevroletImpala.Marke = "Chevrolet";
		chevroletImpala.Modell = "Impala";
		chevroletImpala.Baujahr = 1968;
		chevroletImpala.HubraumL  = 7.0f;
		chevroletImpala.Farbe = "Schwarz";
		chevroletImpala.LeistungKW = 317;
		
		Auto chevroletCamaro = new Auto();
		chevroletCamaro.Marke = "Chevrolet";
		chevroletCamaro.Modell = "Camaro";
		chevroletCamaro.Baujahr = 1966;
		chevroletCamaro.HubraumL = 6.5f;
		chevroletCamaro.Farbe = "Gelb";
		chevroletCamaro.LeistungKW = 280;
		
		if(fordMustang.HubraumL > chevroletImpala.HubraumL && fordMustang.HubraumL > chevroletCamaro.HubraumL)
		{
			System.out.println("Marke:\t\t" + fordMustang.Marke);
			System.out.println("Modell:\t\t" + fordMustang.Modell);
			System.out.println("Baujahr:\t" + fordMustang.Baujahr);
			System.out.println("Hubraum(l):\t" + fordMustang.HubraumL);
			System.out.println("Farbe:\t\t" + fordMustang.Farbe);
			System.out.println("Leistung(KW):\t" + fordMustang.LeistungKW);
		}
		else if(chevroletImpala.HubraumL > chevroletCamaro.HubraumL)
		{
			System.out.println("Marke:\t\t" + chevroletImpala.Marke);
			System.out.println("Modell:\t\t" + chevroletImpala.Modell);
			System.out.println("Baujahr:\t" + chevroletImpala.Baujahr);
			System.out.println("Hubraum(l):\t" + chevroletImpala.HubraumL);
			System.out.println("Farbe:\t\t" + chevroletImpala.Farbe);
			System.out.println("Leistung(KW):\t" + chevroletImpala.LeistungKW);
		}
		else
		{
			System.out.println("Marke:\t\t" + chevroletCamaro.Marke);
			System.out.println("Modell:\t\t" + chevroletCamaro.Modell);
			System.out.println("Baujahr:\t" + chevroletCamaro.Baujahr);
			System.out.println("Hubraum(l):\t" + chevroletCamaro.HubraumL);
			System.out.println("Farbe:\t\t" + chevroletCamaro.Farbe);
			System.out.println("Leistung(KW):\t" + chevroletCamaro.LeistungKW);
		}
	}

}
