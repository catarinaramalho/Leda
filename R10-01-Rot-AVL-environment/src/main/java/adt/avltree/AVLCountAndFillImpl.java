package adt.avltree;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance (BSTNode<T> node) {
		BSTNode<T> newRoot = null;
		int balance = this.calculateBalance(node);

		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					newRoot = Util.rightRotation(node);
					this.LLcounter++;
				}
				else {
					newRoot = Util.doubleRightRotation(node);
					this.LRcounter++;
				}
			}else{
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					newRoot = Util.leftRotation(node);
					this.RRcounter++;
				}
				else {
					newRoot = Util.doubleLeftRotation(node);
					this.RLcounter++;
				}
			}
		}

		if (this.getRoot().equals(node) && newRoot != null) {
			this.root = newRoot;
		}

	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		Set<T> treeSet = new TreeSet<>(Arrays.asList(this.order()));
		treeSet.addAll(Arrays.asList(array));
		array = (T[]) treeSet.toArray(new Comparable[0]);
		this.root = new BSTNode<>();
		int height = 0;
		while (avlIterate(array, 0, array.length, height)) {
			height++;
		}
	}

	private boolean avlIterate (T[] array, int left, int right, int height) {
		boolean verify = false;
		if (right > left) {
			int middle = left + (right - left) / 2;

			if (height == 0) {
				this.insert(array[middle]);
				verify = true;
			}
			else {
				verify = avlIterate(array, left, middle, height - 1) || avlIterate(array, middle + 1, right, height - 1);
			}
		}

		return verify;
	}
	

}
