package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T>{
    public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2){

        SingleLinkedListNode<T> node = new SingleLinkedListNode<T>();
        SingleLinkedListNode<T> firstNode = new SingleLinkedListNode<T>();
        int size1 = size(node1);
		int size2 = size(node2);
        int i = 0;
        int j = 0;
        int iteracoes = 0;

		while (i <= size1 && j <= size2 && !node1.isNIL() && !node2.isNIL()) {
			if ((node1.getData()).compareTo(node2.getData())<=0) { 
				node.setData(node1.getData());
                node1 = node1.getNext();
                i++;
			} else {
				node.setData(node2.getData());
                node2 = node2.getNext();
                j++;
			}
            iteracoes ++;
            if(iteracoes==1){
                firstNode.setData(node.getData());
            }
            else if (iteracoes==2){
                firstNode.setNext(node);
            }
            node.setNext(new SingleLinkedListNode<T>());
            node = node.getNext();

		}
		while (i <= size1 && !node1.isNIL()) {
            node.setData(node1.getData());
            node1 = node1.getNext();
            node.setNext(new SingleLinkedListNode<T>());
            node = node.getNext();
            i++;
		}
		while (j <= size2 && !node2.isNIL()) {
            node.setData(node2.getData());
            node2 = node2.getNext();
            node.setNext(new SingleLinkedListNode<T>());
            node = node.getNext();
            j++;
		}
        return firstNode;

        
    }

    private int size(SingleLinkedListNode<T> node){
        int size = 0;
        SingleLinkedListNode<T> aux = node;
        while(!aux.isNIL()){
            aux = aux.getNext();
            size ++;
        }
        return size;
    }

}
