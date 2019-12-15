package de.fhws.fiw.Lektion9;

import de.fhws.fiw.Lektion10.Studenten;
import java.util.ArrayList;

public class Raum
{
	private String roomID;
	private int maxAmountStudents;
	private boolean isBooked;
	ArrayList<Studenten> studenten;

	public String getRoomID()
	{
		return this.roomID;
	}

	public void setRoomID(String roomID)
	{
		this.roomID = roomID.trim();
	}

	public int getMaxAmountStundents()
	{
		return this.maxAmountStudents;
	}

	public void setMaxAmountStudents(int maxAmountStudents)
	{
		this.maxAmountStudents = maxAmountStudents;
	}

	public boolean getIsBooked()
	{
		return isBooked;
	}

	public void setIsBooked(boolean isBooked)
	{
		this.isBooked = isBooked;
	}

	public Raum(String roomID, int maxAmountStudents)
	{
		this(roomID, maxAmountStudents, false);
	}

	public Raum(String roomID, int maxAmountStudents, boolean isBooked)
	{
		this.roomID = roomID;
		this.maxAmountStudents = maxAmountStudents;
		this.isBooked = isBooked;
	}

	/**************************************************************************************************/
	/********************************** Lektion 10 *****************************/
	/**************************************************************************************************/

	public ArrayList<Studenten> betreteRaum(String cardId, String vorname, String nachname, int matrNr)
	{
		if(studenten == null)
		{
			studenten = new ArrayList<Studenten>();
		}

		if(studenten.size() < maxAmountStudents)
		{
			studenten.add(new Studenten(cardId, vorname, nachname, matrNr));
			System.out.println("\nStudent " + vorname + " " + nachname +
					" hat den Raum " + roomID + " betreten.\n");
		}
		else
		{
			System.out.println("Der Raum hat die maximale Anzahl an Teilnehmer erreicht!");
		}

		return studenten;
	}

	public ArrayList<Studenten> verlasseRaum(String cardId)
	{
		for(int i = 0; i < studenten.size(); i++)
		{
			if(studenten.get(i).getCardId().equals(cardId))
			{
				System.out.println("\nStudent " + studenten.get(i).getVorname() + " " + studenten.get(i).getNachname() +
						" hat den Raum " + roomID + " verlassen.\n");
				studenten.remove(i);
			}
		}

		return studenten;
	}

	public int getAmountStudentsInRoom()
	{
		if(studenten == null )
		{
			return 0;
		}
		else
		{
			return studenten.size();
		}
	}

	public void displayStudentsInRoom()
	{
		if(studenten == null)
		{
			System.out.println("Keine Studenten in Raum " + getRoomID() + " vorhanden.");
		}
		else
		{
			int amountBlanks;

			System.out.println("\nRaum " + roomID + " (" + getAmountStudentsInRoom() + "):\n");
			System.out.print("cardID");
			amountBlanks = getSizeLongestElement(studenten, "vorname") + 5;
			System.out.printf("%" + amountBlanks + "s", "Vorname");
			amountBlanks = getSizeLongestElement(studenten, "nachname") + 5;
			System.out.printf("%" + amountBlanks + "s", "Nachname");
			amountBlanks = getSizeLongestElement(studenten, "matNr") + 5;
			System.out.printf("%" + amountBlanks + "s", "MatNr");
			System.out.println("\n----------------------------------------------------");

			for(int i = 0; i < studenten.size(); i++)
			{
				System.out.print(studenten.get(i).getCardId());
				amountBlanks = getSizeLongestElement(studenten, "vorname") + 5;
				System.out.printf("%" + amountBlanks + "s", studenten.get(i).getVorname());
				amountBlanks = getSizeLongestElement(studenten, "nachname") + 5;
				System.out.printf("%" + amountBlanks + "s", studenten.get(i).getNachname());
				amountBlanks = getSizeLongestElement(studenten, "matNr") + 5;
				System.out.printf("%" + amountBlanks + "s", studenten.get(i).getMatrNr());
				System.out.println();
			}
			System.out.println("\n");
		}
	}
	

	public static int getSizeLongestElement(ArrayList<Studenten> studenten, String element)
	{

		int longestElement = 0;
		int currentSize;
		for(int i = 0; i < studenten.size(); i++)
		{
			if(element.equals("cardId"))
			{
				return 7;
			}
			else if(element.equals("vorname"))
			{
				currentSize = studenten.get(i).getVorname().length();
			}
			else if(element.equals("nachname"))
			{
				currentSize = studenten.get(i).getNachname().length();
			}
			else if(element.equals("matNr"))
			{
				return 7;
			}
			else
			{
				break;
			}

			if(longestElement < currentSize)
			{
				longestElement = currentSize;
			}
		}

		return longestElement;
	}
}