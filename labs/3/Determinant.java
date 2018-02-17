/** 
 * Implementation of Lab 3 Part 1
 * @author Miguel Nistal 
 */

import java.util.Scanner;

class Determinant {

  /** 
   * Main expects input redirection for handling input
   *  Requires the first line to be "<Modulo> <Size>"
   *  where modulo is the modulo under which all integer calculations will be peformed
   *  and where size is the size of the square matrix to process
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int modulo = input.nextInt();
    int matrix_size = input.nextInt();
    int[][] matrix = new int[matrix_size][matrix_size];

    for (int row = 0; row < matrix_size; row++) {
      for (int col = 0; col < matrix_size; row++) {
        matrix[row][col] = input.nextInt();
      }
    }
    input.close();

    int determinant = cofModDet(modulo, matrix);
    System.out.println(determinant);

  }

  static int cofModDet(int modulo, int[][] matrix) {
    // Can use the outer length as long as the 2D Array is Square
    int matrix_size = matrix.length;
    int determinant = 0;

    if (matrix_size == 1) {
      return matrix[0][0];
    }

    else if (matrix_size == 2) {
      return ((matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]));
    }

    else {
      return det;
    }

    return det;
  }



}