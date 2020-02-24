/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Description:  Takes an integer command-line argument n and uses a while loop
 *                to compute the number of times you need to divide n by 2 until
 *                it is strictly less than 1. Prints the error message "Illegal
 *                input" if n is negative.
 *
 **************************************************************************** */

public class Bits {
    public static void main(String[] args) {
        // define command line argument
        int n = Integer.parseInt(args[0]);

        // illegal input scenario
        if (n < 0) {
            System.out.println("Illegal input");
        }

        // division loop with counter (result)
        else {
            int result = 0;

            while (n >= 1) {
                n = n / 2;
                result = result + 1;
            }

            // print out result
            System.out.println(result);
        }
    }
}

