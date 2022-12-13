package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return this.bst.isEmpty() || this.isBST(this.bst.getRoot());
	}

	private boolean isBST (BTNode<T> node){
		boolean verify = true;

	    if (!node.isEmpty()) {
            if (this.isValidLeft(node) && this.isValidRight(node)) {
                verify = this.isBST(node.getLeft()) && this.isBST(node.getRight());
			}else{
                verify = false;
			}

		}return verify;
	}

	private boolean isValidLeft (BTNode<T> node) {
        return this.isValidLeft(node.getLeft(), node);
    }

    private boolean isValidLeft (BTNode<T> node, BTNode<T> root) {
        boolean verify = true;

        if (!node.isEmpty()){
            if (node.getData().compareTo(root.getData()) < 0){
                verify = this.isValidLeft(node.getLeft(), root) && this.isValidLeft(node.getRight(), root);
			}else{
                verify = false;

			}
		}
		return verify;

	}

    private boolean isValidRight (BTNode<T> node) {
        return this.isValidRight(node.getRight(), node);
    }

    private boolean isValidRight (BTNode<T> node, BTNode<T> root) {
        boolean verify = true;

        if (!node.isEmpty()) {
            if (node.getData().compareTo(root.getData()) > 0) {
                verify = this.isValidRight(node.getLeft(), root) && this.isValidRight(node.getRight(), root);
			}else{
                verify = false;

			}
		}return verify;
    }
	
}
