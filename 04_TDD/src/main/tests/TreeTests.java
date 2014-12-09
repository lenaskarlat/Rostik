package main.tests;

import static org.junit.Assert.*;
import main.impl.MyTree;
import main.interfaces.ITree;

import org.junit.Before;
import org.junit.Test;

public class TreeTests {

	private ITree<Integer> tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new MyTree<Integer>();
	}

	@Test
	public void testAddContains()
	{
		tree.add(1);
		tree.add(2);
		tree.add(3);
		
		assertTrue("Has to contain added element!", tree.contains(1));
		assertTrue("Has to contain added element!", tree.contains(2));
		assertTrue("Has to contain added element!", tree.contains(3));
		
		assertTrue("Cannot contain not added element!", !tree.contains(4));
	}
	
	@Test
	public void test() {
		
	}

}
