import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class OrdenadoresTest {
    private Integer[] vetor;

    private Ordenadores<Integer> implementation;

    @Before
    public void setUp() {
        this.vetor = new Integer[] { 5, 4, 1, 2 };
        this.implementation = new Ordenadores<Integer>();
    }

    @Test
    public void testOrdenador01() {
        this.implementation.bubbleSort(this.vetor, 0, 3);
        assertArrayEquals(new Integer[] { 1, 2, 4, 5 }, this.vetor);
    }

    @Test
    public void testOrdenador02() {
        this.implementation.bubbleSortRecursivo(this.vetor, 0, 3);
        assertArrayEquals(new Integer[] { 1, 2, 4, 5 }, this.vetor);
    }

    @Test
    public void testOrdenador03() {
        this.implementation.selectionSort(this.vetor, 0, 3);
        assertArrayEquals(new Integer[] { 1, 2, 4, 5 }, this.vetor);
    }

    @Test
    public void testOrdenador04() {
        this.implementation.selectionSortRecursivo(this.vetor, 0, 3);
        assertArrayEquals(new Integer[] { 1, 2, 4, 5 }, this.vetor);
    }

    @Test
    public void testOrdenador05() {
        this.implementation.insertionSort(this.vetor, 0, 3);
        assertArrayEquals(new Integer[] { 1, 2, 4, 5 }, this.vetor);
    }

    @Test
    public void testOrdenador06() {
        this.implementation.insertionSortRecursivo(this.vetor, 0, 3);
        assertArrayEquals(new Integer[] { 1, 2, 4, 5 }, this.vetor);
    }
}
