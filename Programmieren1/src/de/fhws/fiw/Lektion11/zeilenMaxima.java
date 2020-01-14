package de.fhws.fiw.Lektion11;

public class zeilenMaxima
{

	public static void main(String[] args)
	{
		double[][] testArray = {{1, 2, 3, 4, 5, 6}, {11, 35, 85, 44, 22}, {11, 22, 33, 44, 55, 66}, {7, 8, 9, 10, 11, 12}, {6, 5, 4, 3, 2, 1}};
		double[] result = bestimmeZeilenMaximum(testArray);
		
		for(int i = 0; i < result.length; i++)
		{
			System.out.println("Höchster Wert der " + (i + 1) + ". Zeile : " + result[i]);
		}
	}
	
	public static double[] bestimmeZeilenMaximum(double[][] zeilenMaxima)
	{
		double[] maxValOfColumn = new double[zeilenMaxima.length];
		double highestValue = 0d;
		
		for(int i = 0; i < zeilenMaxima.length; i++)
		{
			for(int j = 0; j < zeilenMaxima[i].length; j++)
			{
				if(highestValue < zeilenMaxima[i][j])
				{
					highestValue = zeilenMaxima[i][j];
				}
			}
			
			maxValOfColumn[i] = highestValue;
			highestValue = 0;
		}
		
		return maxValOfColumn; 
	}

}
