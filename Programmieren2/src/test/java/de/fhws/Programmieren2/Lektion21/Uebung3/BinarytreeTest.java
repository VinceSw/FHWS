package de.fhws.Programmieren2.Lektion21.Uebung3;


import org.junit.jupiter.api.Test;

class BinarytreeTest
{

	@Test
	void test()
	{
		Binarytree<Person> bt = new Binarytree<>();
		Binarytree.Node<Person> p1 = new Binarytree.Node<Person>(new Person("Swigler", "Vincent"));
		Binarytree.Node<Person> p2 = new Binarytree.Node<Person>(new Person("Gilles", "Nadine"));
		Binarytree.Node<Person> p3 = new Binarytree.Node<Person>(new Person("Cool", "Dietmar"));
		Binarytree.Node<Person> p4 = new Binarytree.Node<Person>(new Person("Aaronson", "Jens"));
		Binarytree.Node<Person> p5 = new Binarytree.Node<Person>(new Person("Zylla", "Mathilde"));
		Binarytree.Node<Person> p6 = new Binarytree.Node<Person>(new Person("Wang", "Garret"));
		Binarytree.Node<Person> p7 = new Binarytree.Node<Person>(new Person("Altmaier", "Anton"));
		
		
		bt.addNode(p7);
		bt.addNode(p4);
		bt.addNode(p3);
		bt.addNode(p2);
		bt.addNode(p5);
		bt.addNode(p1);
		bt.addNode(p6);
		
		bt.printBinarytree();
	}
	
	@Test
	void test2()
	{
		Binarytree<Integer> bt = new Binarytree<>();
		Binarytree.Node<Integer> i1 = new Binarytree.Node<Integer>(1);
		Binarytree.Node<Integer> i2 = new Binarytree.Node<Integer>(2);
		Binarytree.Node<Integer> i3 = new Binarytree.Node<Integer>(5);
		Binarytree.Node<Integer> i4 = new Binarytree.Node<Integer>(13);
		Binarytree.Node<Integer> i5 = new Binarytree.Node<Integer>(3);
		Binarytree.Node<Integer> i6 = new Binarytree.Node<Integer>(9);
		Binarytree.Node<Integer> i7 = new Binarytree.Node<Integer>(2082019);
		
		
		bt.addNode(i1);
		bt.addNode(i4);
		bt.addNode(i3);
		bt.addNode(i2);
		bt.addNode(i5);
		bt.addNode(i7);
		bt.addNode(i6);
		
		bt.printBinarytree();
	}
}
