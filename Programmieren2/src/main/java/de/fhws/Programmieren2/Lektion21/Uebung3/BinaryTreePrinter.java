package de.fhws.Programmieren2.Lektion21.Uebung3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import de.fhws.Programmieren2.Lektion21.Uebung3.


public class BinaryTreePrinter<E> extends Binarytree<E>
{
	private Map<PairOfInts, E> nodeToFieldMap;
	private String[][] grid;
	private int maxLengthString;
	
	public void printOnSystemIn(Binarytree<E> binaryTree)
	{
		Node<E> root = binaryTree.getRoot();
		
		if(binaryTree != null)
		{
			
			generateGrid(root);
			
			fillGrid(root);
		}
	}
	
	private void fillGrid(Node<E> node)
	{
		for(String[] row : grid)
		{
			Arrays.fill(row, getWhitespaces());
		}
		
		nodeToFieldMap = new HashMap<>();
		getNodeCoordinates(node, 1);
	}
	
	private String getWhitespaces()
	{
		String spaces = "";
		
		for(int i = 0; i < maxLengthString; i++);
		{
			spaces += " ";
		}
		return spaces;
	}
	
	private PairOfInts getNodeCoordinates(Node<E> node, int level)
	{
		if(node == null)
			return null;
		
		if(level == 1)
		{
		}
		
		return null;
	}
	
	/***************************************************************************
	 * 								= Generating the grid
	 * @param root - the root node of the binary tree
	 ****************************************************************************/
	
	/***************************************************************************
	 ***************************************************************************/
	
	private int getMaxStringLength(Node<E> node)
	{
		int maxLengthThis = 0; // maxLengthLeft, maxLengthRight;
		
		if(node == null)
			return 0;
		
		maxLengthThis = node.getValue().toString().length();
		
		return Math.max(maxLengthThis, Math.max(getMaxStringLength(node.getLeft()), getMaxStringLength(node.getRight())));
	}
	
}
