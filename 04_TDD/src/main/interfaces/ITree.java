package main.interfaces;

public interface ITree<T> {
	public void add(T element);
	
	public T remove(T element);
	
	public boolean contains(T element);
	
	public int size();
}
