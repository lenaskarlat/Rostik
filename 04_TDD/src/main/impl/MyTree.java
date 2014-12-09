package main.impl;

import main.interfaces.ITree;

public class MyTree<T> implements ITree<T> {

	
	
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		System.out.println("I'm wokring on this.");
	}

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		System.out.println("I'm wokring on this.");
		return null;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		System.out.println("I'm wokring on this.");
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		System.out.println("I'm wokring on this.");
		return 0;
	}

}
