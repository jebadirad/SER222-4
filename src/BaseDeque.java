/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it. I just copied the code from my implementation into this
 * class in order to get it to compile. 
 *
 * @author JonDavid Ebadirad, Acuna
 * @version 1.0
 */
import java.util.NoSuchElementException;

public class BaseDeque<Item> implements Deque<Item> {
    private Node<Item> front;
    private Node<Item> back;
    private int size;
    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        BaseDeque<Integer> deque = new BaseDeque<Integer>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        //deque features
        System.out.println(deque.dequeueFront());
        deque.enqueueFront(1);
        deque.enqueueFront(11);
        deque.enqueueFront(3);
        deque.enqueueFront(5);
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());
        System.out.println(deque.last());
        deque.dequeueFront();
        deque.dequeueFront();
        System.out.println(deque.first());
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());
    }

    /**
     * Adds one element to the front of this deque.
     *
     * @param element the element to be added to the front of the deque
     */
    @Override
    public void enqueueFront(Item element) {
        Node<Item> temp = front;
        Node<Item> newEl = new Node<Item>(element);
        front = newEl;
        newEl.setPrev(temp);
        if(null != temp){
            temp.setNext(front);
        }else{
            back = newEl;
        }
        size ++;
    }

    /**
     * Adds one element to the back of this deque.
     *
     * @param element the element to be added to the back of the deque
     */
    @Override
    public void enqueueBack(Item element) {
        Node<Item> temp = back;
        Node<Item> newEl = new Node<Item>(element);
        back = newEl;
        newEl.setNext(temp);
        if(null != temp){
            temp.setPrev(newEl);
        }else{
            front = newEl;
        }
        size ++;
    }

    /**
     * Removes and returns the element at the front of this deque.
     * Throws an exception if the deque is empty.
     *
     * @return the element at the front of this deque
     * @throws NoSuchElementException if the deque is empty
     */
    @Override
    public Item dequeueFront() throws NoSuchElementException {
        if(size == 0){
            throw new NoSuchElementException("Deque is empty");
        }else{
            Node<Item> temp = front;
            front = front.getPrev();
            if(null != front){
                front.setNext(null);
            }
            size --;
            return temp.getElement();
        }

    }

    /**
     * Removes and returns the element at the back of this deque.
     * Throw an exception if the deque is empty.
     *
     * @return the element at the back of the deque.
     * @throws NoSuchElementException if the deque is empty
     */
    @Override
    public Item dequeueBack() throws NoSuchElementException {
        if(size == 0){
            throw new NoSuchElementException("Deque is empty");
        }else{
            Node<Item> temp = back;
            back = back.getNext();
            if(null != back){
                back.setPrev(null);
            }
            size --;
            return temp.getElement();
        }
    }

    /**
     * Returns, without removing, the element at the front of this deque.
     * Should throw an exception if the deque is empty.
     *
     * @return the first element in the deque
     * @throws NoSuchElementException if the deque is empty
     */
    @Override
    public Item first() throws NoSuchElementException {
        if(size == 0){
            throw new NoSuchElementException("Deque is empty");
        }else{
            return front.getElement();
        }
    }

    /**
     * Returns, without removing, the element at the back of this deque.
     * Should throw an exception if the deque is empty.
     *
     * @return the last element in the deque
     * @throws NoSuchElementException if the deque is empty
     */
    @Override
    public Item last() throws NoSuchElementException {
        if(size == 0){
            throw new NoSuchElementException("Deque is empty");
        }else{
            return back.getElement();
        }
    }

    /**
     * Returns true if a given element exists inside the deque, false
     * otherwise.
     *
     * @param element
     * @return if element exists in list
     */
    @Override
    public boolean contains(Item element) {
        boolean found = false;
        if(size > 0){
            Node<Item> temp = front;
            Node<Item> tempBack = back;
            for(int i = 0; i < size/2; i ++){
                if(temp.getElement().equals(element)){
                    found = true;
                    break;
                }else if(tempBack.getElement().equals(element)){
                    found = true;
                    break;
                }
                else{
                    temp = temp.getPrev();
                    tempBack = tempBack.getNext();
                }
            }
        }
        return found;

    }

    /**
     * Returns true if this deque is empty and false otherwise.
     *
     * @return if deque empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in the deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this deque. The back element
     * occurs first, and each element is separated by a space. If the
     * deque is empty, returns "empty".
     *
     * @return the string representation of the deque
     */
    @Override
    public String toString() {
        String printed = "empty";
        if(size > 0){
            printed = "";
            Node<Item> temp = back;
            while(temp != null){
                printed += temp.getElement().toString() + " ";
                temp = temp.getNext();
            }
        }


        return printed.trim();


    }
}
