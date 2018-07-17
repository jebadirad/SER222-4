/**
 * The node element that is used in our dequeue
 *
 * @author JonDavid Ebadirad
 * @version 1.0
 */
public class Node<T> {
     private Node<T> next;
     private Node<T> prev;
     private T element;
    public Node(T element){
         this.element = element;
         next = null;
         prev = null;
    }
    public void setNext(Node<T> next){
         this.next = next;
    }
    public void setPrev(Node<T> prev){
         this.prev = prev;
    }
    public Node<T> getNext(){

         return next;
    }
    public Node<T> getPrev(){
         return prev;
    }
    public T getElement(){
         return element;
    }

}
