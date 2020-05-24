package de.fhws.Programmieren2.Lektion21.Uebung3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class BinaryTreePrinter<E> extends Binarytree<E>
{
	Binarytree<E> binaryTree;
//	private Map<PairOfInts, E> nodeToFieldMap;
	private int maxLengthString;
	
	public BinaryTreePrinter(Binarytree<E> binTree)
	{
		this.binaryTree = binTree;
	}
	
	public void printOnSystemIn(Binarytree<E> binaryTree)
	{
		Node<E> root = binaryTree.getRoot();
		
		if(binaryTree != null)
		{
			Grid<E> gridCls = new Grid<E>(binaryTree, maxLengthString);
			gridCls.generateGrid(binaryTree);
			
			fillGrid(root, gridCls);
		}
	}
	
	private void fillGrid(Node<E> root, Grid<E> gridCls)
	{
//		for(String[] row : grid)
//		{
//			Arrays.fill(row, getWhitespaces(root));
//		}
		
//		nodeToFieldMap = new HashMap<>();
		setNodeCoordinates(root, 1, 0, 0);
		fill(root, gridCls);
		System.out.println();
	}
	
	private void fill(Node<E> node, Grid<E> gridCls)
	{
		int gridHeigth = gridCls.grid.length;
		
		for(int i = 0; i < gridHeigth; i++)
		{
			int gridWidth = gridCls.grid[i].length;
			for(int j = 0; j < gridWidth; j++)
			{
				PairOfInts coordinates = new PairOfInts(j, i);
				Node<E> n = getNodeIfExists(node, coordinates);
				
				if(n != null)
				{
					gridCls.fillField(n.getValue().toString(), coordinates);
					
					if(n.hasLeftAndRight())
						printBothConnector(n, coordinates, gridCls);
					else if(n.hasLeft())
						printLeftConnector(n, coordinates, gridCls);
					else if(n.hasRight())
						printRightConnector(n, coordinates, gridCls);
				}
				else
				{
					gridCls.fillField(getWhitespaces(node), coordinates);
				}
			}
		}
	}
	
	private void printBothConnector(Node<E> node, PairOfInts coordinates, Grid<E> grid)
	{
		printLeftConnector(node, coordinates, grid);
		printRightConnector(node, coordinates, grid);
	}
	
	private void printLeftConnector(Node<E> node, PairOfInts coordinates, Grid<E> grid)
	{
		PairOfInts tempCoordinates = coordinates;
		tempCoordinates.y++;
		grid.fillField("|", tempCoordinates);
		tempCoordinates.y++;
		grid.fillField("|", tempCoordinates);
		
	}
	
	private void printRightConnector(Node<E> node, PairOfInts coordinates, Grid<E> grid)
	{
		PairOfInts tempCoordinates = coordinates;
		tempCoordinates.y++;
		grid.fillField("|", tempCoordinates);
		tempCoordinates.y++;
		grid.fillField("|", tempCoordinates);
	}
	
	private Node<E> getNodeIfExists(Node<E> root, PairOfInts coordinates)
	{
		for(Node<E> n: binaryTree.nodeList)
		{
			if(n.getCoordinatesInTree().equals(coordinates))
				return n;
		}
		return null;
	}
	
	private String getWhitespaces(Node<E> root)
	{
		String spaces = "";
		maxLengthString = getMaxStringLength(root);
		
		for(int i = 0; i < maxLengthString; i++);
		{
			spaces += " ";
		}
		return spaces;
	}
	
	private void setNodeCoordinates(Node<E> node, int level, int x, int y)
	{
		int heightOfTree = binaryTree.getHeightOfTree();
		int widthApart = heightOfTree + 2 - level;
		
		if(level == 1)
		{
			x = binaryTree.getMaxWidthOfTree(node, heightOfTree) / 2;
			node.setCoordinatesInTree(x, y);
		}
		
		if(node.hasLeft())
		{
			int newY = y + 4;
			int newX = x + widthApart;
			node.getLeft().setCoordinatesInTree(newX*(-1), newY);
			setNodeCoordinates(node.getLeft(), ++level, newX, newY);
		}
		if(node.hasRight())
		{
			int newY = y + 4;
			int newX = x + widthApart;
			node.getRight().setCoordinatesInTree(newX, newY);
			setNodeCoordinates(node.getRight(), ++level, newX, newY);
		}
	}
	
	private int getMaxStringLength(Node<E> node)
	{
		int maxLengthThis = 0; // maxLengthLeft, maxLengthRight;
		
		if(node == null)
			return 0;
		
		maxLengthThis = node.getValue().toString().length();
		
		return Math.max(maxLengthThis, Math.max(getMaxStringLength(node.getLeft()), getMaxStringLength(node.getRight())));
	}
	
}
