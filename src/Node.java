public class Node<T> {
     private Node<T> next;
     private Node<T> prev;
     private T element;

     public Node(){
         next = null;
         prev = null;
    }
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
