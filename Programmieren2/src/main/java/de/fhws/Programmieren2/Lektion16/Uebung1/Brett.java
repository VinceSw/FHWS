package de.fhws.Programmieren2.Lektion16.Uebung1;

public class Brett
{
  boolean[][] brett = new boolean[8][8];
  
  public Brett()
  {
    
  }
  
  public void markiereFeld(int x, int y)
  {
    brett[x-1][y-1] = true;
  }
  
  public boolean gibFeld(int x, int y)
  {
    return brett[x-1][y-1];
  }
  
  public Brett kombiniere(Brett kombiBrett)
  {
	  Brett newBrett = new Brett();
	  
	  for(int j = 0; j < this.brett.length; j++)
	  {
		  for(int i = 0; i < this.brett[j].length; i++)
		  {
			  if(this.brett[j][i] == true || kombiBrett.brett[j][i] == true)
			  {
				  newBrett.brett[j][i] = true;
			  }
			  else
			  {
				  newBrett.brett[j][i] = false;
			  }
		  }
	  }
	  
	  return newBrett;
  }
  
}
