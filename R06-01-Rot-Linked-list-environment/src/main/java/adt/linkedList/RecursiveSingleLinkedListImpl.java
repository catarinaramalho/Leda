package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		int size = 0;
		if (!this.isEmpty()) {
			size = 1 + this.next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if (!this.isEmpty() && element != null) {
			if (this.getData().equals(element)) {
				search = this.data;
			} else {
				search = this.next.search(element);
			}

		}
		return search;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.next = new RecursiveSingleLinkedListImpl<T>();

			} else {
				this.next.insert(element);
			}

		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.getData().equals(element)) {
				this.setData(this.next.getData());
				this.setNext(this.next.getNext());
			} else {
				this.next.remove(element);
			}
		}

	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		this.toArray(array, 0);
		return array;
	}

	private void toArray(T[] array, int i) {
		if (!this.isEmpty()) {
			array[i] = this.data;
			this.next.toArray(array, i + 1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
