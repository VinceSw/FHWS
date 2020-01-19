package de.fhws.fiw.Lektion12;

public class TestBaum
{

	public static void main(String[] args)
	{
		Baum tree = new Baum();
		
		Knoten k1 = new Knoten("Clown College", "A place that offers a more serious education than Trump University.");
		tree.insert(k1);
		Knoten k2 = new Knoten("hallway hobo", "in college, when students lay around in the hallways before class.");
		tree.insert(k2);
		
		Knoten k3 = new Knoten("Shit Show University (SSU)", "Any time a night of partying at college gets out of control.");
		tree.insert(k3);
		
		Knoten k4 = new Knoten("algebra", "a cruel pointless subject schools teach you to waste your childhood.");
		tree.insert(k4);
		
		Knoten k5 = new Knoten("Yuzer", "Cyber user");
		tree.insert(k5);
		
		tree.print();
		
		System.out.println();
		System.out.printf("%-40s", "Wort: hallway hobo");
		System.out.println();
		System.out.println("Bedeutung: " + tree.search("hallway hobo"));
	
		System.out.println();
		System.out.printf("%-40s", "Wort: Clown College");
		System.out.println();
		System.out.println("Bedeutung: " + tree.search("Clown College"));
		
		System.out.println();
		System.out.printf("%-40s", "Wort: Yuzer");
		System.out.println();
		System.out.println("Bedeutung: " + tree.search("Yuzer"));
		
		System.out.println();
		System.out.printf("%-40s", "Wort: Bla");
		System.out.println();
		System.out.println("Bedeutung: " + tree.search("Bla"));
		
		System.out.println();
		System.out.printf("%-40s", "Wort: algebra");
		System.out.println();
		System.out.println("Bedeutung: " + tree.search("algebra"));
		
		tree.delete(k3);
		tree.delete(k4);
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------");
		tree.print();
	}

}
