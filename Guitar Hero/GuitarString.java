/* *****************************************************************************
 *  Name: Carlos A. Torres
 *  NetID: carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Partner Name:
 *  Partner NetID:
 *  Partner Precept:
 *
 *  Description:  This is a template file for GuitarString.java. It lists the
 *                constructors and methods you need, along with descriptions
 *                of what they're supposed to do.
 *
 *                Note: it won't compile until you fill in the constructors
 *                and methods (or at least commment out the ones whose return
 *                type is non-void).
 *
 **************************************************************************** */

public class GuitarString {
    private final RingBuffer buffer; // ring buffer attached to each string

    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        int samplingRate = 44100;
        int arraysize = (int) Math.ceil(samplingRate / frequency);
        buffer = new RingBuffer(arraysize);
        for (int i = 0; i < this.buffer.capacity(); i++) {
            buffer.enqueue(0);
        }
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        buffer = new RingBuffer(init.length);
        for (int i = 0; i < init.length; i++) {
            buffer.enqueue(init[i]);
        }
    }

    // returns the number of samples in the ring buffer
    public int length() {
        return buffer.capacity();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue();
            double k = StdRandom.uniform(-0.5, 0.5);
            buffer.enqueue(k);
        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        double deleted = buffer.dequeue();
        double k = 0.996 * ((deleted + buffer.peek()) / 2.0);
        buffer.enqueue(k);
    }

    // returns the current sample
    public double sample() {
        return buffer.peek();
    }


    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        double[] samples = { 0.2, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0, -0.1, -0.3 };
        GuitarString testString = new GuitarString(samples);
        int m = 25; // 25 tics
        for (int i = 0; i < m; i++) {
            double sample = testString.sample();
            StdOut.printf("%6d %8.4f\n", i, sample);
            testString.tic();
        }
        testString.pluck();
        System.out.println(testString.length());

    }
}
