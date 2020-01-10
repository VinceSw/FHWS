package de.fhws.fiw.Lektion12;

public class Lottoziehung
{

	public static void main(String[] args)
	{
		Lottozahl lottozahlen = generateLottozahlen();
		Lottozahl gezogen = null;
		int amountDrawn = 0;
		
		outputList(lottozahlen);
		
		while(amountDrawn < 6)
		{
			gezogen = drawLottozahlen(lottozahlen, gezogen);
			//deleteNodeFromList(start, randomNumber);
			amountDrawn++;
		}
		
		System.out.println();
		outputList(gezogen);

	}
	
	public static Lottozahl generateLottozahlen()
	{
		Lottozahl start = new Lottozahl(1);
		Lottozahl l; 
		
		
		for(int i = 2; i <= 49; i++)
		{
			l = new Lottozahl(i);
			Lottozahl temp = start;
			
			while(temp.next != null)
			{
				temp = temp.next;
			}
			
			temp.next = l;
		}
		
		return start;
	}

	public static Lottozahl drawLottozahlen(Lottozahl start, Lottozahl gezogen)
	{
		Lottozahl temp = start;
		Lottozahl tempGezogen = gezogen;
		
			int randomNumber = (int) (Math.random() * 49 + 1);
			
			while(temp != null)
			{
				if(temp.getLottozahl() == randomNumber)
				{
					Lottozahl l = new Lottozahl(randomNumber);
					
					if(gezogen != null)
					{
						while(tempGezogen.next != null)
						{
							tempGezogen = tempGezogen.next;
						}
						
						tempGezogen = sortedInsertLotto(tempGezogen, l);
						gezogen = tempGezogen;
					}
					else
					{
						tempGezogen = sortedInsertLotto(tempGezogen, l);
						gezogen = tempGezogen;
					}
					
					
					
					//deleteNodeFromList(start, randomNumber);
					break;
				}
				else
				{
					temp = temp.next;
				}
			}
			
		return gezogen;
	}
	
	public static Lottozahl sortedInsertLotto(Lottozahl gezogen, Lottozahl l)
	{	
		
		if(gezogen == null)
		{
			gezogen = new Lottozahl(l.getLottozahl());
		}
		else if(gezogen.next == null)
		{
			if(l.getLottozahl() < gezogen.getLottozahl())
			{
				l.next = gezogen;
				gezogen = l;
			}
			else
			{
				gezogen.next = l;
			}
		}
		else
		{
			Lottozahl temp = gezogen.next;
			Lottozahl oldTemp = gezogen;
			
			while(temp != null)
			{
				if(l.getLottozahl() < oldTemp.getLottozahl())
				{
					l.next = oldTemp;
					gezogen.next = l;
					break;
				}
				if(l.getLottozahl() < temp.getLottozahl())
				{
					l.next = temp;
					oldTemp.next = l;
					break;
				}
				else
				{
					if(temp.next == null)
					{
						temp.next = l;
						break;
					}
					else
					{
						oldTemp = temp;
						temp = temp.next;
					}
				}
			}
			
		}
		
		return gezogen;
	}
	
	public static void deleteNodeFromList(Lottozahl start, int randomNumber)
	{
		Lottozahl oldTemp = start;
		Lottozahl temp = start.next;
		
		while(temp != null)
		{
			if(oldTemp.getLottozahl() == randomNumber)
			{
				oldTemp = temp;
			}
			else if(temp.getLottozahl() == randomNumber)
			{
				oldTemp.next = temp.next;
				break;
			}
			else
			{
				oldTemp = temp;
				temp = temp.next;
			}
		}
	}
	
	
	public static void outputList(Lottozahl lottozahlen)
	{
		Lottozahl temp = lottozahlen;
		
		System.out.println("Lottozahlen:");
		while(temp != null)
		{
			System.out.print(temp.getLottozahl() + " ");
			temp = temp.next;
		}
	}
}
