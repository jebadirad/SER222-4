/**
 * Executes the actual functionality of the application for testing.
 *
 * @author JonDavid Ebadirad
 * @version 1.0
 */
public class EbadiradDequeueMain {

    public static void main(String[] args){
        Deque<Integer> testDeq = new EbadiradDeque<Integer>(0);
        testDeq.enqueueFront(1);
        testDeq.enqueueFront(2);
        testDeq.enqueueFront(3);
        testDeq.enqueueBack(4);
        testDeq.enqueueBack(5);
        testDeq.enqueueBack(6);
        testDeq.enqueueFront(7);
        System.out.println("Testing adding to front and back");
        System.out.println("Expected: 6 5 4 0 1 2 3 7");
        System.out.println("Actual  : " + testDeq.toString());
        System.out.println("Testing removing 2 from front, and 2 from back");
        System.out.println("Removing " + testDeq.dequeueFront());
        System.out.println("Removing " + testDeq.dequeueBack());
        System.out.println("Removing " + testDeq.dequeueBack());
        System.out.println("Removing " + testDeq.dequeueFront());
        System.out.println("Expected: 4 0 1 2");
        System.out.println("Actual  : " + testDeq.toString());
        System.out.println("Checking front and back");
        System.out.println("Expected: 2 and 4");
        System.out.println("Actual  : " + testDeq.first() + " and " + testDeq.last());
        System.out.println("Adding elements to front: 9 8 7");
        testDeq.enqueueFront(9);
        testDeq.enqueueFront(8);
        testDeq.enqueueFront(7);
        System.out.println("Expected Front: 7");
        System.out.println("Actual front  : " + testDeq.first());
        System.out.println("Expected Back: 4");
        System.out.println("Actual back  : " + testDeq.last());
        System.out.println("Testing Contains");
        System.out.println("Does this contain 5?");
        System.out.println("Expected: false. Actual : " + testDeq.contains(5));
        System.out.println("Does this contain 7?");
        System.out.println("Expected: true. Actual : " + testDeq.contains(7));
        System.out.println("Does this contain -32?");
        System.out.println("Expected: false. Actual : " + testDeq.contains(-32));
        System.out.println("Does this contain 1?");
        System.out.println("Expected: true. Actual : " + testDeq.contains(1));
        System.out.println("Is this empty?");
        System.out.println("Expected: false. Actual: " + testDeq.isEmpty());
        System.out.println("Expected Size: 7");
        System.out.println("Actual Size  : " + testDeq.size());
        System.out.println("Final output : 4 0 1 2 9 8 7");
        System.out.println("Actual output: " + testDeq.toString());
    }
}
