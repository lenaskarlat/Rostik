package main.implementation;

import java.util.LinkedList;

import main.interfaces.Map;

public class MyMap implements Map {

	LinkedList<Element>[] mapArray;
	int mapSize;

	private class Element 
	{
		public int key;
		public Object value;
		public Element next;

		public Element(int k, Object v) {
			this.key = k;
			this.value = v;
		}

	}

	public MyMap() {
		this.mapArray = new LinkedList[10];    
		this.mapSize = 0;
	}

	static int countHash(int key) {
		int hash = key % 10;
		return hash;
	}

	@Override
	public void add(int key, Object value) {
		// TODO Auto-generated method stub

		this.mapArray[MyMap.countHash(key)] = new LinkedList();
		this.mapArray[MyMap.countHash(key)].add(new MyMap.Element(key, value));
		++this.mapSize;
	}

	@Override
	public Object get(int neededKey) {
		Object result=null;
		LinkedList<Element> tempList = this.mapArray[MyMap.countHash(neededKey)];
		for (int i = 0; i < tempList.size(); ++i) {
			Element e = tempList.get(i);
			if (e.key == neededKey)
				result = e.value;
		}
		return result;
		
	}

	@Override
	public boolean contains(int neededKey) {
		LinkedList<Element> tempList = this.mapArray[MyMap.countHash(neededKey)];
		for (int i = 0; i < tempList.size(); ++i) {
			Element e = tempList.get(i);
			if (e.key == neededKey)
				return true;
		}
		return false;

	}

	@Override
	public void remove(int neededKey) {
		LinkedList<Element> tempList = this.mapArray[MyMap.countHash(neededKey)];
		for (int i = 0; i < tempList.size(); ++i) {
			Element e = tempList.get(i);
			if (e.key == neededKey)
				tempList.remove(e);
		}

	}

	@Override
	public int size() {

		return this.mapSize;
	}

}
