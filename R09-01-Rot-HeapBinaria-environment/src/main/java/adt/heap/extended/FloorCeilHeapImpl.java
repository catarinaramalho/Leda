package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer value : array)
			this.insert(value);

		return this.floor(numero, null);
	}

	private Integer floor(double number, Integer floor) {
		Integer root = this.extractRootElement();

		if (root != null)
			if (number >= root && (floor == null || root >= floor))
				floor = this.floor(number, root);
			else
				floor = this.floor(number, floor);

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer value : array)
			this.insert(value);

		return this.ceil(numero, null);
	}

	private Integer ceil(double number, Integer ceil) {
		Integer root = this.extractRootElement();

		if (root != null)
			if (number <= root && (ceil == null || root <= ceil))
				ceil = this.ceil(number, root);
			else
				ceil = this.ceil(number, ceil);

		return ceil;
	}

}
