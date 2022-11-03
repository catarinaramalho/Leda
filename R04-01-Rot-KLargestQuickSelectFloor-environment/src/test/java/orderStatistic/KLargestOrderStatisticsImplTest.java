package orderStatistic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KLargestOrderStatisticsImplTest {
    private KLargestOrderStatisticsImpl<Integer> implementacao;
    private Integer[] array;
   
    @Before
    public void setUp() {
        this.implementacao = new KLargestOrderStatisticsImpl<>();
        this.array = new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 };
    }
    // Testes do Método OrderStatistic
    // Testes de casos válidos
    @Test
    public void testOrderStatistics1() {
        assertEquals(this.implementacao.orderStatistics(this.array, 1), (Integer)4);
    }

    @Test
    public void testOrderStatistics2() {
        assertEquals(this.implementacao.orderStatistics(this.array, 2), (Integer)10);
    }

    @Test
    public void testOrderStatistics3() {
        assertEquals(this.implementacao.orderStatistics(this.array, 5), (Integer)13);
    }
    // Teste com array nulo
    @Test
    public void testOrderStatistics4() {
        assertEquals(this.implementacao.orderStatistics(null, 5), null);
    }
    // Teste com k >= tamanho do array
    @Test
    public void testOrderStatistics5() {
        assertEquals(this.implementacao.orderStatistics((this.array),11), null);
    }
    // Teste com k < 0 
    @Test
    public void testOrderStatistics6() {
        assertEquals(this.implementacao.orderStatistics((this.array),-1), null);
    }
    // Teste com array vazio 
    @Test
    public void testOrderStatistics7() {
        assertEquals(this.implementacao.orderStatistics( new Integer[] {},5), null);
    }

    //Testes do método getKLargest

    //Testes de casos Válidos - VERIFICAR ORDEM???
    @Test
    public void testGetKLargest1() {
        assertArrayEquals(this.implementacao.getKLargest(this.array, 2),new Integer[] {40,45});
    }
    @Test
    public void testGetKLargest2() {
        assertArrayEquals(this.implementacao.getKLargest(this.array, 3),new Integer[] {21,40,45});
    }
    // Teste com array nulo
    @Test
    public void testGetKLargest3() {
        assertArrayEquals(this.implementacao.getKLargest(null, 5), new Integer[] {});
    }
    // Teste com k >= tamanho do array
    @Test
    public void testGetKLargest4() {
        assertArrayEquals(this.implementacao.getKLargest((this.array),11), new Integer[] {});
    }
    // Teste com k < 0 
    @Test
    public void testGetKLargest5() {
        assertArrayEquals(this.implementacao.getKLargest((this.array),-1), new Integer[] {});
    }
    // Teste com array vazio 
    @Test
    public void testGetKLargest6() {
        assertArrayEquals(this.implementacao.getKLargest( new Integer[] {},5), new Integer[] {});
    }



}


