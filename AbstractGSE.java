package project4;

public abstract class AbstractGSE<T> implements GenericSetExtended<T> {
@Override
public final void union(GenericSet<T> rhs) {
	while(rhs.size()>0){
	T element = rhs.removeAny();
	this.insert(element);
	}

}

@Override
public final void intersect(GenericSet<T> rhs) {
    GenericSet<T> biggerSet, smallerSet;
    if (this.size() > rhs.size()) {
        biggerSet = this;
        smallerSet = rhs;
    } else {
        biggerSet = rhs;
        smallerSet = this;
    }
    this.clear();
    while(biggerSet.size()>0){
    	T element = biggerSet.removeAny();
    	if(smallerSet.contains(element)){
    		this.insert(element);
    	}
    }
    	

}
@Override
public final void difference(GenericSet<T> rhs) {
	while(rhs.size()>0){
		T element=rhs.removeAny();
		if(this.contains(element)){
			this.remove(element);
		}
	}
}
@Override
public final void copy(GenericSet<T> set) {
	while(this.size()>0){
		T element=this.removeAny();
		set.insert(element);
	}
}
@Override
public final boolean equals(Object obj) {
	GenericSet<T> rhs = (GenericSet<T>)obj;
	if(rhs.size() != this.size()){
		return false;
	}
	while(this.size()>0){
		T element= this.removeAny();
				if(rhs.contains(element) == false){
					return false;
				}
		}
	
	return true;
}
/**
* This method returns a string representation of the set,
* listing the elements in any order.
* Example: { elem1, elem2, elem3, elem4 }
*/
@Override
public final String toString() {
	String output = null;
	while(this.size()>0){
		String s = (String) this.removeAny();
		output = output + " " + s;
	}
	return output;
}
}