/** 
 * Implementation of Lab 3 Part 2
 * @author Miguel Nistal 
 */

import java.util.Scanner;

class HexMat {

  static final int MATRIX_DIMENSION = 4;
  static final int MATRIX_SIZE = MATRIX_DIMENSION * MATRIX_DIMENSION;

  /** 
   * Main expects input redirection for handling input
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char padding_char = input.nextLine().charAt(0);
    String plaintext = input.nextLine();

    // We need to break up the plaintext into chunks that fit inside 4x4 matrices
    int number_of_matrices = (plaintext.length() / MATRIX_SIZE) + 1;
    for (int mat_index = 0; mat_index < number_of_matrices; mat_index++) {

      // For each matrix, we only process one 16 length chunk
      int substring_start = mat_index * MATRIX_SIZE;
      int substring_end = substring_start + MATRIX_SIZE;
      if (substring_end > plaintext.length()) {
        substring_end = plaintext.length();
      }
      String plaintext_substr = plaintext.substring(substring_start, substring_end);

      // Each 16 length chunk gets processed into hex and then printed
      int[][] result_matrix = getHexMatP(padding_char, plaintext_substr);
      printHexMatrix(result_matrix);
      // printASCIIMatrix(result_matrix);
    }

    input.close();
  }

  static int[][] getHexMatP(char sub_char, String plaintext) {
    int[][] hex_matrix = new int[MATRIX_DIMENSION][MATRIX_DIMENSION];
    
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

  static void printHexMatrix(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        System.out.print(Integer.toHexString(matrix[row][column]).toUpperCase() + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

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