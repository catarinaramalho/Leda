package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		if (array != null && array.length > 0 && x != null) {
			quickSort(array, 0, array.length - 1);
			return floorRecursivo(array, x, null, 0, array.length - 1);
		}
		return null;
	}

	private Integer floorRecursivo(Integer[] array, Integer x, Integer floor, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && leftIndex <= rightIndex && rightIndex < array.length) {

			int meio = (rightIndex + leftIndex) / 2;

			if (array[meio].compareTo(x) == 0) {
				return array[meio];
			}

			if (array[meio].compareTo(x) > 0) {
				return floorRecursivo(array, x, floor, leftIndex, meio - 1);
			}

			if (array[meio].compareTo(x) < 0) {
				return floorRecursivo(array, x, array[meio], meio + 1, rightIndex);
			}

		}
		return floor;
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {

		int pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i += 1;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex, i);

		return i;
	}

	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			int indexPivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, indexPivot - 1);
			quickSort(array, indexPivot + 1, rightIndex);
		}
	}

}
