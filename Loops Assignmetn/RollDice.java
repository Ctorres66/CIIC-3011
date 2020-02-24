/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Description: Takes an integer command-line argument n, and rolls 10 fair
 *               six-sided dice, n times. Use an integer array to tabulate the
 *               number of times each possible total (between 10 and 60) occurs.
 *               Then print a text histogram of the results, as illustrated
 *               below.
 **************************************************************************** */

public class RollDice {
    public static void main(String[] args) {

        // declaring variables and array
        int n = Integer.parseInt(args[0]);
        int[] result = new int[n];


        // dice roll process repeated n times
        for (int i = 0; i < n; i++) {
            int totalroll = 0;

            // rolling a singular dice 10 times and adding the results of each
            // roll together
            for (int j = 0; j < 10; j++) {
                int roll = (int) (Math.random() * 6 + 1);
                totalroll = totalroll + roll;

            }
            // storing result of roll process into array
            result[i] = totalroll;
        }

        // printing out histogram

        for (int k = 10; k <= 60; k++) {
            String star = "";

            // looping through the array for each value of 10 through
            // 60, and adding an asterisk for each time that value appears in
            // the array

            for (int q = 0; q < n; q++) {
                if (result[q] == k) {
                    star = star + "*";
                }
            }
            System.out.println(k + ": " + star);
        }


    }
}
