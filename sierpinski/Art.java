/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import java.awt.Color;

public class Art {

    public static void color() {
        double color = Math.random();
        if (color < 0.125) {
            StdDraw.setPenColor(Color.BLUE);
        }
        else if (color < 0.25) {
            StdDraw.setPenColor(Color.RED);
        }
        else if (color < 0.375) {
            StdDraw.setPenColor(Color.YELLOW);
        }
        else if (color < 0.50) {
            StdDraw.setPenColor(Color.GREEN);
        }
        else if (color < 0.625) {
            StdDraw.setPenColor(Color.PINK);
        }
        else if (color < 0.75) {
            StdDraw.setPenColor(Color.ORANGE);
        }
        else if (color < 0.875) {
            StdDraw.setPenColor(Color.CYAN);
        }
        else {
            StdDraw.setPenColor(Color.BLACK);
        }
    }

    public static void filledSquare(double x, double y, double length) {
        StdDraw.filledSquare(x, y, length / 2);
    }


    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 1) {
            filledSquare(x, y, length);
            return;
        }

        filledSquare(x, y, length);
        color();
        sierpinski(n - 1, x + length, y + length, length / 4);
        color();
        sierpinski(n - 1, x, y + length, length / 4);
        color();
        sierpinski(n - 1, x - length, y + length, length / 4);
        color();
        sierpinski(n - 1, x + length, y, length / 4);
        color();
        sierpinski(n - 1, x - length, y, length / 4);
        color();
        sierpinski(n - 1, x + length, y - length, length / 4);
        color();
        sierpinski(n - 1, x, y - length, length / 4);
        color();
        sierpinski(n - 1, x - length, y - length, length / 4);
        color();


    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        sierpinski(n, 0.5, 0.5, (1 / 3.0));
    }
}

