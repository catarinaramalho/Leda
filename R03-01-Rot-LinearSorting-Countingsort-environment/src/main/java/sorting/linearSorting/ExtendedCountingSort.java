package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			int maior = maior(array, leftIndex, rightIndex);
			int menor = menor(array, leftIndex, rightIndex);

			int[] C = new int[maior - menor + 1];

			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i] - menor] += 1;
			}

			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			int[] B = new int[rightIndex - leftIndex + 1];

			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i] - menor] - 1] = array[i];
				C[array[i] - menor] -= 1;
			}

			int indice = 0;
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[indice];
				indice++;

			}
		}
		
	}

	private int maior(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

	private int menor(Integer[] array, int leftIndex, int rightIndex) {
		int menor = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}

}
