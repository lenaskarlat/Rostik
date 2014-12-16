package main.implementation;

import java.util.LinkedList;

import main.interfaces.Map;

public class MyMap implements Map {

	LinkedList<Element>[] mapArray;
	int mapSize;

	private class Element {
		public int key;
		public Object value;

		public Element(int k, Object v) {
			this.key = k;
			this.value = v;
		}

	}

	public MyMap() {
		this.mapArray = new LinkedList[10];
		this.mapSize = 0;
	}

	static int countHash(int key) { // added recursive calculation of division
									// by 10
		int hash = 0;
		if ((key >= 0) && (key < 10)) {
			hash = key % 10;
		} else
			hash = countHash(hash);
		return hash;
	}

	@Override
	public void add(int key, Object value) {
		int index = MyMap.countHash(key);
		if (this.mapArray[index]!=null){
			this.mapArray[index].add(new MyMap.Element(key, value));
			++this.mapSize;
		}
		else{
			this.mapArray[index] = new LinkedList();
			this.mapArray[index].add(new MyMap.Element(key, value));
			++this.mapSize;
		}
		
	}

	@Override
	public Object get(int neededKey) {
		Object result = null;
		LinkedList<Element> tempList = this.mapArray[MyMap.countHash(neededKey)];
		int listsize = tempList.size();
		if (listsize > 0) { // added here
			for (int i = 0; i < listsize; ++i) {
				Element e = tempList.get(i);
				if (e.key == neededKey)
					result = e.value;
			}
		}
		return result;

	}

	@Override
	public boolean contains(int neededKey) {
		LinkedList<Element> tempList = this.mapArray[MyMap.countHash(neededKey)];
		int listsize = tempList.size();
		if (listsize > 0) { // added here
			for (int i = 0; i < listsize; ++i) {
				Element e = tempList.get(i);
				if (e.key == neededKey)
					return true;
			}
		}
		return false;

	}

	@Override
	public void remove(int neededKey) {
		LinkedList<Element> tempList = this.mapArray[MyMap.countHash(neededKey)];
		int listsize = tempList.size();
		if (listsize > 0) { // added here
			for (int i = 0; i < listsize; ++i) {
				Element e = tempList.get(i);
				if (e.key == neededKey)
					tempList.remove(e);
				this.mapArray[MyMap.countHash(neededKey)] = tempList; // added this
				--this.mapSize;
			}
		}

	}

	@Override
	public int size() {

		return this.mapSize;
	}

}
