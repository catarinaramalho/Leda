package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 * - insert
 * - preOrder
 * - postOrder
 * - remove
 * - height
 * - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;

		if (!node.isEmpty()) {
			result = this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
		}
		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		BSTNode<T> newRoot = null;
		int balance = this.calculateBalance(node);

		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					newRoot = Util.rightRotation(node);
				} else {
					newRoot = Util.doubleRightRotation(node);
				}

			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					newRoot = Util.leftRotation(node);
				} else {
					newRoot = Util.doubleLeftRotation(node);
				}
			}

		}
		if (this.getRoot().equals(node) && newRoot != null) {
			this.root = newRoot;
		}

	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node.getParent() != null) {
			this.rebalance((BSTNode<T>) node.getParent());
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			this.insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setRight(new BSTNode.Builder<T>().parent(node).build());
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
		} else {
			if (element.compareTo(node.getData()) > 0) {
				this.insert((BSTNode<T>) node.getRight(), element);
			} else {
				this.insert((BSTNode<T>) node.getLeft(), element);
			}
			rebalance(node);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = this.search(element);

			if (!node.isEmpty()) {
				if (node.isLeaf()) { // Primeiro caso: nó é folha.
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
					rebalanceUp(node);
				} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) { // Segundo caso: nó tem apenas um
																					// filho (esquerda ou direita)
					BSTNode<T> childNode = node.getRight().isEmpty() ? (BSTNode<T>) node.getLeft()
							: (BSTNode<T>) node.getRight();
					if (this.root.equals(node)) {
						this.root = childNode;
						this.root.setParent(null);
					} else {
						childNode.setParent(node.getParent());
						if (node.getParent().getLeft().equals(node))
							node.getParent().setLeft(childNode);
						else
							node.getParent().setRight(childNode);
					}
					rebalanceUp(node);
				} else { // Terceiro caso: Nó tem dois filhos
					T sucessor = this.sucessor(node.getData()).getData();
					this.remove(sucessor);
					node.setData(sucessor);
				}
			}
		}
	}
}
