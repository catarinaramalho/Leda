package adt.bst;

import java.util.ArrayList;
import java.util.List;

import adt.bt.BTNode;

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

	private int height(BSTNode<T> node){
		if(node.isEmpty()){
			return -1;
		}
		return 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));

	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> search = new BSTNode<>();
		if (element != null){
			if(this.getRoot().isEmpty() || element.compareTo(this.getRoot().getData()) == 0){
				search = this.getRoot();
			} else {
				if (element.compareTo(root.getData())<0){
					search = search(element, (BSTNode<T>) this.getRoot().getLeft());
				} else {
					search = search(element, (BSTNode<T>) this.getRoot().getRight());
				}
			}
		}
		return search;
	}

	private BSTNode<T> search(T element,BSTNode<T> node){
		if(node.isEmpty()){
			return node;
		} else if (element.compareTo(node.getData())<0){
			return search(element, (BSTNode<T>) node.getLeft());
		} else if (element.compareTo(node.getData())>0){
			return search(element, (BSTNode<T>) node.getRight());
		} else {
			return node;
		}
	}

	@Override
	public void insert(T element) {
		if (element != null){
			this.insert(this.root, element, new BSTNode<T>());
		}
		
	}

	private void insert(BSTNode<T> node, T element, BSTNode<T> parent){
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(new BSTNode<T>());
		} else if (element.compareTo(node.getData())<0){
			insert((BSTNode<T>) node.getLeft(), element, node);
		} else if (element.compareTo(node.getData())>0){
			insert((BSTNode<T>) node.getRight(), element, node);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return this.maximum(this.root);
	}

	private BSTNode<T> maximum(BTNode<T> node){
		if(node.isEmpty()){
			return null;
		} else{
			while(!node.getRight().isEmpty()){
				node = node.getRight();
			}
			return (BSTNode<T>) node;
		}
	}

	@Override
	public BSTNode<T> minimum() {
		return this.minimum(this.root);
	}

	private BSTNode<T> minimum(BTNode<T> node){
		if(node.isEmpty()){
			return null;
		} else{
			while(!node.getLeft().isEmpty()){
				node = node.getLeft();
			}
			return (BSTNode<T>) node;
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
	
	@Override
	public T[] preOrder() {
		List<T> lista = new ArrayList<>(this.size());
		preOrder(lista, this.root);
		return lista.toArray((T[]) new Comparable[this.size()]);

	}

	private void preOrder(List<T> lista, BSTNode<T> node){
		if(!node.isEmpty()){
			lista.add(node.getData());
			preOrder(lista, (BSTNode<T>) node.getLeft());
			preOrder(lista, (BSTNode<T>) node.getRight());

		}

	}

	@Override
	public T[] order() {
		List<T> lista = new ArrayList<>(this.size());
		order(lista, this.root);
		return lista.toArray((T[]) new Comparable[this.size()]);
	}

	private void order(List<T> lista, BSTNode<T> node){
		if(!node.isEmpty()){
			order(lista, (BSTNode<T>) node.getLeft());
			lista.add(node.getData());
			order(lista, (BSTNode<T>) node.getRight());

		}

	}

	@Override
	public T[] postOrder() {
		List<T> lista = new ArrayList<>(this.size());
		postOrder(lista, this.root);
		return lista.toArray((T[]) new Comparable[this.size()]);
	}
	private void postOrder(List<T> lista, BSTNode<T> node){
		if(!node.isEmpty()){
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
