package de.fhws.Programmieren2.Lektion21.Uebung3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Binarytree<E>
{
	Node<E> root;
	ArrayList<Node<E>> nodeList = new ArrayList<>();

	public Node<E> getRoot()
	{
		return root;
	}
	
	public void addNode(Node<E> n)
	{
		Node<E> tempNode = root;
		do
		{
			if (root == null)
			{
				root = n;
			}
			else
			{
				int nCompToTemp = n.compareTo(tempNode);

				if (nCompToTemp < 0)
				{
					if (tempNode.getLeft() == null)
					{
						tempNode.addLeft(n);
						addToList(tempNode);
						break;
					}
					else
					{
						tempNode = tempNode.getLeft();
					}
				}
				else if (nCompToTemp > 0)
				{
					if (tempNode.getRight() == null)
					{
						tempNode.addRight(n);
						addToList(tempNode);
						break;
					}
					else
					{
						tempNode = tempNode.getRight();
					}
				}
				else
				{
					break;
				}
			}
		}
		while (tempNode != null);
	}

//	public void mapBinarytree(Node<E> node, int level)
//	{
//		if (node.getLeft() != null)
//			mapBinarytree(node.getLeft(), ++level);
//		if (node.getRight() != null)
//			mapBinarytree(node.getRight(), ++level);
//
//		addToList(node);
//		level--;
//	}

	public int getLevel(Node<E> root, E key, int level)
	{
		if (root == null)
			return 0;
		if (root.getValue() == key)
			return level;

		int result = getLevel(root.left, key, level + 1);
		if (result != 0)
			return result;
		result = getLevel(root.right, key, level + 1);
		return result;
	}

	private void addToList(Node<E> n)
	{
		if (!nodeList.contains(n))
		{
			nodeList.add(n);
		}
	}

	public int getHeightOfTree()
	{
		return traverseTree(root);
	}
	
	private int traverseTree(Node<E> node)
	{
		if(node == null)
			return 0;
		
		int leftDepth = traverseTree(node.getLeft());
		int rightDepth = traverseTree(node.getRight());
		
		if(leftDepth > rightDepth)
			return (++leftDepth);
		else
			return (++rightDepth);
	}
	

	public void printBinarytree()
	{
//		mapBinarytree(root, 1);
//		StringBuilder sb = new StringBuilder();
//
//		String tabs = getTabs(levelDepth.size());
//		for (Integer i : levelDepth.keySet())
//		{
//			// ----------------- Initializing---------------------------
//			ArrayList<Node<E>> collection = (ArrayList<Node<E>>) levelDepth.get(i);
//			int collSize = collection.size();
//			String treeConnectorUpperPart = "";
//			String treeConnectorUnderPart = "";
//			// ---------------------------------------------------------
//
//			// ----------------- Appending -----------------------------
//			for (int j = 0; j < collSize; j++)
//			{
//				if (j % 2 != 0)
//				{
//					sb.append("\t" + collection.get(j).getValue());
//				}
//				else
//				{
//					if (j == 0)
//						sb.append(tabs + collection.get(j).getValue());
//					else
//						sb.append("\t" + collection.get(j).getValue());
//				}
//
//				if (collection.get(j).hasLeftAndRight())
//				{
//					// treeConnectorUpperPart = buildUpperTreeConnector(j, collSize,
//					// treeConnectorUpperPart, "______|________",
//					// tabs);
//					// treeConnectorUnderPart = buildUnderTreeConnector(j, collSize,
//					// treeConnectorUnderPart, "| |",
//					// tabs);
//					treeConnectorUpperPart = tabs + "/\t\\\n";
//					tabs = getTabs(tabs.length() - 1);
//
//				}
//				else if (collection.get(j).hasLeft())
//				{
//					// treeConnectorUpperPart = buildUpperTreeConnector(j, collSize,
//					// treeConnectorUpperPart, "______|", tabs);
//					// treeConnectorUnderPart = buildUnderTreeConnector(j, collSize,
//					// treeConnectorUnderPart, "______|", tabs);
//					treeConnectorUpperPart = tabs + "/\n";
//					tabs = getTabs(tabs.length() - 1);
//
//				}
//				else if (collection.get(j).hasRight())
//				{
//					// treeConnectorUpperPart = buildUpperTreeConnector(j, collSize,
//					// treeConnectorUpperPart, "|__________", tabs);
//					// treeConnectorUnderPart = buildUnderTreeConnector(j, collSize,
//					// treeConnectorUnderPart, "\t |", tabs);
//					treeConnectorUpperPart = tabs + "\t\\\n";
//					tabs = getTabs(tabs.length() + 1);
//				}
//			}
//			sb.append("\n");
//			sb.append(treeConnectorUpperPart);
//			// sb.append(treeConnectorUnderPart);

			// ---------------------------------------------------------
		}

//		// ----------------- Printing --------------------------
//		PrintStream os = new PrintStream(System.out);
//		os.print(sb.toString());
//	}

	public int getMaxWidthOfTree(Node<E> root, int heightOfTree)
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

	public static class Node<T> implements Comparable<Node<T>>
	{
		private T value;
		private Node<T> left, right;
		private PairOfInts coordinatesInTree;

		public PairOfInts getCoordinatesInTree()
		{
			return coordinatesInTree;
		}

		public void setCoordinatesInTree(PairOfInts coordinatesInTree)
		{
			this.coordinatesInTree = coordinatesInTree;
		}

		public void setCoordinatesInTree(int x, int y)
		{
			this.coordinatesInTree = new PairOfInts(x, y);
		}
		
		public Node(T obj)
		{
			this.value = obj;
		}

		public Node<T> getLeft()
		{
			return this.left;
		}

		public Node<T> getRight()
		{
			return this.right;
		}

		public T getValue()
		{
			return value;
		}

		public void addLeft(Node<T> n)
		{
			this.left = n;
		}

		public void addRight(Node<T> n)
		{
			this.right = n;
		}

		public boolean hasLeft()
		{
			return this.left != null ? true : false;
		}

		public boolean hasRight()
		{
			return this.right != null ? true : false;
		}

		public boolean hasLeftAndRight()
		{
			return (this.left != null) && (this.right != null) ? true : false;
		}

		@Override
		public int compareTo(Node<T> n)
		{
			String thisToString = this.getValue().toString();
			String nToString = n.getValue().toString();

			if (thisToString.compareTo(nToString) < 0)
			{
				return -1;
			}
			else if (thisToString.compareTo(nToString) == 0)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
	}
}