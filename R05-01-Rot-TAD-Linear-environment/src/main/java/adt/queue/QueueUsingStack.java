package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {
	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		}
		try {
			if (element != null) {
				while (!this.stack1.isEmpty()) {
					this.stack2.push(this.stack1.pop());
				}

				this.stack1.push(element);
				while (!this.stack2.isEmpty()) {
					this.stack1.push(this.stack2.pop());
				}
			}
		} catch (StackOverflowException | StackUnderflowException e) {
			throw new QueueOverflowException();
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		try {
			return this.stack1.pop();
		} catch (StackUnderflowException e) {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		T head = null;
		if (!isEmpty()) {
			head = this.stack1.top();
		}
		return head;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}
}
