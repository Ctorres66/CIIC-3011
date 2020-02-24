/* *****************************************************************************
 *  Name: Carlos A. Torres
 *  NetID: carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Description: The great circle distance is the shortest distance between two
 *               points on the surface of a sphere if you are constrained to
 *               travel along the surface. The following program makes four
 *               double command-line arguments x1, y1, x2, and y2 (the latitude
 *               and longitude, in degrees, of two points on the surface of the
 *               earth) and prints the great-circle distance (in nautical miles)
 *               between them. Use the following formula, which is derived from
 *               the spherical law of cosines:
 *
 *               distance=60arccos(sin(x1)*sin(x2)+cos(x1)*cos(x2)*cos(y1−y2))
 *
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        // defining double commmand-line arguments
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        // calculate distance

        double distance = 60 * Math
                .acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math
                        .cos(y1 - y2));

        // Display Result
        System.out.println(Math.toDegrees(distance) + " nautical miles");
    }
}
