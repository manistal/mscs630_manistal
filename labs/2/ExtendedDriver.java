/**
 * Lab 2 Part 2 Implementation
 * @author Miguel Nistal
 */

import java.util.Scanner;

class ExtendedDriver {

  /** 
   * Main expects input redirection for handling input
   *  Requires two long primatives per line, any number of lines
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    while (input.hasNext()) {
      long a = input.nextLong();
      long b = input.nextLong();
      long[] gcd = euclidAlgExt(a, b);

      for (int idx = 0; idx < gcd.length; idx++) {
        System.out.print(gcd[idx] + " ");
      }
      System.out.println();
    }

    input.close();
  }

  /**
   * Implementation of the Extended Euclidian algorithm 
   * using the division algorithm recursively 
   * @param a - Dividend to use
   * @param b - Divisor to use
   * @return - Value of the greatest common demonitaor between 'a' and 'b'
   */
  static long[] euclidAlgExt(long a, long b) {

    // Extendended Euclidian Algorithm utilizes vector math
    // Initialize the 3 vectors we'll be using to their base values
    long[] U = new long[]{a, 1, 0};
    long[] V = new long[]{b, 0, 1};
    long[] W = new long[3];

    // While "b" the divisor is greater than zero, repeat the process
    while (V[0] > 0) {

      // Divide B into A (just like in the base Euclidian Algorithm)
      long tmp = U[0] / V[0];

      // Apply the result to the vector equation 
      for (int idx = 0; idx < W.length; idx++) {
        W[idx] = U[idx] - (tmp*V[idx]);
      }

      // Update the vectors for the next iteration
      U = V.clone();
      V = W.clone();
    }

    return U;
  }

}