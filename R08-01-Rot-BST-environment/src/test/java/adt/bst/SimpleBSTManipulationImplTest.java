package adt.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationImplTest {

    private SimpleBSTManipulationImpl<Integer> implementation;

    @Before
    public void setUp() {
        implementation = new SimpleBSTManipulationImpl<>();
    }

    private BSTImpl<Integer> fillTree(Integer[] array) {
        BSTImpl<Integer> tree = new BSTImpl<>();
        for (int i : array) {
            tree.insert(i);
        }
        return tree;
    }

    @Test
    public void testEquals01() {
        BSTImpl<Integer> tree1 = null;
        BSTImpl<Integer> tree2 = null;
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void testEquals02() {
        BSTImpl<Integer> tree1 = new BSTImpl<Integer>();
        BSTImpl<Integer> tree2 = new BSTImpl<Integer>();
        assertTrue(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void testEquals03() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertTrue(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void testEquals04() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 10, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void testEquals05() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = this.fillTree(new Integer[] { -40 });
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void testEquals06() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = this.fillTree(new Integer[] { 6, 23 });
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void testEquals07() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = this.fillTree(new Integer[] { 5, 22, -35, 4, 8, 1, -1, 75, 11, 66, 231, -41 });
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void testIsSimilar01() {
        BSTImpl<Integer> tree1 = null;
        BSTImpl<Integer> tree2 = null;
        assertFalse(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void testIsSimilar02() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        BSTImpl<Integer> tree2 = new BSTImpl<>();
        assertTrue(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void testIsSimilar03() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertTrue(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void testIsSimilar04() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23 });
        BSTImpl<Integer> tree2 = this.fillTree(new Integer[] { 79, 745 });
        assertTrue(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void testIsSimilar05() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = this.fillTree(new Integer[] { 5, 22, -35, 4, 8, 1, -1, 75, 11, 66, 231, -41 });
        assertTrue(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void testOrderStatistic01() {
        BSTImpl<Integer> tree1 = null;
        assertNull(this.implementation.orderStatistic(tree1, 1));
    }

    @Test
    public void testOrderStatistic02() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertNull(this.implementation.orderStatistic(tree1, 0));
    }

    @Test
    public void testOrderStatistic03() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertNull(this.implementation.orderStatistic(tree1, 13));
    }

    @Test
    public void testOrderStatistic04() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertEquals((Integer) Integer.parseInt("-40"), this.implementation.orderStatistic(tree1, 1));
    }

    @Test
    public void testOrderStatistic05() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertEquals((Integer) Integer.parseInt("-34"), this.implementation.orderStatistic(tree1, 2));
    }

    @Test
    public void testOrderStatistic06() {
        BSTImpl<Integer> tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertEquals((Integer) Integer.parseInt("232"), this.implementation.orderStatistic(tree1, 12));
    }
}
