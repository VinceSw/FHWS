package de.fhws.fiw.Lektion9;

import java.util.ArrayList;
import java.util.Scanner;

public class RaumCheck
{

	public static void main(String[] args)
	{
		executeMenu();
	}

	public static void executeMenu()
	{
		Scanner inputScan = new Scanner(System.in);
		ArrayList<Raum> rooms = new ArrayList<Raum>();
		boolean anotherOperation = true;

		if(rooms.size() == 0)
		{
			addRooms(inputScan, rooms);
		}

		while(anotherOperation)
		{
			System.out.println("Welche Operation soll durchgeführt werden?");
			System.out.print("A = Anlegen \nB = Raum buchen/stornieren \nP = Belegungsplan anzeigen "
					+ "\nD = Raum löschen \nQ = Beenden \n: ");

			String chosenMenu = inputScan.nextLine().toUpperCase();

			if(chosenMenu.equals("A"))
			{
				addRooms(inputScan, rooms);
			}
			else if(chosenMenu.equals("B"))
			{
				changeIsRoomBooked(inputScan, rooms);
			}
			else if(chosenMenu.equals("P"))
			{
				checkIsRoomBooked(rooms);
			}
			else if(chosenMenu.equals("D"))
			{
				deleteRoom(inputScan, rooms);
			}
			else if(chosenMenu.equals("Q"))
			{
				// Quit application
				break;
			}
			else
			{
				System.out.println("\nIhre Eingabe war ungültig!");
			}
			// anotherOperation = !inputScan.nextLine().toUpperCase().equals("EXIT") ? true
			// : false;

		}

	}

	public static ArrayList<Raum> addRooms(Scanner inputScan, ArrayList<Raum> rooms)
	{
		boolean anotherRoom = true;
		String name;
		int maxStudents;
		boolean alreadyExisting;

		while(anotherRoom)
		{
			alreadyExisting = false;
			System.out.print("Bitte geben Sie den Namen des Raums an: ");
			name = inputScan.nextLine().toUpperCase();

			for(int i = 0; i < rooms.size(); i++)
			{
				if(rooms.get(i).getRoomID().equals(name))
					alreadyExisting = true;
			}

			if(!alreadyExisting)
			{
				System.out.print("Bitte geben Sie die Anzahl der max. Teilnehmerzahl an: ");
				maxStudents = Integer.valueOf(inputScan.nextLine());
				rooms.add(new Raum(name, maxStudents));
			}
			else
			{
				System.out.println("\nDer Raum existiert bereits!");
			}

			System.out.print("Wollen Sie einen weiteren Raum anlegen? (J/N): ");
			anotherRoom = inputScan.nextLine().toUpperCase().equals("J") ? true : false;
		}

		return rooms;

	}

	public static ArrayList<Raum> addRooms(Scanner inputScan, ArrayList<Raum> rooms, String newRoomID)
	{
		String name = newRoomID;
		int maxStudents;

		System.out.print("Bitte geben Sie die Anzahl der max. Teilnehmerzahl an: ");
		maxStudents = Integer.valueOf(inputScan.nextLine());
		rooms.add(new Raum(name, maxStudents, true));

		return rooms;
	}

	public static void checkIsRoomBooked(ArrayList<Raum> rooms)
	{
		String roomID;
		String belegt;
		int amountBlanks;
		
		System.out.println("\nRaumbelegung:");
		for(int i = 0; i < rooms.size(); i++)
		{
			roomID = rooms.get(i).getRoomID();
			if(rooms.get(i).getIsBooked())
			{
				belegt = "belegt";
			}
			else 
			{
				belegt = "frei";
			}
			
			amountBlanks = getSizeLongestElement(rooms, "name") - roomID.length() + 1;
			System.out.print("Raum " + roomID);
			System.out.printf("%" +  amountBlanks + "s", "");
			System.out.print("(" + rooms.get(i).getMaxAmountStundents() + ")");
			amountBlanks = getSizeLongestElement(rooms, "maxStudents") - String.valueOf(rooms.get(i).getMaxAmountStundents()).length()+1;
			System.out.printf("%" +  amountBlanks + "s", "");
			System.out.println(": " + belegt);
		}
		
	}

