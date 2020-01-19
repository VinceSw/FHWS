package de.fhws.fiw.Lektion12;

public class Liste
{
	private Personenknoten start;
	
	public Personenknoten getStart()
	{
		return this.start;
	}
	
	public void sortAdd(Personenknoten newElement)
	{
		
		do
		{
			if(start == null)
			{
				start = new Personenknoten(newElement.getAge(), newElement.getLastname());
			}
			else if(newElement.getAge() < start.next.getAge())
			{
				start.getPrevious().setNext(newElement);;
				newElement.setNext(newElement);
				start.getNext().setPrevious(newElement);
			}
			else
			{
				start = start.getNext();
			}
			
		}while(start.next != null);
	}
	
	public void sortAdd(int age, String lastname)
	{
		Personenknoten p = new Personenknoten(age, lastname);
		do
		{
			if(start == null)
			{
				start = p;
				break;
			}
			else if(start.next != null)
			{
				if(age < start.next.getAge())
				{
					
					p.setPrevious(start);
					p.setNext(start.getNext());
					start.getNext().setPrevious(p);
					start.setNext(p);
					
					break;
				}
				else
				{
					start = start.getNext();
				}
			}
			else
			{
				if(age < start.getAge())
				{
					p.setNext(start);
					start = p;
					break;
				}
				else
				{
					p.setPrevious(start);
					start.setNext(p);
					break;
				}
			}
			
		}while(start != null);
	}
	
	public Personenknoten search(String lastname)
	{
		Personenknoten p = start;
		
		do
		{
			if(p.getLastname().toUpperCase().equals(lastname.toUpperCase()))
			{
				break;
			}
			
			p = p.getNext();
			
			if(p == null)
			{
				p = null;
			}
			
		}while(p != null);
		
		return p;
	}
	
	public void displayList()
	{
		Personenknoten p = start; 
		
		while(p != null)
		{
			System.out.println("Lastname: " + p.getLastname() + "\t age: " + p.getAge());
			
			p = p.getNext();
			
			if(p.getNext() == null)
			{
				System.out.println("Lastname: " + p.getLastname() + "\t age: " + p.getAge());
				break;
			}
		}
		
		System.out.println("--------------------------------------------------------");
		
		while(p != null)
		{
			System.out.println("Lastname: " + p.getLastname() + "\t age: " + p.getAge());
			
			p = p.getPrevious();
			
			if(p.getPrevious() == null)
			{
				System.out.println("Lastname: " + p.getLastname() + "\t age: " + p.getAge());
				break;
			}
		}
	}	
}
