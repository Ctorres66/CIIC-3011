/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Partner Name:
 *  Partner NetID:
 *  Partner Precept:
 *
 *  Description: This program is similar to GuitarHeroLite, but supports
 *               a total of 37 notes on the chromatic scale from 110 Hz
 *              to 880 Hz.
 *
 **************************************************************************** */

public class GuitarHero {
    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[keyboard.length()];
        double samplingRate = 440;


        for (int i = 0; i < keyboard.length(); i++) {
            double pow = ((i - 24) / 12.0);
            strings[i] = new GuitarString(samplingRate * Math.pow(2, pow));
        }

        while (true) {
            double samples = 0;
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // using key typed to pluck appropiate cord
                int location = keyboard.indexOf(key);
                if (location != -1) {
                    strings[location].pluck();
                    // System.out.println(strings[location].sample());
                }
            }

            // adding up all 37 cords samples for superposition
            for (int i = 0; i < keyboard.length(); i++) {
                samples = samples + strings[i].sample();
            }

            // playing the audio
            // System.out.println(samples);
            StdAudio.play(samples);

            // applying the tic procedure to all cords
            for (int i = 0; i < keyboard.length(); i++) {
                strings[i].tic();
            }


        }

    }
}

