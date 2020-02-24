/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Description: Encrypts and de-encrypts photos by using LSFR.
 *
 **************************************************************************** */

import java.awt.Color;

public class PhotoMagic {

    // returns a transformed copy of the specified picture, using the specified lfsr.
    public static Picture transform(Picture picture, LFSR lfsr) {
        // defining aspects of the picture
        int width = picture.width();
        int height = picture.height();


        // creating copy of original picture
        Picture picture2 = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);

                int r = color.getRed();    // red
                int g = color.getGreen();  // green
                int b = color.getBlue();   // blue

                picture2.set(col, row, new Color(r, g, b));
            }
        }

        // transforming the copy of the original picture
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture2.get(col, row);

                int r = color.getRed();    // red
                int g = color.getGreen();  // green
                int b = color.getBlue();   // blue

                r = r ^ lfsr.generate(8);
                g = g ^ lfsr.generate(8);
                b = b ^ lfsr.generate(8);

                picture2.set(col, row, new Color(r, g, b));
            }
        }

        return picture2;
    }

    // takes the name of an image file and a description of an lfsr
    // as command-line arguments;
    // displays a copy of the image that is "encrypted" using the LFSR.
    public static void main(String[] args) {

        // reading command-line arguments
        String picname = args[0];
        Picture pic = new Picture(picname);
        LFSR n = new LFSR(args[1], Integer.parseInt(args[2]));
        transform(pic, n).show();
    }
}
