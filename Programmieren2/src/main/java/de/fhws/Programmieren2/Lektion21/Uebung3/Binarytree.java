package de.fhws.Programmieren2.Lektion21.Uebung3;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Binarytree<E>
{
	Node<E> start;
	Map<Integer, Collection<Node<E>>> levelDepth = new HashMap<>();

	public Node<E> getRoot()
	{
		return start;
	}
	
	public void addNode(Node<E> n)
	{
		Node<E> tempNode = start;
		do
		{
			if (start == null)
			{
				start = n;
			}
			else
			{
				int nCompToTemp = n.compareTo(tempNode);

				if (nCompToTemp < 0)
				{
					if (tempNode.getLeft() == null)
					{
						tempNode.addLeft(n);
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

	public void mapBinarytree(Node<E> node, int level)
	{
		if (node.getLeft() != null)
			mapBinarytree(node.getLeft(), ++level);
		if (node.getRight() != null)
			mapBinarytree(node.getRight(), ++level);

		addToLevel(getLevel(start, node.getValue(), 1), node);
		level--;
	}

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

	private void addToLevel(int level, Node<E> n)
	{
		Integer levelObj = Integer.valueOf(level);
		ArrayList<Node<E>> nodeCollection;
		if (levelDepth.containsKey(levelObj))
		{
			nodeCollection = (ArrayList<Node<E>>) levelDepth.get(levelObj);
			nodeCollection.add(n);
			levelDepth.put(levelObj, nodeCollection);
		}
		else
		{
			nodeCollection = new ArrayList<Node<E>>();
			nodeCollection.add(n);
			levelDepth.put(levelObj, nodeCollection);
		}
	}

	public void printFromLeftToRight(Node<E> node, int level)
	{
		if(node == null)
			return;
		
		if(level == 1)
			System.out.println(node.getValue() + " ");
		else if(level > 1)
		{
			printFromLeftToRight(node.getLeft(), level--);
			printFromLeftToRight(node.getRight(), level--);
		}
	}

	private int getMaxWidthOfMap()
	{
		int oldSize = 0, newSize = 0;

		for (Integer i : levelDepth.keySet())
		{
			newSize = levelDepth.get(i).size();
			if (oldSize < newSize)
				oldSize = newSize;
		}

		return oldSize;
	}

	public void printBinarytree()
	{
		mapBinarytree(start, 1);
		StringBuilder sb = new StringBuilder();

		String tabs = getTabs(levelDepth.size());
		for (Integer i : levelDepth.keySet())
		{
			// ----------------- Initializing---------------------------
			ArrayList<Node<E>> collection = (ArrayList<Node<E>>) levelDepth.get(i);
			int collSize = collection.size();
			String treeConnectorUpperPart = "";
			String treeConnectorUnderPart = "";
			// ---------------------------------------------------------

			// ----------------- Appending -----------------------------
			for (int j = 0; j < collSize; j++)
			{
				if (j % 2 != 0)
				{
					sb.append("\t" + collection.get(j).getValue());
				}
				else
				{
					if (j == 0)
						sb.append(tabs + collection.get(j).getValue());
					else
						sb.append("\t" + collection.get(j).getValue());
				}

				if (collection.get(j).hasLeftAndRight())
				{
					// treeConnectorUpperPart = buildUpperTreeConnector(j, collSize,
					// treeConnectorUpperPart, "______|________",
					// tabs);
					// treeConnectorUnderPart = buildUnderTreeConnector(j, collSize,
					// treeConnectorUnderPart, "| |",
					// tabs);
					treeConnectorUpperPart = tabs + "/\t\\\n";
					tabs = getTabs(tabs.length() - 1);

				}
				else if (collection.get(j).hasLeft())
				{
					// treeConnectorUpperPart = buildUpperTreeConnector(j, collSize,
					// treeConnectorUpperPart, "______|", tabs);
					// treeConnectorUnderPart = buildUnderTreeConnector(j, collSize,
					// treeConnectorUnderPart, "______|", tabs);
					treeConnectorUpperPart = tabs + "/\n";
					tabs = getTabs(tabs.length() - 1);

				}
				else if (collection.get(j).hasRight())
				{
					// treeConnectorUpperPart = buildUpperTreeConnector(j, collSize,
					// treeConnectorUpperPart, "|__________", tabs);
					// treeConnectorUnderPart = buildUnderTreeConnector(j, collSize,
					// treeConnectorUnderPart, "\t |", tabs);
					treeConnectorUpperPart = tabs + "\t\\\n";
					tabs = getTabs(tabs.length() + 1);
				}
			}
			sb.append("\n");
			sb.append(treeConnectorUpperPart);
			// sb.append(treeConnectorUnderPart);

			// ---------------------------------------------------------
		}

		// ----------------- Printing --------------------------
		PrintStream os = new PrintStream(System.out);
		os.print(sb.toString());
	}

	String buildUpperTreeConnector(int j, int collSize, String existingDesign,
			String upperDesign, String tabs)
	{
		String upperPart = "";

		if (j == 0)
		{
			if (j < collSize - 1)
			{
				upperPart = tabs + upperDesign;
			}
			else
			{
				upperPart = tabs + upperDesign;
			}
		}
		else
		{
			if (j < collSize - 1)
			{
				upperPart += tabs + upperDesign;
			}
			else
			{
				upperPart += "\t" + upperDesign;
			}
		}

		existingDesign += upperPart;
		return existingDesign;
	}

	String buildUnderTreeConnector(int j, int collSize, String existingDesign,
			String underDesign, String tabs)
	{
		String underPart = "";

		if (j == 0)
		{
			if (j < collSize - 1)
			{
				underPart = "\n" + tabs + underDesign;
			}
			else
			{
				underPart = "\n" + tabs + underDesign + "\n";
			}
		}
		else
		{
			if (j < collSize - 1)
			{
				underPart += tabs + underDesign;
			}
			else
			{
				underPart += "\t" + underDesign + "\n";
			}
		}

		existingDesign += underPart;
		return existingDesign;
	}

	private String getTabs(int counter)
	{
		String result = "";

		for (int i = 0; i < counter; i++)
		{
			result += "\t";
		}
		return result;
	}

	public static class Node<T> implements Comparable<Node<T>>
	{
		private T value;
		private Node<T> left, right;

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