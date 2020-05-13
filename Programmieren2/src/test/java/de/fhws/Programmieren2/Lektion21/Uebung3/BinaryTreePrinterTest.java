package de.fhws.Programmieren2.Lektion21.Uebung3;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreePrinterTest
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
		Binarytree.Node<Person> p8 = new Binarytree.Node<Person>(new Person("BBBBBB", "BBBB"));
		
		bt.addNode(p7);
		bt.addNode(p4);
		bt.addNode(p3);
		bt.addNode(p2);
		bt.addNode(p5);
		bt.addNode(p1);
		bt.addNode(p6);
		bt.addNode(p8);
		
		BinaryTreePrinter<Person> binTreePrinter = new BinaryTreePrinter<>();
		binTreePrinter.printOnSystemIn(bt);
	}

	
	//@Test
	void test2()
	{
		Binarytree<Integer> tree = new Binarytree<>(); 
      
      /* 
      Constructed bunary tree is: 
            1 
          /  \ 
         2    3 
       /  \    \ 
      4   5     8  
               /  \ 
              6   7 
       */
      
       
       
      Binarytree.Node<Integer> i1 = new Binarytree.Node<Integer>(5);
      Binarytree.Node<Integer> i2 = new Binarytree.Node<Integer>(2); 
      Binarytree.Node<Integer> i3 = new Binarytree.Node<Integer>(1); 
      Binarytree.Node<Integer> i4 = new Binarytree.Node<Integer>(4);
      Binarytree.Node<Integer> i5 = new Binarytree.Node<Integer>(3);
      Binarytree.Node<Integer> i6 = new Binarytree.Node<Integer>(8); 
      Binarytree.Node<Integer> i7 = new Binarytree.Node<Integer>(6); 
      Binarytree.Node<Integer> i8 = new Binarytree.Node<Integer>(7);
      Binarytree.Node<Integer> i9 = new Binarytree.Node<Integer>(9);
      
      
      tree.addNode(i1);
      tree.addNode(i2);
      tree.addNode(i3);
      tree.addNode(i4);
      tree.addNode(i5);
      tree.addNode(i6);
      tree.addNode(i7);
      tree.addNode(i8);
      tree.addNode(i9);
 
      BinaryTreePrinter<Integer> binTreePrinter = new BinaryTreePrinter<>();
		binTreePrinter.printOnSystemIn(tree);
  } 
}
