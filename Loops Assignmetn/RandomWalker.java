/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlos.torres66@gmail.com
 *  Precept: P00
 *
 *  Description: takes an integer command-line argument n and simulates the
 *  motion of a random walk for n steps. Print the location at each step
 *  (including the starting point), treating the starting point as the origin
 *  (0, 0).
 *
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        // declaring n and coordinates
        int n = Integer.parseInt(args[0]);
        int x2 = 0;
        int y2 = 0;

        // printing out first coordinates
        System.out.println("(" + x2 + ", " + y2 + ")");

        // generating movement and coordinates
        for (int i = 0; i < n; i++) {
            double direction = Math.random();
            if (direction <= 0.25) {
                y2++;
                System.out.println("(" + x2 + ", " + y2 + ")");
            }
            else if (direction <= 0.5) {
                y2--;
                System.out.println("(" + x2 + ", " + y2 + ")");
            }
            else if (direction <= 0.75) {
                x2++;
                System.out.println("(" + x2 + ", " + y2 + ")");
            }
            else {
                x2--;
                System.out.println("(" + x2 + ", " + y2 + ")");
            }
        }
        // calculating and printing out squared distance
        int distance = (int) (Math.pow(x2, 2) + Math.pow(y2, 2));
        System.out.println("squared distance = " + distance);

    }
}
