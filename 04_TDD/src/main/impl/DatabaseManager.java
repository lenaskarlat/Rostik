package main.impl;

import main.interfaces.ITree;

public class DatabaseManager {
	
	ITree<Integer> database;
	
	public DatabaseManager(ITree<Integer> database)
	{
		System.out.println("I'm working on this!");
		this.database = database;
	}
	
	/**
	 * Is allowed to save only positive numbers.
	 * @param data
	 */
	public void save(int data)
	{
		System.out.println("I'm working on this!");
		if(data > 0)
			database.add(data);
		else
			throw new RuntimeException("Numbers below zero are not allowed!");
	}
	
	/**
	 * @param data
	 * @return
	 */
	public boolean contains(int data)
	{
		return database.contains(data);
	}
	
}
