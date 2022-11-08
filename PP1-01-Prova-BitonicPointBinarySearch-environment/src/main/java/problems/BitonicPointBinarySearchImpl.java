package problems;

public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T>{

    @Override
    public T bitonicPoint(T[] array) {
      if (array == null || array.length<=0){
        return null;
      }
      return bitonicPointRecursivo(array, 0, array.length-1);
    }

    private T bitonicPointRecursivo(T[] array, int leftIndex, int rightIndex){
      if (leftIndex == rightIndex){
        return array[leftIndex];
      }else if(leftIndex < rightIndex && array[leftIndex].compareTo(array[leftIndex+1])>0){
        return array[leftIndex];
      }
      return bitonicPointRecursivo(array, leftIndex + 1, rightIndex);

    }

}