package main.interfaces;

public interface List {
	void add(int x);

	int get(int position);
	
	boolean contains(int x);

	void remove(int x);

	int size();
}
