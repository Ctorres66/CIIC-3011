/* *****************************************************************************
 * Name: Carlos A. Torres
 * NetID: carlos.torres66@upr.edu
 * Precept: P00
 *
 * Description: Produces pseudo-random bits by simulating a linear-feedback
 *              shift register, and then use it to implement a simple form of
 *              encryption for digital pictures.
 *
 **************************************************************************** */

public class LFSR {

    private final int n;           // number of bits in the LFSR
    private int[] reg;       // reg[i] = ith bit of LFSR, reg[1] is rightmost bit
    private final int tapPosition; // tap position

    // creates an LFSR with the specified seed and tap
    public LFSR(String seed, int tap) {

        reg = new int[seed.length()];
        n = seed.length();

        for (int i = 0; i < n; i++) {
            reg[i] = seed.charAt(n - i - 1);

            // changing chars to ints
            if (reg[i] == '0') {
                reg[i] = 0;
            }
            if (reg[i] == '1') {
                reg[i] = 1;
            }
        }
        tapPosition = tap;
    }

    // returns the number of bits in this LFSR
    public int length() {
        return reg.length;
    }

    // returns the ith bit of this LFSR (as 0 or 1)
    public int bitAt(int i) {
        return reg[i - 1];
    }

    // returns a string representation of this LFSR
    public String toString() {
        String a = "";

        for (int i = n; i > 0; i--) {
            a = a + reg[i - 1];
        }
        return a;
    }

    // simulates one step of this LFSR and returns the new bit (as 0 or 1)
    public int step() {
        int x = reg[n - 1] ^ bitAt(tapPosition);
        for (int i = n - 1; i > 0; i--) {
            reg[i] = reg[i - 1];
        }
        reg[0] = x;
        return x;
    }

    // simulates k steps of this LFSR and returns the k bits as a k-bit integer
    public int generate(int k) {
        int p = 0;
        for (int i = k - 1; i >= 0; i--) {
            int a = step();
            p = 2 * p + a;
        }
        return p;
    }

    public static void main(String[] args) {
        LFSR lfsr0 = new LFSR("01101000010", 9);
        StdOut.println(lfsr0);
        System.out.println(lfsr0.bitAt(3));
        System.out.println(lfsr0.length());

        LFSR lfsr1 = new LFSR("01101000010", 9);
        StdOut.println(lfsr1);
        for (int i = 0; i < 10; i++) {
            int bit = lfsr1.step();
            StdOut.println(lfsr1 + " " + bit);
        }

        LFSR lfsr2 = new LFSR("01101000010", 9);
        StdOut.println(lfsr2);
        for (int i = 0; i < 10; i++) {
            int r = lfsr2.generate(5);
            StdOut.println(lfsr2 + " " + r);

        }
    }
}


