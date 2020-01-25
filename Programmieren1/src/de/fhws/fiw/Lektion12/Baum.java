package de.fhws.fiw.Lektion12;

public class Baum
{
	private Knoten root;

	public void insert(String word, String definition)
	{
		Knoten branch = new Knoten(word, definition);
		Knoten tree = root;

		if(tree == null)
		{
			root = new Knoten(word, definition);
			tree = root;
		}
		else
		{
			while(tree != null)
			{
				if(tree.getWord().compareToIgnoreCase(word) > 0)
				{
					if(tree.getLeft() == null)
					{
						tree.setLeft(branch);
						break;
					}
					else
					{
						tree = tree.getLeft();
					}
				}
				else if(tree.getWord().compareToIgnoreCase(word) < 0)
				{
					if(tree.getRight() == null)
					{
						tree.setRight(branch);
						break;
					}
					else
					{
						tree = tree.getRight();
					}
				}
				else
				{
					break;
				}
			}
		}
	}
	
	public void insert(Knoten k)
	{
		Knoten branch = k;
		Knoten tree = root;

		if(tree == null)
		{
			root = branch;
			tree = root;
		}
		else
		{
			while(tree != null)
			{
				if(tree.getWord().compareToIgnoreCase(k.getWord()) >= 0)
				{
					if(tree.getLeft() == null)
					{
						tree.setLeft(branch);
						break;
					}
					else
					{
						tree = tree.getLeft();
					}
				}
				else
				{
					if(tree.getRight() == null)
					{
						tree.setRight(branch);
						break;
					}
					else
					{
						tree = tree.getRight();
					}
				}
			}
		}
	}
	
	public void print()
	{
		Knoten temp = this.root;
		
		System.out.printf("%-40s", "Wort");
		System.out.println("Bedeutung");
		
		printTree(temp);
	}
	
	private void printTree(Knoten temp)
	{
		if(temp.getLeft() != null)
		{
			printTree(temp.getLeft());
		}
		
		System.out.printf("%-40s", temp.getWord());
		System.out.println(temp.getDefinition());
		
		if(temp.getRight() != null)
		{
			printTree(temp.getRight());
		}
	}
	
	public String search(String word)
	{
		Knoten temp = this.root;
		
		return searchWord(word, temp);
	}
	
	private String searchWord(String word, Knoten temp)
	{
		if(temp == null)
			return null;
		else if(temp.getWord().toLowerCase().equals(word.toLowerCase()))
			return temp.getDefinition();
		
		if(temp.getWord().toLowerCase().compareTo(word.toLowerCase()) >= 0)
			return searchWord(word, temp.getLeft());
		
		return searchWord(word, temp.getRight());
	}
	
	public void delete(Knoten k)
	{
		deleteNode1(k, this.root);
	}
	
	private void deleteNode1(Knoten k, Knoten temp)
	{
		
		while(temp != null)
		{
			if(temp.getWord().equals(k.getWord()))
			{
				if(temp.getLeft() != null)
				{
					temp = temp.getLeft();
				}
				else if(temp.getRight() != null)
				{
					temp = temp.getRight();
				}
				else
				{
					temp = null;
				}
			}
			else
			{
				if(temp.getWord().compareTo(k.getWord()) > 0)
				{
					if(temp.getLeft() != null)
					{
						if(temp.getLeft().getWord().toUpperCase().equals(k.getWord().toUpperCase()))
						{
							Knoten insertLeft = temp.getLeft().getRight();
							temp.setLeft(temp.getLeft().getLeft());
							
							if(insertLeft != null)
								insert(insertLeft);
						}
					}
				}
				else
				{
					if(temp.getRight() != null)
					{
						if(temp.getRight().getWord().toUpperCase().equals(k.getWord().toUpperCase()))
						{
							Knoten insertRight = temp.getRight().getLeft();
							temp.setRight(temp.getRight().getRight());
							
							if(insertRight != null)
								insert(insertRight);
						}
					}
				}
				
			}	
		}
		
	}
	
	private void deleteNode(Knoten k, Knoten temp)
	{
		boolean deleted = false;
		
		if(temp.getLeft() != null)
		{
			if(temp.getLeft().getWord().toUpperCase().equals(k.getWord().toUpperCase()))
			{
				Knoten insertLeft = temp.getLeft().getRight();
				temp.setLeft(temp.getLeft().getLeft());
				
				if(insertLeft != null)
					insert(insertLeft);
				
				deleted = true;
			}
		}
		
		if(temp.getRight() != null)
		{
			if(temp.getRight().getWord().toUpperCase().equals(k.getWord().toUpperCase()))
			{
				Knoten insertRight = temp.getRight().getLeft();
				temp.setRight(temp.getRight().getRight());
				
				if(insertRight != null )
					insert(insertRight);
				
				deleted = true;
			}
		}
		
		if(!deleted)
		{
			if(temp.getWord().toUpperCase().compareTo(k.getWord().toUpperCase()) >= 0)
			{
				deleteNode(k, temp.getLeft());
			}
			else
			{
				deleteNode(k, temp.getRight());
			}	
		}
	}
}
