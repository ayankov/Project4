package project4;

public interface GenericSetExtended<T> extends GenericSet<T> {
/**
* @param rhs The right-hand-side of the union operation,
* i.e. the set to union with this
* @requires this.maxSize >= |this| + |rhs|
* @updates this
* @clears rhs
* @ensures
* this = #this union rhs
*/
void union(GenericSet<T> rhs);

/**
* @param rhs The right-hand-side of the intersect operation,
* i.e. the set to intersect with this
* @updates this
* @clears rhs
* @ensures
* this = #this intersect rhs
*/
void intersect(GenericSet<T> rhs);
/**
* @param rhs The right-hand-side of the difference operation,
* i.e. the set to subtract from this
* @updates this
* @clears rhs
* @ensures
* this = #this \ rhs
*/
void difference(GenericSet<T> rhs);
/**
* @updates set
* @ensures
* set = this
*/
void copy(GenericSet<T> set);
}