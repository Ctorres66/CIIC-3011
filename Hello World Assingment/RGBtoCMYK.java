/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   ctorres66@upr.edu
 *  Precept: P00
 *
 *  Description:  This program ,RGBtoCMYK.java, Converts colors from RGB format
 *                to CMYK format. It takes three integer command-line arguments
 *                red, green, and blue; prints the RGB values; then prints the
 *                equivalent CMYK values using these mathematical formulas:
 *                white = max{red÷255,green÷255,blue÷255}
 *                cyan = (white−red÷255)÷white
 *                magenta = (white−green÷255)÷white
 *                yellow = (white−blue÷255)÷white
 *                black = 1 - white
 *
 **************************************************************************** */

public class RGBtoCMYK {
    public static void main(String[] args) {
        // Defining int variables for RGB colors
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);

        // Calculating white
        double whitestep1 = Math.max((double) red / 255, (double) green / 255);
        double Truewhite = Math.max(whitestep1, (double) blue / 255);

        // Calculating CYMK values
        double cyan = (Truewhite - (double) red / 255) / Truewhite;
        double magenta = (Truewhite - (double) green / 255) / Truewhite;
        double yellow = (Truewhite - (double) blue / 255) / Truewhite;
        double black = 1 - Truewhite;

        //Outputing Results
        System.out.println(("red         = ") + red);
        System.out.println(("green       = ") + green);
        System.out.println(("blue        = ") + blue);
        System.out.println(("cyan        = ") + cyan);
        System.out.println(("magenta     = ") + magenta);
        System.out.println(("yellow      = ") + yellow);
        System.out.println(("black       = ") + black);


    }
}
