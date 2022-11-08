package problems;

/**
 * Interface que representa uma busca binária em um array Bitônico.
 * 
 * Um array Bitônico é um array podendo conter duas partições: uma ordenada
 * de forma crescente (sempre vem primeiro) e outra ordenada de forma decrescente.
 * O ponto bitônico desse array é o maior valor que divide essas duas partições.
 * 
 * Por exemplo:
 * O ponto bitônico do array [7,12,16, 20, 7,4,2,1] é o 20, pois do início até ele
 * tem-se os elementos em ordem crescente e apos ele tem-se os elementos em ordem
 * decrescente.
 * 
 * Pode acontecer de uma das partições (crescente ou decrescente) não exista no array
 * mas o ponto bitônico sempre será o elemento de maior valor.
 */
public interface BitonicPointBinarySearch<T extends Comparable<T>> {
    /**
     * Método para encontrar o ponto bitônico de um array usando a estratégia 
     * de busca binária.
     * 
     * Restrições:
     * - Seu algoritmo teve ser O(log n)
     * - Você não pode usar memória extra (a não ser variáveis simples). Arrays
     *   auxiliares ou qualquer tipo de coleção são proibidos
     * - Voce deve usar a estratégia de busca binária e RECURSÃO
     * 
     * @param array um array bitônico
     * @return o ponto bitônico do array. Caso o array não tenha elementos, retorna null
     */
    public T bitonicPoint(T[] array);
}
