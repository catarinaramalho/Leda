package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				RecursiveDoubleLinkedListImpl<T> lastNil = new RecursiveDoubleLinkedListImpl<>();

				this.data = element;
				this.next = lastNil;
				lastNil.previous = this;
				if (this.previous == null) {
					RecursiveDoubleLinkedListImpl<T> headNil = new RecursiveDoubleLinkedListImpl<>();
					this.previous = headNil;
					headNil.setNext(this);
				}
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<>();
				node.setData(this.data);
				this.data = element;
				node.setNext(this.next);
				this.next = node;
				node.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(node);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.data.equals(element)) {
				if (this.previous.isEmpty())
					this.removeFirst();
				else if (this.next.isEmpty())
					this.removeLast();
				else {
					this.previous.setNext(this.next);
					((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this.previous);
				}
			} else
				this.next.remove(element);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.next.isEmpty() && this.previous.isEmpty()) {
				this.data = null;
				this.next = null;
				this.previous = null;
			} else {
				this.data = this.next.getData();
				this.next = this.next.getNext();
				((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.next.isEmpty()) {
				this.data = null;
				this.next = null;

				if (this.previous.isEmpty()) {
					this.previous = null;
				}

			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
