/* *****************************************************************************
 *  Name: Carlos A. Torres
 *  NetID: carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Partner Name:
 *  Partner NetID:
 *  Partner Precept:
 *
 *  Description:  This is a template file for RingBuffer.java. It lists the
 *                constructors and methods you need, along with descriptions
 *                of what they're supposed to do.
 *
 *                Note: it won't compile until you fill in the constructors
 *                and methods (or at least commment out the ones whose return
 *                type is non-void).
 *
 **************************************************************************** */

public class RingBuffer {
    // YOUR INSTANCE VARIABLES HERE
    private double[] data;  // array of numbers in the ring
    private int first;      // index of the least recently inserted item
    private int last;       // index one beyond the most recently inserted item.
    private int size;      // current amount of spaces in the buffer ocupied

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        data = new double[capacity];
        first = 0;
        last = 0;
        size = 0;
    }

    // return the capacity of this ring buffer
    public int capacity() {
        return data.length;
    }

    // return number of items currently in this ring buffer
    public int size() {
        return size;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        return (size == 0);
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        return (size == this.capacity());
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        if (this.isFull()) {
            throw new RuntimeException("Cannot enqueue a full ring Buffer");
        }
        data[first] = x;
        size++;
        first++;
        if (first == this.capacity()) {
            first = 0;
        }
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Cannot dequeue an empty ring Buffer");
        }
        double deleted = data[last];
        data[last] = 0.0;
        last++;
        size--;
        if (last == this.capacity()) {
            last = 0;
        }
        return deleted;
    }


    // returns the item at the front of this ring buffer
    public double peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Cannot peek at an empty ring Buffer");
        }
        return data[last];
    }

    // prints out variables of the item (used for testing)
    private void print() {
        for (int i = 0; i < this.capacity(); i++) {
            System.out.println(this.data[i] + " ");
        }
        System.out.println("First: " + this.first);
        System.out.println("last: " + this.last);
        System.out.println("size: " + this.size);
        System.out.println("--------------------------------");

    }

    // tests and calls every instance method in this class
    public static void main(String[] args) {

        // test to see if it creates the object correctly
        RingBuffer test = new RingBuffer(4);
        test.print();

        // test to see if it enqueues a single value
        test.enqueue(7.2);
        test.print();

        // test to see if it can enqueue a secondary value
        test.enqueue(6.1);
        test.print();

        // test to see if it can dequeue correctly
        test.dequeue();
        test.print();

        // test to see if it can show the Runtime error enqueue a full ring
        // test.enqueue(2.6);
        test.enqueue(99.9);
        test.enqueue(0.3);
        test.enqueue(12.3);
        test.print();

        // testing other functions
        System.out.println("Capacity: " + test.capacity());
        System.out.println("Item at front: " + test.peek());
        System.out.println("Size: " + test.size());
        System.out.println(test.isEmpty());
        System.out.println(test.isFull());

        int n = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(n);
        for (int i = 1; i <= n; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        StdOut.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        StdOut.println(buffer.peek());
    }

}
