/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   ctorres66@upr.edu
 *  Precept: P00
 *
 *  Description: Takes two integer command-line arguments n and trials.
 *               In each of trials independent experiments, simulates a
 *              random walk of n steps and compute the squared distance.
 *             Outputs the mean squared distance (the average of the trials
 *            squared distances).
 *
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        // declaring command-line arguments
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double pastdistance = 0;


        // trial runs

        for (int j = 0; j < trials; j++) {

            int x2 = 0;
            int y2 = 0;

            if (j == 0) {


                // first test of randomwalker
                for (int i = 0; i < n; i++) {
                    double direction = Math.random();
                    if (direction <= 0.25) {
                        y2++;
                    }
                    else if (direction <= 0.5) {
                        y2--;
                    }
                    else if (direction <= 0.75) {
                        x2++;
                    }
                    else {
                        x2--;
                    }
                }
                // calculating squared distance
                pastdistance = (int) (Math.pow(x2, 2) + Math.pow(y2, 2));
            }

            // following tests where the result of each one done here is added
            // to the previous one, one by one, in order to obtain the total
            // distance between all the tests.
            else {
                for (int i = 0; i < n; i++) {
                    double direction = Math.random();
                    if (direction <= 0.25) {
                        y2++;
                    }
                    else if (direction <= 0.5) {
                        y2--;
                    }
                    else if (direction <= 0.75) {
                        x2++;
                    }
                    else {
                        x2--;
                    }
                }
                // calculating squared distance and adding it to the past one
                // in order to obtain a total sum of all distances at the end
                int distance = (int) (Math.pow(x2, 2) + Math.pow(y2, 2));
                pastdistance = pastdistance + distance;
            }
        }
        // calculating and printing out average distance
        double meandistance = pastdistance / trials;
        System.out.println("mean squared distance = " + meandistance);
    }
}
