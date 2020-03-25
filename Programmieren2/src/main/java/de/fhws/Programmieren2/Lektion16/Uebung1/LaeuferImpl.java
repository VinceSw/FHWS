package de.fhws.Programmieren2.Lektion16.Uebung1;

public class LaeuferImpl extends AbstractFigur implements Laeufer
{
  public LaeuferImpl(int x, int y)
  {
    super(x, y);
  }

  public Brett gibErlaubteFelder()
  {
    Brett brett = new Brett();
    int differenzXY = 0;
    int differenzIJ = 0;
    int summeXY = 0;
    int summeIJ = 0;
    
    for(int j = 1; j <= brett.brett.length; j++)
    {
   	 for(int i = 1; i <= brett.brett[j-1].length; i++)
   	 {
   		 if(i == x && j == y)
   		 {
   			 brett.markiereFeld(i, j);
   		 }
   		 else
   		 {
   			 differenzXY = x - y;
      		 differenzIJ = i - j;
      		 summeXY = x + y;
      		 summeIJ = i + j;
      		 
   			 if((i != x  || j != y) && (differenzIJ == differenzXY || summeIJ == summeXY))
   			 {
   				 brett.markiereFeld(i, j);
   			 }
   		 }
   	 }
    }
    
    return brett;
  }
  
  public static void main(String[] args)
  {
    LaeuferImpl l = new LaeuferImpl(5, 3);
    Brett brett = l.gibErlaubteFelder();
    for (int j = 1; j <= 8; j++)
    {
      for (int i = 1; i <= 8; i++)
      {
        if (brett.gibFeld(i, j)) System.out.print("x ");
        else System.out.print("o ");
      }
      System.out.println();
    }
  }
}
