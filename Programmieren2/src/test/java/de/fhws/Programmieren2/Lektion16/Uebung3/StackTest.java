package de.fhws.Programmieren2.Lektion16.Uebung3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest
{

	@Test
	void testStackAttributePush()
	{
		Stack stk = new StackAttribute();
		stk = getTestStack(stk);
	}

	@Test
	void testStackVererbungPush()
	{
		Stack stk = new StackVererbung();
		stk = getTestStack(stk);
	}
	
	@Test
	void testStackAttributePop()
	{
		Stack stk = new StackAttribute();
		popStack(stk);
	}
	
	@Test
	void testStackVererbungPop()
	{
		Stack stk = new StackVererbung();
		popStack(stk);
	}
	
	public void popStack(Stack stack)
	{
		try
		{
			stack.pop();
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			String errorMessage = e.getMessage();
			assertEquals("Invalid Arguement", errorMessage);
		}
		
		stack = getTestStack(stack);
		
		Object obj = stack.pop();
		int j = 10071992;
		assertTrue(obj instanceof Integer);
		assertEquals(j, (int)obj);
		
		obj = stack.pop();
		String[] testStringArray = {"Was", "geht", "ab", "?"};
		assertTrue(obj instanceof String[]);
		assertArrayEquals(testStringArray, (String[])obj);
		
		obj = stack.pop();
		assertTrue(obj instanceof StackAttribute);
		
		obj = stack.pop();
		int[] testIntegerArray = {1, 2, 3, 4, 5, 6, 7};
		assertTrue(obj instanceof int[]);
		assertArrayEquals(testIntegerArray, (int[])obj);
	}
	
	public Stack getTestStack(Stack stack)
	{		
		int[] i = {1, 2, 3, 4, 5, 6, 7};
		stack.push(i);
		
		StackAttribute testStack = new StackAttribute();
		stack.push(testStack);
		
		String[] str = {"Was", "geht", "ab", "?"};
		stack.push(str);
		
		Integer j = new Integer(10071992);
		stack.push(j);
		
		try
		{
			Object obj = null;
			stack.push(obj);
			fail("Exception expected");
		}
		catch(RuntimeException e)
		{
			String errorMessage = e.getMessage();
			assertEquals("Invalid Arguement", errorMessage);
		}
		
		return stack;
	}

}
