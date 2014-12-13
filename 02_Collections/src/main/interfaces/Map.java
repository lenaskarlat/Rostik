package main.interfaces;

public interface Map {
	void add(int key, Object value);
	
	Object get(int key);

	boolean contains(int key);

	void remove(int key);

	int size();
}
