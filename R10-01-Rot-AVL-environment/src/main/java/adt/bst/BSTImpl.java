package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.root);
	}

	public int height(BSTNode<T> node) {
		int height = -1;
		if (!node.isEmpty()) {
			height = 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
		}
		return height;

	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, this.getRoot());
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> search = new BSTNode<>();
		if (element != null && !node.isEmpty()) {
			if (element.compareTo(node.getData()) < 0) {
				search = this.search(element, (BSTNode<T>) node.getLeft());
			} else if (element.compareTo(node.getData()) > 0) {
				search = this.search(element, (BSTNode<T>) node.getRight());
			} else {
				search = node;
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if (element != null && search(element).isEmpty()) {
			this.insert(this.getRoot(), element);
		}

	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (node.getData().compareTo(element) > 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}
	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = this.maximum(this.getRoot());
		}
		return result;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> result = node;
		if (!node.getRight().isEmpty()) {
			result = maximum((BSTNode<T>) node.getRight());
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = this.minimum(this.getRoot());
		}
		return result;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> result = node;
		if (!node.getLeft().isEmpty()) {
			result = minimum((BSTNode<T>) node.getLeft());
		}
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty())
				result = minimum((BSTNode<T>) node.getRight());
			else {
				result = this.sucessor(node);
			}
		}
		return result;
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		BSTNode<T> result = (BSTNode<T>) node.getParent();
		if (node.getParent() != null && !result.isEmpty() && node.equals(result.getRight())) {
			result = this.sucessor((BSTNode<T>) node.getParent());
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty())
				result = minimum((BSTNode<T>) node.getLeft());
			else {
				result = this.predecessor(node);
			}
		}
		return result;
	}

	private BSTNode<T> predecessor(BSTNode<T> node) {
		BSTNode<T> result = (BSTNode<T>) node.getParent();
		if (node.getParent() != null && !result.isEmpty() && node.equals(result.getLeft())) {
			result = this.predecessor((BSTNode<T>) node.getParent());
		}
		return result;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		remove(node);
	}

	private boolean hasOnlyChild(BSTNode<T> node) {
		return (node.getLeft().isEmpty() && !node.getRight().isEmpty()) ||
				(!node.getLeft().isEmpty() && node.getRight().isEmpty());
	}

	private void remove(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			// Primeiro caso: nó é folha.
			if (node.isLeaf()) {
				node.setData(null);

				// Segundo caso: nó tem apenas um filho (esquerda ou direita)
			} else if (hasOnlyChild(node)) {
				if (node.getParent() != null) {
					if (node.getParent().getData().compareTo(node.getData()) > 0) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					} else {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					}
				}

				// Terceiro caso: Nó tem dois filhos
			} else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}

	}

	@Override
	public T[] preOrder() {
		ArrayList<T> lista = new ArrayList<>();
		preOrder(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[lista.size()]);

	}

	private void preOrder(ArrayList<T> lista, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			lista.add(node.getData());
			preOrder(lista, (BSTNode<T>) node.getLeft());
			preOrder(lista, (BSTNode<T>) node.getRight());

		}

	}

	@Override
	public T[] order() {
		ArrayList<T> lista = new ArrayList<>();
		order(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[lista.size()]);

	}

	private void order(ArrayList<T> lista, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			order(lista, (BSTNode<T>) node.getLeft());
			lista.add(node.getData());
			order(lista, (BSTNode<T>) node.getRight());

		}

	}

	@Override
	public T[] postOrder() {
		ArrayList<T> lista = new ArrayList<>();
		postOrder(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[lista.size()]);

	}

	private void postOrder(ArrayList<T> lista, BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			postOrder(lista, (BSTNode<T>) node.getLeft());
			postOrder(lista, (BSTNode<T>) node.getRight());
			lista.add(node.getData());

		}

	}


	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
