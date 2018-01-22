/** 
 * Lab 1 for MSCS630 
 *  Implementation of a simple str to int encoding
 *  @author Miguel Nistal 
 */

import java.util.Scanner;
import java.util.Arrays;

class Cypher {

  /* Constants representing important ASCII/Cypher Values */
  static final int ASCII_UPPERCASE_A = 65;
  static final int ASCII_SPACE = 32;
  static final int CYPHER_SPACE = 26;

  /** 
   * Main Routine
   *  Scans STDIN line by line until EOF Character
   *  Each line is translated from PlainText String to CypherText Array
   *  Results displayed via STDOUT
   */
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    while (input.hasNext()) {
      int[] cypher_text = str2int(input.nextLine());
      for (int idx = 0; idx < cypher_text.length; idx++) {
        System.out.print(cypher_text[idx] + " ");
      }
      System.out.println();
    }

    input.close();
  }

  /**
   * str2int - Function to encode plainText to array of ints
   * @param plainText - Plaintext string to be encoded
   * @return - Array of integers representing each char of the 
   *           plaintext string encoded as an integer
   */
  protected static int[] str2int(String plainText) {
    plainText = plainText.toUpperCase();
    int[] cypher_text = new int[plainText.length()];

    for (int idx = 0; idx < plainText.length(); idx++) {
      char current_char = plainText.charAt(idx);
      int ascii_value = (int)current_char;
      int cypher_value = ascii_value - ASCII_UPPERCASE_A;

      if (ascii_value == ASCII_SPACE) {
        cypher_value = CYPHER_SPACE;
      }

      cypher_text[idx] = cypher_value;
    }
    return cypher_text;
  }

}