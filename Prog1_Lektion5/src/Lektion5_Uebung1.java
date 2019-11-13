
public class Lektion5_Uebung1
{

	public static void main(String[] args)
	{
		int k = 1;
		double quotientValue = 0.0d;
		double minRange = 1 * Math.pow(10, -5);
		
		System.out.println(minRange);
		
		do
		{
			quotientValue = 1.0d / Math.pow(k, 2);
			k++;
			System.out.println(6 * quotientValue);
			
		}while(quotientValue > minRange);
		
		

	}

}
