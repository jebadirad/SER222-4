import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class EbadiradDequeTest {
    Deque<Integer> testDeque = new EbadiradDeque<Integer>();

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
    @org.junit.Test(expected = NoSuchElementException.class)
    public void dequeueFrontEmpty() {
        assertEquals(0, testDeque.size());
        testDeque.dequeueFront();
    }
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
    @org.junit.Test(expected = NoSuchElementException.class)
    public void dequeueBackEmpty() {
        assertEquals(0, testDeque.size());
        testDeque.dequeueBack();
    }
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
    @org.junit.Test(expected = NoSuchElementException.class)
    public void firstEmpty(){
        testDeque.first();
    }

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
    @org.junit.Test(expected = NoSuchElementException.class)
    public void lastEmpty(){
        testDeque.last();
    }

    @org.junit.Test
    public void contains() {
    }

    @org.junit.Test
    public void isEmpty() {
    }

    @org.junit.Test
    public void size() {
    }

    @org.junit.Test
    public void toStringTest() {
        assertTrue(true);
    }
}