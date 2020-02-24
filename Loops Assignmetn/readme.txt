/* *****************************************************************************
 *  Name:
 *  NetID:
 *  Precept:
 **************************************************************************** */

COS 126 Assignment: Conditionals & Loops

What operating system do you use?

Which text editor are you using to edit this file? (We recommend IntelliJ!)
I am using IntelliJ.
Number of hours to complete this assignment:
It took me around 5 and a half hours to complete the 5 programs, as i got stuck on
multiple occasions.
/**********************************************************************
 *  What is the relationship between the number of steps n of the
 *  random walk and the mean squared distance? By relationship, we mean
 *  something like
 *                       mean squared distance = 126 n^9
 *
 *  Briefly justify your answer based on computational experiments.
 *  Describe the experiments and list several data points.
 *********************************************************************/
 mean squared distance = n
 I first began noticing this when i started performing the program with random
 values.

  ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 1 100000
 mean squared distance = 1.0
  ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 2 100000
 mean squared distance = 1.99738
  ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 3 100000
 mean squared distance = 2.99912
  ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 30 100000
 mean squared distance = 30.0058
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 125 100000
mean squared distance = 124.4064
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 15 100000
mean squared distance = 14.981
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 99 100000
mean squared distance = 98.97624

I assumed that most of these in most of theses cases mean squared distance = n-x
where x is some small decimal. But then i saw the case with n = 30. In this case
mean squared distance = n + x where x is some small decimal. I redid the program
with n = 30 multple times.

 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 30 100000
mean squared distance = 30.10102
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 30 100000
mean squared distance = 29.96644
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 30 100000
mean squared distance = 30.19116
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 30 100000
mean squared distance = 29.89632
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 30 100000
mean squared distance = 30.0604

Now i could see that it is possible to obtain values above and below 30 for this
program. i did the same for 2 other values of n to see if we reach the same results.

 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 3 100000
mean squared distance = 2.997
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 3 100000
mean squared distance = 3.00344
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 3 100000
mean squared distance = 2.98884
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 3 100000
mean squared distance = 3.00636
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 3 100000
mean squared distance = 2.997

 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 14 100000
mean squared distance = 14.01618
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 14 100000
mean squared distance = 14.05318
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 14 100000
mean squared distance = 14.02042
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 14 100000
mean squared distance = 13.9621
 ~/Downloads/CIIC 3011/Loops Assignmetn> java-introcs RandomWalkers 14 100000
mean squared distance = 13.9575

Lets say that this program was done an infinite amount of times with
n = 13 and trials = 100000. Every possible number that fits the format
mean squared distance = 13 - x or 13 + x (where x is any number) would pop
out as a result. So, if we try to average all of these results out, the result
would be 13, as for every value that x is taken away from 13, there is another
value in which x is added to 13. When adding these 2 specific values together,
their average is 13. (Example: 12.99  and 13.01). When realizing this i decided
to say that the mean squared distance = n.

The only exeption to that last paragraph is n = 1. the mean squared distance
never differes from 1.0 in this one becuase the is only 1 movement in each case,
so the mean squared distance in each case will always be 1.


/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names. ("A Sunday lab TA" or
 *  "Office hours on Thursday" is OK if you don't know their name.)
 **********************************************************************/

Yes or no?
No


/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?
I did encounter problems, but they were nothing more than small mistakes
in my code. When it comes to serious issues, i experience none when i was
completing my assignment.

/**********************************************************************
 *  List any other comments here.
 **********************************************************************/

