package project4;

import java.util.ArrayList;

public class GenericSet2<T> extends AbstractGSE<T> {
	/*
	This class uses an ArrayList implementation, such
	that the unique elements of the set are stored in any order
	in an instance of java.util.ArrayList
	invariant for all e: T, Occurs_Ct(e, list) <= 1;
	correspondence conceptual this = Entries(list);
	*/
	int capacity;
	private ArrayList<T> list = new ArrayList<T>(capacity);  
	@Override
	public void insert(T element) {
		list.add(element);
	}

	@Override
	public boolean contains(T element) {
		return list.contains(element);
	}

	@Override
	public void remove(T element) {
		list.remove(element);
	}

	@Override
	public T removeAny() {
		return list.remove(0);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public int maxSize() {
		return capacity;
	}

	@Override
	public void clear() {
		list.clear();
		
	}

}
