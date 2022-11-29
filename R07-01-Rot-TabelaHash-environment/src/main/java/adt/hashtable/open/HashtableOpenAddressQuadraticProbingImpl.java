package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) {
			throw new HashtableOverflowException();
		}
		if (element != null && this.search(element) == null) {
			int probe = 0;
			int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			while (this.table[index] != null && !this.table[index].equals(this.deletedElement)
					&& probe < this.table.length) {
				probe++;
				index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
				this.COLLISIONS++;
			}
			this.table[index] = element;
			this.elements++;
		}

	}

	@Override
	public void remove(T element) {
		int indexOf = this.indexOf(element);
		if (indexOf >= 0) {
			this.table[indexOf] = this.deletedElement;
			this.elements--;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		T search = null;
		int indexOf = indexOf(element);
		if (indexOf >= 0) {
			search = (T) this.table[indexOf];
		}

		return search;
	}

	@Override
	public int indexOf(T element) {
		int i = -1;
		if (!isEmpty() && element != null) {
			int probe = 0;
			int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			while (this.table[index] != null && !this.table[index].equals(element) && probe < this.table.length) {
				probe++;
				index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
			}
			if (this.table[index] != null && this.table[index].equals(element)) {
				i = index;
			}

		}
		return i;
	}
}
