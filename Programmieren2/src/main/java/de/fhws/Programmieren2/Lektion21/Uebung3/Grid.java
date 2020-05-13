package de.fhws.Programmieren2.Lektion21.Uebung3;

import de.fhws.Programmieren2.Lektion21.Uebung3.Binarytree.Node;

public class Grid<E>
{
	Node<E> root;
	String[][] grid;
	private PairOfInts gridDimension, coordinates;
	private int maxLengthString;
	
	public Grid(Node<E> root, int maxLengthString)
	{
		this.root = root;
		this.maxLengthString = maxLengthString;
	}
	
	public void generateGrid(Node<E> root)
	{
		getGridDimension(root);
		//multiplying length to leave a little space in the grid for connectors
		int x = gridDimension.getX();
		int y = gridDimension.getY() * 4;
		
		if(x > y)
		{
			x = x % 2 == 0 ? x + 1 : x;
			grid = new String[x][x];
		}
		else
		{
			y = y % 2 == 0 ? y + 1 : y;
			grid = new String[y][y];
		}
	}
	
	private void getGridDimension(Node<E> root)
	{
		int y = getHeightOfTree(root);
		int x = getMaxWidthOfTree(root, y);
		x += Math.pow(2, x);
		gridDimension = new PairOfInts(x, y);
		
		System.out.println("x: " + x +"\ny: " + y + "\ngridDim: [" + gridDimension.getX() + "," + gridDimension.getY() +"]" );
		System.out.println("Max length: " + maxLengthString);
	}
	
	private int getHeightOfTree(Node<E> root)
	{
		Node<E> node = root;
		if(node == null)
			return 0;
		
		int leftDepth = getHeightOfTree(node.getLeft());
		int rightDepth = getHeightOfTree(node.getRight());
		
		if(leftDepth > rightDepth)
			return (++leftDepth);
		else
			return (++rightDepth);
	}
	
	private int getAmountOfNodes(Node<E> node)
	{
		int amountLeft = 0, amountRight = 0;
		
		if(node == null)
			return 0;
		
		amountLeft += getAmountOfNodes(node.getLeft());
		amountRight += getAmountOfNodes(node.getRight());
		
		return 1;
		
		
	}
	
	private int getMaxWidthOfTree(Node<E> root, int heightOfTree)
	{
		Node<E> node = root;
		int maxWidth = 0, newWidth = 0;
		int h = heightOfTree;

		for(int i = 1; i <= h; i++)
		{
			newWidth = getWidthOfLevel(node, i);
			if(newWidth > maxWidth)
				maxWidth = newWidth;
		}
		
		return maxWidth;
	}
	
	private int getWidthOfLevel(Node<E> node, int level)
	{
		if(node == null)
			return 0;
		
		if(level == 1)
			return 1;
		else if(level > 1)
			return getWidthOfLevel(node.getLeft(), level-1) + getWidthOfLevel(node.getRight(), level-1);
		
		return 0;
	}
}
