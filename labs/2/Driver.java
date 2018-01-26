/**
 * Lab 2 Part 1 Implementation
 * @author Miguel Nistal
 */

import java.util.Scanner;

class Driver {

  /** 
   * Main expects input redirection for handling input
   *  Requires two long primatives per line, any number of lines
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    while (input.hasNext()) {
      long a = input.nextLong();
      long b = input.nextLong();
      long r = euclidAlg(a, b);

      System.out.println(r);
    }

    input.close();
  }

  /**
   * Implementation of the Euclidian algorithm 
   * using the division algorithm recursively 
   * @param a - Dividend to use
   * @param b - Divisor to use
   * @return - Value of the greatest common demonitaor between 'a' and 'b'
   */
  static long euclidAlg(long a, long b) {
    /** The Division Algorithm 
     [Intro to Cryptography by Stanoyevitch]
     a = qd + r
     q = floor(a/d)
     r = a - qd
    */

    // Satisfy the Assumption that A >= B
    if (a < b) {
      long tmp = a;
      a = b;
      b = tmp;
    }

    // Find the quotient, and use that to find the remainder
    long quotient = a / b;
    long remainder = a - (quotient * b);

    // If we find a 0 remainder, then the divisor is the GCD
    // otherwise recurse until remainder is 0
    if (remainder != 0) {
      return euclidAlg(remainder, b);
    }
    return b;
  }

}