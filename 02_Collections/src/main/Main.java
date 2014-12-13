package main;

import java.util.LinkedList;

import main.interfaces.List;
import main.interfaces.Map;
import main.implementation.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		MyList a = new MyList();
		testList(a);
		MyMap b= new MyMap(); //!!!!!!!!!!!!!!! hope I've made normal hashmap!
		testMap(b); 
	}

	static class Person
	{
		public int id;
		
		public Person(int id)
		{
			this.id = id;
		}
	}
	
	private static void testMap(Map map) throws Exception {
		
		Person p1 = new Person(1);
		Person p2 = new Person(2);
		Person p3 = new Person(3);
		
		map.add(p1.id, p1);
		map.add(p2.id, p2);
		map.add(p3.id, p3);
		
		if(map.size() != 3)
			throw new Exception("Failed to add 3 values to map!");
		else System.out.println("adding and size works");
	
		if(!map.contains(1) || 
				!map.contains(2) ||
				!map.contains(3))
			throw new Exception("Added Values missing from the map!");
		else System.out.println("contains works");
		
		if(p1 != (Person)map.get(1) ||
				p2 != (Person)map.get(2) ||
				p3 != (Person)map.get(3))
			throw new Exception("Failed to get values from map!");
		else System.out.println("getting works");
		
		map.remove(2);
		if(map.contains(2))
			throw new Exception("Failed to remove value from map!");
		else System.out.println("removing works");
		
		
		System.out.println("Map test is done");
		
	}

	private static void testList(List list) throws Exception {

		list.add(1);
		list.add(2);
		list.add(3);

		//for (int i = 0; i < 100; i++)
		for (int i = 0; i < 10; i++)
			list.add(i);

		if (list.size() != 13)
			throw new Exception("Size is " + list.size() + " instead of 13!");
		else System.out.println("adding and size works");

		int required_total=6+(9*10)/2;
		
		int total = 0;
		for (int i = 0; i < list.size(); ++i)
			total += list.get(i);

		if (total != required_total)
			throw new Exception("Some elements are stored incorrectly! Total is " + total + " instead of "
					+ required_total + "!");
		else System.out.println("total works");
		
		for (int i = 0; i < 1000; ++i)
			list.remove(i);
		
		if (list.size() != 3 || !list.contains(1) || !list.contains(2) || !list.contains(3))
			throw new Exception("You were supposed to remove only first occurance of the element!");
		else System.out.println("remove and contains works");
		
		System.out.println("List test is done");

	}

}
