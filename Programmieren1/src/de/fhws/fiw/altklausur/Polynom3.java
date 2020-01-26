package de.fhws.fiw.altklausur;

public class Polynom3
{
	double a, b, c, d, x;
	double pol3;
	
	public Polynom3(double a, double b, double c, double d)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		//pol3 =  a * pow(x, 3) + b * pow(x, 2) + c * x + d;
	}
	
	public static void main(String[] args)
	{
		Polynom3 p1 = new Polynom3(1.5, 4.0, 1.3, -8.0);
		System.out.println(p1.berechneAnDerStelleX(2));
		System.out.println(p1.toString());
		System.out.println(p1.leiteAb().toString());
	}
	
	public double berechneAnDerStelleX(double x)
	{
		double erg = 0d;
		
		erg = a * pow(x, 3) + b * pow(x, 2) + c * x + d;
		
		return erg;
	}
	
	public Polynom3 leiteAb() {
		Polynom3 polyAb = new Polynom3(0,a*3,b*2,c);
		return polyAb;
	}
	
	@Override
	public String toString() {
		if(a != 0) {
		String poly = a+"x^3 + "+b+"x^2 + "+c+"x + "+d;
		return poly;
		}
		String poly = b+"x^2 + "+c+"x + "+d;
		return poly;
	}

	public double pow(double basis, int exp)
	{
		double erg = 1;
		
		for(int i = 0; i < exp; i++)
		{
			erg *= basis;
		}
		
		return erg;
	}
}
