public class Ordenadores<T extends Comparable<T>> {
    // TROCAS
    private void swap(T[] array, int i, int j) {
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;

    }

    // BUBLLE SORT
    public void bubbleSort(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int i = leftIndex; i < rightIndex; i++) {
                    if (array[i].compareTo(array[i + 1]) > 0) {
                        this.swap(array, i, i + 1);
                        swapped = true;
                    }
                }
            }

        }

    }

    public void bubbleSortRecursivo(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    this.swap(array, i, i + 1);
                }
            }
            bubbleSortRecursivo(array, leftIndex, rightIndex - 1);
        }

    }

    // SELECTION SORT
    public void selectionSort(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                int indiceMenor = i;
                for (int j = i + 1; j <= rightIndex; j++) {
                    if (array[j].compareTo(array[indiceMenor]) < 0) {
                        indiceMenor = j;
                    }
                }
                swap(array, i, indiceMenor);
            }

        }

    }

    public void selectionSortRecursivo(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            int indiceMenor = leftIndex;
            for (int j = leftIndex + 1; j <= rightIndex; j++) {
                if (array[j].compareTo(array[indiceMenor]) < 0) {
                    indiceMenor = j;
                }
            }
            swap(array, leftIndex, indiceMenor);
            selectionSortRecursivo(array, leftIndex + 1, rightIndex);
        }

    }

    // Insertion SORT
    public void insertionSort(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            for (int i = leftIndex + 1; i <= rightIndex; i++) {
                int j = i;
                while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j, j - 1);
                    j--;
                }

            }

        }

    }

    public void insertionSortRecursivo(T[] array, int leftIndex, int rightIndex) {
        if (array.length != 0 && array != null && leftIndex >= 0 && leftIndex < rightIndex
                && rightIndex < array.length) {
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                }

            }
            insertionSortRecursivo(array, leftIndex, rightIndex - 1);

        }

    }

}
