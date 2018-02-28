/** 
 * Implementation of Lab 3 Part 2
 * Plaintext string to Byte Matrix representation
 * @author Miguel Nistal 
 */

import java.util.Scanner;

class HexMat {

  // As per the assignment, the matrix is 4x4, the total entries in the matrix are 16
  static final int MATRIX_DIMENSION = 4;
  static final int MATRIX_SIZE = MATRIX_DIMENSION * MATRIX_DIMENSION;

  /** 
   * Main expects input redirection for handling input
   *  where the first line is a single char representing the substitution character to use
   *  and the second line is the plaintext to endcode 
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char padding_char = input.nextLine().charAt(0);
    String plaintext = input.nextLine();
    input.close();

    // Each 16 character chunk of plaintext gets its own matrix, determine number of matrices and iterate
    int number_of_matrices = (plaintext.length() / MATRIX_SIZE) + 1;
    for (int mat_index = 0; mat_index < number_of_matrices; mat_index++) {

      // For each matrix, we only process one 16 length (or less) substring of the text
      int substring_start = mat_index * MATRIX_SIZE;
      int substring_end = substring_start + MATRIX_SIZE;
      if (substring_end > plaintext.length()) {
        substring_end = plaintext.length();
      }
      String plaintext_substr = plaintext.substring(substring_start, substring_end);

      // Each resultant matrix is a set of 16 integers which we display as 4x4 Hex (byte representation) 
      int[][] result_matrix = getHexMatP(padding_char, plaintext_substr);
      printHexMatrix(result_matrix);
    }
  }

  /** 
   * Get Hexidecimal Matrix for Plaintext 
   *  takes the plaintext and a substitution char for padding 
   *  returns an NxN matrix defined by MATRIX_DIMENSION where each entry in the matrix 
   *  is an ASCII encoded integer from the string, leftover entries are padded with sub_char
   *  @param sub_char  Substution character used for padding the matrix
   *  @param plaintext Plaintext substring of less than MATRIX_SIZE to encode into the matrix
   *  @return NxN matrix containing ASCII encodings of the plaintext 
   */
  static int[][] getHexMatP(char sub_char, String plaintext) {
    int[][] hex_matrix = new int[MATRIX_DIMENSION][MATRIX_DIMENSION];
    
    // *NOTE* As per the assignment, characters must be placed down columns first
    //        So that it looks like [[b1, b5, ...][b2, b6,... ]...]
    //        To do this we index the character of plaintext by Column x Dimension + Row 
    for (int column = 0; column < MATRIX_DIMENSION; column++) {
      for (int row = 0; row < MATRIX_DIMENSION; row++) {

        int char_index = (column * MATRIX_DIMENSION) + (row);
        if (char_index < plaintext.length()) {
          hex_matrix[row][column] = (int) plaintext.charAt(char_index);
        }
        else {
          hex_matrix[row][column] = (int) sub_char;
        }

      }
    }

    return hex_matrix;
  }

  /**
   * Helper function to print an NxN matrix of integers as Hex
   */
  static void printHexMatrix(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        System.out.print(Integer.toHexString(matrix[row][column]).toUpperCase() + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Helper function to print an NxN matrix of integers as ASCII characters
   *  (DEBUG ONLY)
   */
  static void printASCIIMatrix(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        System.out.print((char) matrix[row][column] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

}