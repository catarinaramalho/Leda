package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		this.array = (T[]) new Object[size];
		this.top = -1;
	}

	@Override
	public T top() {
		T topo = null;
		if (!this.isEmpty()) {
			topo = this.array[this.top];
		}
		return topo;
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top == (array.length - 1);
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		if (element != null) {
			this.array[++this.top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}
		return this.array[this.top--];
	}

}
