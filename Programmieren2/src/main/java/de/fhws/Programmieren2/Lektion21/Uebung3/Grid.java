package de.fhws.Programmieren2.Lektion21.Uebung3;

import de.fhws.Programmieren2.Lektion21.Uebung3.Binarytree.Node;

public class Grid<E>
{
	private Binarytree<E> binaryTree;
	String[][] grid;
	private PairOfInts gridDimension;
	private int maxLengthString;
	
	public Grid(Binarytree<E> binaryTree, int maxLengthString)
	{
		this.binaryTree = binaryTree;
		this.maxLengthString = maxLengthString;
	}
	
	public void generateGrid(Binarytree<E> binaryTree)
	{
		getGridDimension(binaryTree.getRoot());
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
		int heightOfTree = binaryTree.getHeightOfTree();
		int y = heightOfTree;
		int x = getWidthOfGrid(heightOfTree);
		gridDimension = new PairOfInts(x, y);
		
		System.out.println("x: " + x +"\ny: " + y + "\ngridDim: [" + gridDimension.getX() + "," + gridDimension.getY() +"]" );
		System.out.println("Max length: " + maxLengthString);
	}
	
	private int getWidthOfGrid(int heightOfTree)
	{
		int result = 0;
		for(int i = heightOfTree + 1; i > 1; i--)
		{
			result += i;
		}
		
		return result;
	}
	
	public void fillField(String fillString, PairOfInts coordinates)
	{
		this.grid[coordinates.getY()][coordinates.getX()] = fillString;
	}
	
}
