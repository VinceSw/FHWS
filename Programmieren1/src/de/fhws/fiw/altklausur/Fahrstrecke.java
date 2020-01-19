package de.fhws.fiw.altklausur;

public class Fahrstrecke
{
	private Zielort start;
	
	public Fahrstrecke()
	{
		start = new Zielort();
	}
	
	public void einfuegen(String nameDest, float distInKM)
	{
		Zielort newDest = new Zielort(nameDest, distInKM);
		
		if(start.getNameDest().equals(""))
		{
			start = newDest;
		}
		else
		{
			Zielort temp = start;
			
			while(temp != null)
			{
				if(temp.getNext() == null)
				{
					temp.setNext(newDest);
					break;
				}
				else
				{
					temp = temp.getNext();
				}
			}
		}
	}
	
	public float gesamtStrecke()
	{
		Zielort temp = start;
		float totalDistance = 0;
		
		while(temp != null)
		{
			totalDistance += temp.getDistInKM();
			temp = temp.getNext();
		}
		
		return totalDistance;
	}
	
	@Override
	public String toString()
	{
		Zielort temp = start;
		String route = "";
		
		while(temp != null)
		{
			route += temp.toString() + "\n";
			temp = temp.getNext();
		}
		
		return route;
	}
}
