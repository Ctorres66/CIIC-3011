/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlostorres66@gmail.com
 *  Precept: P00
 *
 *  Description: This is a library of static methods that performs various
 *               geometric transforms on polygons. In Java, we will represent a
 *               polygon by storing the x- and y-coordinates of the vertices
 *               in two parallel arrays x[] and y[].
 *
 **************************************************************************** */

public class Transform2D {

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] a = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
        return a;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }

    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        double[] x2 = copy(x);
        double[] y2 = copy(y);

        for (int i = 0; i < x.length; i++) {
            x[i] = x2[i] * Math.cos(Math.toRadians(theta)) - y2[i] * Math
                    .sin(Math.toRadians(theta));
            y[i] = y2[i] * Math.cos(Math.toRadians(theta)) + x2[i] * Math
                    .sin(Math.toRadians(theta));
        }

    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        double x[] = { 0, 1, 1, 0 };
        double y[] = { 0, 0, 2, 1 };
    }
}
