package main.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;

import main.impl.DatabaseManager;
import main.impl.MyTree;
import main.interfaces.ITree;

public class DatabaseManagerTests {
	private DatabaseManager databaseManager;
	static final int[] NUMBERS = new int[]{5,10,15, 6, 7};
	@Before
	public void setUp() {
		ITree<Integer> mock = mock(ITree.class);
		for(int i:NUMBERS)
			when(mock.contains(i)).thenReturn(true);
		
		databaseManager = new DatabaseManager(mock);
	}
	
	@Test
	public void savesPositiveNumbers()
	{
		databaseManager.save(5);
		databaseManager.save(10);
		databaseManager.save(15);
	}
	
	@Test(expected = RuntimeException.class)
	public void failsOnNegativeNumbers()
	{
		databaseManager.save(-5);
	}
	
	@Test
	public void testcontains()
	{
		databaseManager.save(6);
		databaseManager.save(7);
		
		assertTrue(databaseManager.contains(6));
		assertTrue(!databaseManager.contains(8));
	}
	
}
