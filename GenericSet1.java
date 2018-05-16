package project4;

public class GenericSet1<T> extends AbstractGSE<T> {
/*
This class uses a standard array implementation, such that
the unique elements of the set are stored in any order
in the array.
invariant 0 <= next <= contents.length
and for all i and j between 0 and next,
if i != j then contents[i] != contents[j]
correspondence maxSize = contents.length;
correspondence conceptual this = Union {contents(i)}
for i = 1 to next
*/

private int count;
private T[] myContents;
@Override

public void insert(T element) {
	myContents[count]=element;
	count++;
	
}
@Override
public boolean contains(T element) {
	for(int i=0; i<count; i++){
		if(myContents[i].equals(element)){
			return true;
		}
	}
	return false;
}
@Override
public void remove(T element) {
	boolean foundFlag = false;
    for (int i = 0; i < count; ++i) {
        if (myContents[i].equals(element)) {
            foundFlag = true;
            --count;
        }

        if (foundFlag) {
            myContents[i] = myContents[i + 1];
        }
    }
	
}
@Override
public T removeAny() {
	return myContents[--count];	
}
@Override
public int size() {
	return count;
}
@Override
public int maxSize() {
	return myContents.length;
}
@Override
public void clear() {
	count = 0;
}
}