	public static void changeIsRoomBooked(Scanner inputScan, ArrayList<Raum> rooms)
	{
		boolean anotherRoom = true;
		boolean alreadyExists;
		System.out.print("Welchen Raum wollen Sie buchen?: ");
		String roomID; 

		while(anotherRoom)
		{
			System.out.print("Welchen Raum wollen Sie buchen?: ");
			roomID = inputScan.nextLine().toUpperCase();
			alreadyExists = alreadyExists(rooms, roomID);

			if(alreadyExists)
			{
				if(rooms.get(getIndex(rooms, roomID)).getIsBooked())
				{
					System.out.println("Der Raum " + roomID + " ist bereits gebucht!");
					System.out.print("Soll der Raum storniert werden? (J/N): ");
					if(inputScan.nextLine().toUpperCase().equals("J"))
					{
						rooms.get(getIndex(rooms, roomID)).setIsBooked(false);
						break;
					}

				}
				else
				{
					System.out.println("Der Raum " + roomID + " ist noch frei!");
					System.out.print("Soll der Raum gebucht werden? (J/N): ");
					if(inputScan.nextLine().toUpperCase().equals("J"))
					{
						rooms.get(getIndex(rooms, roomID)).setIsBooked(true);
						break;
					}
				}
			}
			else
			{
				System.out.println("Der Raum " + roomID + " existiert nicht!");
				System.out.print("Wollen Sie diesen Raum anlegen? (J/N): ");
				if(inputScan.nextLine().toUpperCase().equals("J"))
				{
					addRooms(inputScan, rooms, roomID);
				}
			}

			System.out.print("Wollen Sie einen weiteren Raum buchen? (J/N): ");
			anotherRoom = inputScan.nextLine().toUpperCase().equals("J") ? true : false;
		}
	}

	public static ArrayList<Raum> deleteRoom(Scanner inputScan, ArrayList<Raum> rooms)
	{
		boolean exists = true;
		String roomID;

		while(exists)
		{
			System.out.print("Welchen Raum möchten Sie löschen?: ");
			 roomID = inputScan.nextLine().toUpperCase();
			 
			if(alreadyExists(rooms, roomID))
			{
					rooms.remove(getIndex(rooms, roomID));
					exists = false;
					System.out.println("Raum " + roomID + " wurde erfolgreich gelöscht");
			}
			else
			{
				System.out.println("Der Raum " + roomID + " existiert nicht.");
				System.out.print("Wollen Sie einen anderen Raum löschen? (J/N): ");
				exists = inputScan.nextLine().toUpperCase().equals("J") ? true : false;
			}
		}

		return rooms;
	}

	public static boolean alreadyExists(ArrayList<Raum> rooms, String roomID)
	{
		boolean alreadyExisting = false;

		for(int i = 0; i < rooms.size(); i++)
		{
			if(rooms.get(i).getRoomID().equals(roomID))
				alreadyExisting = true;
		}

		return alreadyExisting;
	}

	public static int getIndex(ArrayList<Raum> rooms, String roomID)
	{
		int index = -1;

		for(int i = 0; i < rooms.size(); i++)
		{
			if(rooms.get(i).getRoomID().equals(roomID))
			{
				index = i;
				break;
			}
		}

		return index;
	}

	public static int getSizeLongestElement(ArrayList<Raum> rooms, String element)
	{
		int longestElement = 0;
		int currentSize;
		for(int i = 0; i < rooms.size(); i++)
		{
			if(element.equals("name"))
			{
				currentSize = rooms.get(i).getRoomID().length();
			}
			else if(element.equals("maxStudents"))
			{
				currentSize = String.valueOf(rooms.get(i).getMaxAmountStundents()).length();
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