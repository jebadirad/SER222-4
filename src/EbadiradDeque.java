import java.util.NoSuchElementException;

/**
 * This program provides an implementation of the Deque interface
 *
 * @author JonDavid Ebadirad
 * @version 1.0
 */
public class EbadiradDeque<T> implements Deque<T> {






    //front of the dequeue
    private Node<T> front;
    //back of the dequeue.
    private Node<T> back;
    //size of the dequeue.
    private int size;

    public EbadiradDeque(){
        front = null;
        back = null;
        size = 0;
    }
    public EbadiradDeque(T element){
        Node<T> temp = new Node<T>(element);
        front = temp;
        back = temp;
        size = 1;
    }
    /**
     * Adds one element to the front of this deque.
     *
     * @param element the element to be added to the front of the deque
     */
    @Override
    public void enqueueFront(T element) {
        Node<T> temp = front;
        Node<T> newEl = new Node<T>(element);
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
    public void enqueueBack(T element) {
        Node<T> temp = back;
        Node<T> newEl = new Node<T>(element);
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
    public T dequeueFront() throws NoSuchElementException {
        if(size == 0){
            throw new NoSuchElementException("Deque is empty");
        }else{
           Node<T> temp = front;
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
    public T dequeueBack() throws NoSuchElementException {
        if(size == 0){
            throw new NoSuchElementException("Deque is empty");
        }else{
            Node<T> temp = back;
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
    public T first() throws NoSuchElementException {
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
    public T last() throws NoSuchElementException {
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
    public boolean contains(T element) {
        boolean found = false;
        if(size > 0){
            Node<T> temp = front;
            Node<T> tempBack = back;
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
           Node<T> temp = back;
           while(temp != null){
               printed += temp.getElement().toString() + " ";
               temp = temp.getNext();
           }
        }


        return printed.trim();


    }
}
