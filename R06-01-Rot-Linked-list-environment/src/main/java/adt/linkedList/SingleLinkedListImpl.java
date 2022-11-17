package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = getHead();
		while (!aux.isNIL()){
			size++;;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if(!isEmpty() && element!=null){
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.isNIL() && !aux.getData().equals(element)){
				aux = aux.getNext();
			}
			search = aux.getData();
		
		}
		return search;
		
	}

	@Override
	public void insert(T element) {
		if (element != null){
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.isNIL()){
				aux = aux.getNext();
			} aux.data= element;
			aux.next = new SingleLinkedListNode<>();
		}
		
	}

	@Override
	public void remove(T element) {
		if(!isEmpty() && element!=null){
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.isNIL() && !aux.getData().equals(element)){
				aux = aux.getNext();
			} if (!aux.isNIL()){
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = getHead();
		T[] array = (T[]) new Object[this.size()];
		int i = 0;
		while(!aux.isNIL()){
			array[i] = aux.getData();
			i++;
			aux = aux.getNext();
		}
		return array;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
