package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();

		node.setRight(pivot.getLeft());
		pivot.setLeft(node);

		pivot.setParent(node.getParent());
		node.setParent(pivot);
		node.getRight().setParent(node);

		if (pivot.getParent() != null) {
			if (pivot.getParent().getRight().equals(node)) {
				pivot.getParent().setRight(pivot);
			}else{
				pivot.getParent().setLeft(pivot);
			}
		}return pivot;
	}
	 // nao sei se tinha esses metodos
	public static <T extends Comparable<T>> BSTNode<T> doubleLeftRotation (BSTNode<T> node) {
		rightRotation((BSTNode<T>) node.getRight());
		return leftRotation(node);
	}

	public static <T extends Comparable<T>> BSTNode<T> doubleRightRotation (BSTNode<T> node) {
		leftRotation((BSTNode<T>) node.getLeft());
		return rightRotation(node);
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();

		node.setLeft(pivot.getRight());
		pivot.setRight(node);

		pivot.setParent(node.getParent());
		node.setParent(pivot);
		node.getLeft().setParent(node);

		if (pivot.getParent() != null) {
			if (pivot.getParent().getLeft().equals(node)) {
				pivot.getParent().setLeft(pivot);
			} else{
				pivot.getParent().setRight(pivot);

			}
		} return pivot;
	
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
