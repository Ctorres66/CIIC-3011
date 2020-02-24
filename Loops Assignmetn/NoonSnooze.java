/* *****************************************************************************
 *  Name:    Carlos A. Torres
 *  NetID:   carlos.torres66@upr.edu
 *  Precept: P00
 *
 *  Description: This program takes an integer command-line argument snooze
 *               and prints the time of day (using a 12-hour clock) that is
 *               snooze minutes after 12:00pm (noon).
 *
 **************************************************************************** */

public class NoonSnooze {
    public static void main(String[] args) {

        // define command-line argument
        int snooze = Integer.parseInt(args[0]);

        // declare hour, minutes and counter for am/pm
        int hour = 12 + (snooze / 60);
        int minutes = snooze % 60;
        int counter = 0;

        // making the hour loop from 12 back to 1, while setting the counter for
        // am/pm

        if (hour > 12) {
            counter = (hour - 12) / 12;
            hour = hour % 12;
            if (hour == 0) {
                hour = 12;
            }
        }


        // deciding on when to use am and when to use pm
        // within each of these scenarios we need to check wether there is a
        // single digit number in minutes, in which case we place a 0 to the
        // left of that number.
        // (Example : 5:3pm -> 5:03 pm)
        if (counter % 2 == 0) {
            if (minutes < 10) {
                System.out.println(hour + ":0" + minutes + "pm");
            }
            else {
                System.out.println(hour + ":" + minutes + "pm");
            }
        }
        else {
            if (minutes < 10) {
                System.out.println(hour + ":0" + minutes + "am");
            }
            else {
                System.out.println(hour + ":" + minutes + "am");
            }
        }

    }
}

