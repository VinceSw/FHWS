package de.fhws.fiw.altklausur;

public class PolynomN
{
	double[] poly;
	
	public PolynomN(double[] poly) {
		this.poly = poly;
	}
	
	public double berechneStelleX(double x) {
		int laenge = poly.length;
		double erg = 0;
		for (int i = 0; i< poly.length; i++) {
			erg = erg+ poly[i]*Math.pow(x, laenge-1);
			laenge--;
		}
		return erg;
	}
	
	public PolynomN leiteAb() {
		int laengeNeu = poly.length-1;
		double[] polyNeu = new double[laengeNeu];
		
		for(int i= 0; i<poly.length-1;i++) {
			polyNeu[i]=poly[i]*laengeNeu;
			laengeNeu--;
		}
		PolynomN neu = new PolynomN(polyNeu);
		return neu;
	}
	
	public static void main(String[] args) {
		double[] polynom = {5,4,3,2,1};
		PolynomN test = new PolynomN(polynom);
		double p = test.berechneStelleX(1);
		double z = test.leiteAb().berechneStelleX(1);
		System.out.println(p);
		System.out.println(z);
		
	}
}
