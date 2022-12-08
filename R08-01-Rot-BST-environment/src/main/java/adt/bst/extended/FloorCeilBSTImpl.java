package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		if (array != null && array.length > 0) {
			for (Integer valor : array) {
				this.insert(valor);
			}
			floor = this.floor(this.root, numero, null);
		}
		return floor;

	}

	private Integer floor(BSTNode<Integer> node, double numero, Integer floor) {
		if (!node.isEmpty()) {
			if (numero < node.getData()) {
				floor = this.floor((BSTNode<Integer>) node.getLeft(), numero, floor);
			} else if (numero > node.getData()) {
				floor = this.floor((BSTNode<Integer>) node.getRight(), numero, node.getData());
			} else {
				floor = node.getData();
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		if (array != null && array.length > 0) {
			for (Integer valor : array) {
				this.insert(valor);
			}
			ceil = this.ceil(this.root, numero, null);
		}
		return ceil;
	}

	private Integer ceil(BSTNode<Integer> node, double numero, Integer ceil) {
		if (!node.isEmpty()) {
			if (numero < node.getData()) {
				ceil = this.ceil((BSTNode<Integer>) node.getLeft(), numero, node.getData());
			} else if (numero > node.getData()) {
				ceil = this.ceil((BSTNode<Integer>) node.getRight(), numero, ceil);
			} else {
				ceil = node.getData();
			}
		}
		return ceil;
	}

}
