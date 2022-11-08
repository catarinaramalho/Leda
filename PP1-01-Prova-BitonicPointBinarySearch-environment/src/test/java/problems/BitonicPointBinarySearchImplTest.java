package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BitonicPointBinarySearchImplTest {
    
    private Integer[] array;
    private BitonicPointBinarySearchImpl implementation;

    @Before
    public void upSet(){
        this.implementation = new BitonicPointBinarySearchImpl<Integer>();
    }

    @Test
    public void test01(){
        this.array = new Integer[] {7,12,16, 20, 30,4,2,1};
        assertEquals(this.implementation.bitonicPoint(this.array), (Integer)30);
    }

    @Test
    public void test02(){
        this.array = new Integer[] {30};
        assertEquals(this.implementation.bitonicPoint(this.array), (Integer)30);
    }

    @Test
    public void test03(){
        this.array = new Integer[] {0, 1, 2 , 3, 4, 30};
        assertEquals(this.implementation.bitonicPoint(this.array), (Integer)30);
    }

    @Test
    public void test04(){
        this.array = new Integer[] {30, 4, 3, 2 , 1, 0};
        assertEquals(this.implementation.bitonicPoint(this.array), (Integer)30);
    }

    @Test
    public void test05(){
        this.array = new Integer[] {0, 1, 20, 4, 3};
        assertEquals(this.implementation.bitonicPoint(this.array), (Integer)20);
    }

    @Test
    public void test06(){
        this.array = null;
        assertEquals(this.implementation.bitonicPoint(this.array), null);
    }

    @Test
    public void test07(){
        this.array = new Integer[] {};
        assertEquals(this.implementation.bitonicPoint(this.array), null);
    }

}
