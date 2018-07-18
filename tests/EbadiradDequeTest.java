import static org.junit.Assert.*;
import java.util.NoSuchElementException;
/**
 * Unit testing for my deque ADT
 *
 * @author JonDavid Ebadirad
 * @version 1.0
 */
public class EbadiradDequeTest {
    Deque<Integer> testDeque = new EbadiradDeque<Integer>();

    /**
     * Used to test the constructor that takes an element.
     *
     */
    @org.junit.Test
    public void constructorElementTest(){
        Deque<Integer> prefilled = new EbadiradDeque<Integer>(0);
        assertEquals(1, prefilled.size());
        assertEquals((Integer)0, prefilled.first());
        assertEquals((Integer)0, prefilled.last());

    }

    /**
     * test the enqueuFront method
     */
    @org.junit.Test
    public void enqueueFront() {
        testDeque.enqueueFront(0);
        testDeque.enqueueFront(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueFront(3);
        testDeque.enqueueFront(4);
        assertEquals((Integer) 4, testDeque.first());
        assertEquals((Integer) 0, testDeque.last());

    }

    /**
     * test the enqueuback method
     */
    @org.junit.Test
    public void enqueueBack() {
        testDeque.enqueueBack(0);
        testDeque.enqueueBack(1);
        testDeque.enqueueBack(2);
        testDeque.enqueueBack(3);
        testDeque.enqueueBack(4);
        assertEquals((Integer)4, testDeque.last());
        assertEquals((Integer)0, testDeque.first());
    }

    /**
     * a more real world test, used to test both enqueue front and back
     *
     */
    @org.junit.Test
    public void enqueueMix(){
        testDeque.enqueueFront(0);
        testDeque.enqueueBack(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueBack(3);
        testDeque.enqueueFront(4);
        testDeque.enqueueBack(5);
        assertEquals(((Integer)6).intValue(), testDeque.size());
        assertEquals((Integer)4, testDeque.first());
        assertEquals((Integer)5, testDeque.last());

    }

    /**
     * test the dequeue front method
     */
    @org.junit.Test
    public void dequeueFront() {
        testDeque.enqueueFront(0);
        testDeque.enqueueFront(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueFront(3);
        testDeque.enqueueFront(4);
        assertEquals(5, testDeque.size());
        assertEquals((Integer)4, testDeque.dequeueFront());
        assertEquals(4, testDeque.size());
        assertEquals((Integer)3, testDeque.dequeueFront());
        assertEquals(3, testDeque.size());
    }

    /**
     * used to test if dequeuefront will throw an exception on a new
     * and empty dequeue
     */
    @org.junit.Test(expected = NoSuchElementException.class)
    public void dequeueFrontEmpty() {
        assertEquals(0, testDeque.size());
        testDeque.dequeueFront();
    }

    /**
     * used to test if the dequeuefront method will throw an exception
     * when we remove all the elements in the dequeue.
     */
    @org.junit.Test(expected = NoSuchElementException.class)
    public void dequeueFrontThrow() {
        assertEquals(0, testDeque.size());
        testDeque.enqueueBack(0);
        testDeque.enqueueBack(0);
        testDeque.enqueueBack(0);
        testDeque.dequeueFront();
        testDeque.dequeueFront();
        testDeque.dequeueFront();
        testDeque.dequeueFront();
    }

    /**
     * used to test the dequeueback method.
     */
    @org.junit.Test
    public void dequeueBack() {
        testDeque.enqueueFront(0);
        testDeque.enqueueFront(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueFront(3);
        testDeque.enqueueFront(4);
        assertEquals(5, testDeque.size());
        assertEquals((Integer)0, testDeque.dequeueBack());
        assertEquals(4, testDeque.size());
        assertEquals((Integer)1, testDeque.dequeueBack());
        assertEquals(3, testDeque.size());
    }

    /**
     * used to test a newly created dequeue if it will throw an
     * exception when it is empty and we call dequeueback.
     */
    @org.junit.Test(expected = NoSuchElementException.class)
    public void dequeueBackEmpty() {
        assertEquals(0, testDeque.size());
        testDeque.dequeueBack();
    }

    /**
     * used to test a dequeue after we call dequeueback until it is empty
     */
    @org.junit.Test(expected = NoSuchElementException.class)
    public void dequeueBackThrow() {
        assertEquals(0, testDeque.size());
        testDeque.enqueueBack(0);
        testDeque.enqueueBack(0);
        testDeque.enqueueBack(0);
        testDeque.dequeueBack();
        testDeque.dequeueBack();
        testDeque.dequeueBack();
        testDeque.dequeueBack();
    }

    /**
     * test the first method.
     */
    @org.junit.Test
    public void first() {
        testDeque.enqueueFront(0);
        testDeque.enqueueBack(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueBack(3);
        testDeque.enqueueFront(4);
        testDeque.enqueueBack(5);
        assertEquals((Integer) 4, testDeque.first());
    }

    /**
     *
     * test the first method to see if it will throw an exception if
     * the dequeue is empty.
     */
    @org.junit.Test(expected = NoSuchElementException.class)
    public void firstEmpty(){
        testDeque.first();
    }

    /**
     * test the last method.
     */
    @org.junit.Test
    public void last() {
        testDeque.enqueueFront(0);
        testDeque.enqueueBack(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueBack(3);
        testDeque.enqueueFront(4);
        testDeque.enqueueBack(5);
        assertEquals((Integer)5, testDeque.last());
    }
    /**
     * test the last method to see if it will throw an exception if the
     * dequeue is empty.
     */
    @org.junit.Test(expected = NoSuchElementException.class)
    public void lastEmpty(){
        testDeque.last();
    }

    /**
     * test the contains method in a variety of ways.
     */
    @org.junit.Test
    public void contains() {
        testDeque.enqueueFront(0);
        testDeque.enqueueBack(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueBack(3);
        testDeque.enqueueFront(4);
        testDeque.enqueueBack(5);
        assertFalse(testDeque.contains(6));
        assertTrue(testDeque.contains(5));
        assertTrue(testDeque.contains(3));
        assertTrue(testDeque.contains(4));
        assertTrue(testDeque.contains(2));
        assertTrue(testDeque.contains(1));
        assertTrue(testDeque.contains(0));
        assertFalse(testDeque.contains(-1));
        testDeque.enqueueBack(6);
        assertTrue(testDeque.contains(6));
    }

    /**
     * test the isempty method.
     */
    @org.junit.Test
    public void isEmpty() {
        assertTrue(testDeque.isEmpty());
        testDeque.enqueueBack(1);
        assertFalse(testDeque.isEmpty());
    }

    /**
     * test the size method
     */
    @org.junit.Test
    public void size() {
        assertEquals(0, testDeque.size());
        testDeque.enqueueFront(0);
        testDeque.enqueueBack(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueBack(3);
        testDeque.enqueueFront(4);
        testDeque.enqueueBack(5);
        assertEquals(6, testDeque.size());
    }

    /**
     * test the toString method. 
     */
    @org.junit.Test
    public void toStringTest() {
        assertEquals("empty", testDeque.toString());
        testDeque.enqueueBack(0);
        assertEquals("0", testDeque.toString());
        testDeque.enqueueBack(1);
        testDeque.enqueueBack(2);
        testDeque.enqueueBack(3);
        assertEquals("3 2 1 0" , testDeque.toString());
        testDeque.enqueueFront(1);
        assertEquals("3 2 1 0 1" , testDeque.toString());
        testDeque.enqueueBack(4);
        testDeque.enqueueFront(5);
        testDeque.enqueueBack(6);
        testDeque.enqueueFront(7);
        assertEquals("6 4 3 2 1 0 1 5 7" , testDeque.toString());
    }

    @org.junit.Test
    public void frontToBack(){
        testDeque.enqueueFront(0);
        testDeque.enqueueBack(1);
        testDeque.enqueueFront(2);
        testDeque.enqueueBack(3);
        testDeque.enqueueFront(4);
        testDeque.enqueueBack(5);
        //4 2 0 1 3 5
        String result = "4 2 0 1 3 5";
        String frontToBack = "";
        while(testDeque.size() > 0){
            frontToBack += testDeque.dequeueFront().toString() + " ";
        }
        frontToBack = frontToBack.trim();
        assertEquals(result, frontToBack);
    }
   
}