/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Description:  Draws one filled equilateral triangle (pointed downwards)
 *                and then call itself recursively three times (with an
 *                appropriate stopping condition).
 *
 **************************************************************************** */

import java.awt.Color;

public class Sierpinski {
    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length) {
        double height = (length * Math.sqrt(3)) / 2;
        return height;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        double x1 = x + length / 2;
        double x2 = x - length / 2;
        double y1 = y + height(length);
        double y2 = y + height(length);
        double[] xcoord = { x, x1, x2 };
        double[] ycoord = { y, y1, y2 };

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledPolygon(xcoord, ycoord);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 1) {
            filledTriangle(x, y, length);
            return;
        }
        filledTriangle(x, y, length);
        sierpinski(n - 1, x - length * 0.5, y, length * 0.5);
        sierpinski(n - 1, x + length * 0.5, y, length * 0.5);
        sierpinski(n - 1, x, y + height(length), length * 0.5);

    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.line(0, 0, 1, 0);
        StdDraw.line(0, 0, 0.5, height(1));
        StdDraw.line(1, 0, 0.5, height(1));
        sierpinski(n, 0.5, 0, 0.5);
    }
}
