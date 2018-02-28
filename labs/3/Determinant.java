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
      for (int col = 0; col < matrix_size; col++) {
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

    // *Special Case* Matrix of Size 1
    //  Determinant is always the value of the only entry
    if (matrix_size == 1) {
      determinant = matrix[0][0];
    }

    // *Special Case* Matrix of Size 2
    //  Determinant is given by the base determinant formula 
    //  Product of the primary diagonal less the product of the off diagonal
    else if (matrix_size == 2) {
      determinant = ((matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]));
    }

    // *Recursive Case* Matrix of any size greater than 2
    // 
    else {
      int cofactor_matrix_size = matrix_size - 1;

      // For each column along the first row
      for (int cofactor_index = 0; cofactor_index < matrix_size; cofactor_index++) {
        int[][] cofactor_matrix = new int[cofactor_matrix_size][cofactor_matrix_size];

        // Skip the first row always, so we start at 1 and iterate to matrix_size 
        int cofactor_column = 0;
        for (int row = 1; row < matrix_size; row++) {
          for (int column = 0; column < matrix_size; column++) {
            if (column == cofactor_index) continue;
            cofactor_matrix[row - 1][cofactor_column++] = matrix[row][column];
          }
          cofactor_column = 0;
        }

        // The determinant is the sum of the cofactor expansions:
        //             -1 ^ (n)  *  COFactor  * Determinant of the Cofactor Matrix 
        determinant += (Math.pow(-1, cofactor_index)) * matrix[0][cofactor_index] * cofModDet(modulo, cofactor_matrix);
      }

    }

    return Math.floorMod(determinant, modulo);
  }

}