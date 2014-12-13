package main.implementation;

import main.interfaces.List;

public class MyList implements List {
	
	private Element first;
	private Element last;
	private int size;
//	private Element last;
//	private int listsize=0;
//	private static final int LENGTH = 15;
//	private int elements[];
	
	public MyList(){
		this.first = null;
		this.size = 0;
		this.last = null;
//		elements = new int[LENGTH];
		
	}
	
	
	private class Element {
		
		private int value;
		private Element next;
		
		public Element(int number)
		{
			this.value = number;
			this.next = null;
		}
		
	}
	@Override
	public void add(int x) {
		if (this.first==null) {
			this.first = new Element(x);	
			this.last = this.first;
			++this.size;
		}
		else
		{
			Element temp = this.first;
			while (temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next = new Element(x);
			this.last = temp.next;
			++this.size;
		}
		
		//if(allocated_size == listSize) reallocate();==> elements = newint[bigger_size]; 
		//elements[listsize++] = x;
		
		
	}

	@Override
	public int get(int position) {
		if (position>this.size()) return 0;
		else
		{
			Element temp = this.first;
			int count = 0;
			while (count < position)
			{
				temp = temp.next;
				++count;
			}
			return temp.value;
		//return elements[position];
		}
	}

	@Override
	public boolean contains(int x) {

		Element temp = this.first;
		int count=0;
		while (count<this.size)
		{
			if (temp.value == x) return true;
			else temp = temp.next;
			++count;
		}
		return false;
//		boolean flag = false;
//		for (int i = 0; i < listsize; ++i)
//		{
//			if (elements[i]==x)
//			{
//				flag = true;
//			}
//		}	
//		return false;
	}

	@Override
	public void remove(int x) {
		Element temp = this.first;
		while (temp.next!=null)
		{
			if (temp.next.value==x)
			{
				temp.next=temp.next.next;
				--this.size;
				break;
			}
			temp=temp.next;
		}	
		
	}
		
//		int j = 0;
//		for (int i = 0; i < listsize; ++i)
//		{
//			if (elements[i]==x){
//				j = i;
//				listsize--;
//				for (int k=j; k<listsize; ++k)
//				{
//					elements[k] = elements[k+1];//tyt shos ne te
//				}	
//				break;
//			}
//		}


	@Override
	public int size() {
		
		return this.size;
		//return listsize;
	}

}
