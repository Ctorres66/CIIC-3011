/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Description:  Takes three int command-line arguments, x, y, and z, defines
 *               a boolean variable whose value is true if the three values
 *               are either in strictly ascending order (x < y < z) or in
 *               strictly descending order (x > y > z), and false otherwise.
 *               This programs must be built without using if statements.
 *
 **************************************************************************** */

public class Ordered {
    public static void main(String[] args) {
        // defining int command-line arguments
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);

        // Comparing Variables
        boolean result = ((x < y) == ((y < z)) && (x != y) && (y != z) && (x != z));

        // Outputing Result
        System.out.println(result);
    }
}
