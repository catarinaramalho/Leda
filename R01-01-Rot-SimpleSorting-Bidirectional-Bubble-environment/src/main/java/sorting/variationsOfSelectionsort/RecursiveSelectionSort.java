package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex+1 == leftIndex){
            return;
        }  
        int indexMenor = leftIndex;
        for (int j = indexMenor+1; j < rightIndex+1; j++) {
            if (array[j].compareTo(array[indexMenor])<0){
                indexMenor = j;
            }
        }
		Util.swap(array, leftIndex, indexMenor);
        sort(array, leftIndex+1,rightIndex);
	}

}
