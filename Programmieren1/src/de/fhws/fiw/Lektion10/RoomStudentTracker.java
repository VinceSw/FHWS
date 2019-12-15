package de.fhws.fiw.Lektion10;

import java.util.ArrayList;
import de.fhws.fiw.Lektion9.Raum;
import java.util.Scanner;
import de.fhws.fiw.Lektion9.RaumCheck;

public class RoomStudentTracker
{

	public static void main(String[] args)
	{
		getMenu();
	}
	
	public static void getMenu()
	{
		Scanner inputScan = new Scanner(System.in);
		boolean ongoing = true;
		ArrayList<Raum> rooms = new ArrayList<Raum>();
		rooms.add(new Raum("I.2.1", 5));
		rooms.add(new Raum("I.2.15", 10));
		rooms.add(new Raum("H.1.1", 200));
		rooms.add(new Raum("H.1.7", 70));
		
		while(ongoing)
		{
			System.out.println("Was wollen Sie tun: ");
			System.out.print("B = Raum betreten\nV = Raum verlassen\nS = Studenten im Raum anzeigen\nD = Raumübersicht\n:");
			char choice = inputScan.nextLine().toUpperCase().charAt(0);
			
			if(choice == 'B')
			{
				raumBetreten(inputScan, rooms);
			}
			else if(choice == 'V')
			{
				raumVerlassen(inputScan, rooms);
			}
			else if(choice == 'S')
			{
				displayStudentsInRoom(inputScan, rooms);
			}
			else if(choice == 'D')
			{
				 displayRoomOverview(rooms);
			}
			else
			{
				System.out.println("Eingabe ungültig");
			}
			
			System.out.print("\nWeiter simulieren? (J/N): ");
			choice = inputScan.nextLine().toUpperCase().charAt(0);
			ongoing = choice == 'J';
			
		}
		
		inputScan.close();
	}
	public static void raumBetreten(Scanner inputScan, ArrayList<Raum> rooms)
	{
		System.out.print("Welcher Raum wurde betreten: ");
		int index = RaumCheck.getIndex(rooms, inputScan.nextLine().toUpperCase());
		if(index >= 0)
		{
			System.out.print("Bitte geben Sie die cardId ein: ");
			String cardId = inputScan.nextLine();
			System.out.print("\nBitte geben Sie den Vornamen ein: ");
			String vorname = inputScan.nextLine();
			System.out.print("\nBitte geben Sie den Nachnamen ein: ");
			String nachname = inputScan.nextLine();
			System.out.print("\nBitte geben Sie die Matrikelnummer ein: ");
			int matrNr = Integer.valueOf(inputScan.nextLine());
			
			rooms.get(index).betreteRaum(cardId, vorname, nachname, matrNr);
		}
	}
	
	public static void raumVerlassen(Scanner inputScan, ArrayList<Raum> rooms)
	{
		System.out.print("Welcher Raum wurde verlassen: ");
		int index = RaumCheck.getIndex(rooms, inputScan.nextLine().toUpperCase());
		if(index >= 0)
		{
			System.out.print("Bitte geben Sie die cardID ein: ");
			String cardId = inputScan.nextLine();
			
			rooms.get(index).verlasseRaum(cardId);
		}
	}
	
	public static void displayRoomOverview(ArrayList<Raum> rooms)
	{
		System.out.println("\nRoomID\t\tMax Students\tStudents in Room");
		System.out.println("---------------------------------------------------");
		for(int i = 0; i < rooms.size(); i++)
		{
			System.out.println(rooms.get(i).getRoomID() + "\t\t" + rooms.get(i).getMaxAmountStundents() + "\t\t" 
									+ rooms.get(i).getAmountStudentsInRoom());
		}
	}

	public static void displayStudentsInRoom(Scanner inputScan, ArrayList<Raum> rooms)
	{
		System.out.print("Welcher Raum soll angezeigt werden: ");
		int index = RaumCheck.getIndex(rooms, inputScan.nextLine().toUpperCase());
		if(index >= 0)
		{
			rooms.get(index).displayStudentsInRoom();
		}
	}
}
