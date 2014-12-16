package main.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.interfaces.Map;
import main.implementation.MyMap;

public class MyMapTests {
	
	private Map myMap;
	
	
	static class Person
	{
		public int id;
		
		public Person(int id)
		{
			this.id = id;
		}
	}

	@Before
	public void setUp() throws Exception {
		myMap = new MyMap();	
	}

	@Test
	public void testAdd() {		
		Person p1 = new Person(1);
		Person p2 = new Person(2);
		Person p3 = new Person(3);

		myMap.add(p1.id, p1);
		myMap.add(p2.id, p2);
		myMap.add(p3.id, p3);

		assertTrue("Failed to add 3 values to map!",(myMap.size() == 3));
	}
	
	@Test
	public void testAddMany() {	
		for (int i=0; i<10000;++i){
			Person p = new Person(i);
			myMap.add(p.id, p);	
		}
		assertTrue("Failed to add 1000 values to map!",(myMap.size() == 10000));
	}
	
	@Test
	public void testAddEqualKeys() {
		Person p1 = new Person(1);
		Person p2 = new Person(1);
		myMap.add(p1.id, p1);
		myMap.add(p2.id, p2);
		assertTrue("Objects with equal keys can not be written to hash map two times!",(myMap.size()==1));
	}
	
	
	@Test
	public void testContains() {
		Person p1 = new Person(1);
		Person p2 = new Person(2);
		Person p3 = new Person(300);
			
		myMap.add(p1.id, p1);
		myMap.add(p2.id, p2);
		myMap.add(p3.id, p3);

		assertTrue("Added Values missing from the map!",(myMap.contains(1)));
		assertTrue("Added Values missing from the map!",(myMap.contains(2)));
		assertTrue("Added Values missing from the map!",(myMap.contains(300)));
		
		assertTrue("Added value should be missing!",(!myMap.contains(40)));
	}
	
	@Test
	public void testGet() {
		Person p1 = new Person(1);
		Person p2 = new Person(20);
		
		myMap.add(p1.id, p1);
		myMap.add(p2.id, p2);
			
		assertTrue("Failed to get values from map!",(p1 == (Person)myMap.get(1)));
		assertTrue("Failed to get values from map!",(p2 == (Person)myMap.get(20)));
	}
	
	
	@Test (expected = NullPointerException.class)
	public void testGetFail() {
		Person p1 = new Person(300);
		assertTrue("This value shouldn't be in map!",(null==(Person)myMap.get(300)));
	}
	
	@Test
	public void testRemove() {		
		Person p1 = new Person(1);
		Person p2 = new Person(2);
		Person p3 = new Person(3);

		myMap.add(p1.id, p1);
		myMap.add(p2.id, p2);
		myMap.add(p3.id, p3);
		
		myMap.remove(1);
		assertTrue("Failed to remove 1 value from map!",(myMap.size() == 2));
	}
	
	@Test
	public void testRemoveMany() {	
		for (int i=0; i<10000;++i){
			Person p = new Person(i);
			myMap.add(p.id, p);	
		}
		for (int i=0; i<10000;++i){
			myMap.remove(i);
		}
		assertTrue("Failed to add and remove 1000 values to map!",(myMap.size() == 0));
	}
	@Test (expected = NullPointerException.class)
	public void testRemoveFromEmptyMap() {	
		myMap.remove(1);
	}
	
	@Test 
	public void testMapCopy(){
		Map newMap= new MyMap();
		newMap=myMap;
		assertTrue("MapTable can not be assigned",(newMap==null));
	}
}
