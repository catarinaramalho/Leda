package problems;

import adt.linkedList.SingleLinkedListNode;

/**
 * Classe contendo metodo utilitario para fazer o merge de duas listas
 * simplesmente ligadas já ordenadas a partir de seus primeiros nós (heads).
 */
public interface LinkedListMerge<T extends Comparable<T>> {

    /**
     * Metodo para retorna uma nova lista ordenada, resultante do merge de duas outras
     * listas ordenadas. O algoritmo retorna um nó (head) da nova lista ligada construída
     * a partir dos nós (heads) de duas listas passadas como parametro.
     * 
     * Restricoes:
     * - Voce não pode usar nenhuma outra estrutura auxiliar.
     * - Voce não pode converter as listas em coleção e depois operar as coleções
     * - Seu algoritmo tem que ser estritamente O(N+M) onde N é o tamanho da lista 1 
     *   (cujo head é node1) e M é o tamanho da lista 2 (cujo head é node2) 
     * - Seu algoritmo não pode ter performance O(k(N+M)), onde k > 1.
     * - As listas passadas como parâmetro NÃO possuem elementos em comum
     * 
     * @param node1 o primeiro nó da primeira lista. A lista já está ordenada
     * @param node2 o primeiro nó da segunda lista. A lista já está ordenada
     * @return o primeiro nó de uma lista resultante do merge de node1 com node2
     */
    public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2);
}
