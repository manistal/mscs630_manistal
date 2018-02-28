/** 
 * Implementation of Lab 3 Part 1
 * Calculating the Determinant of any Square Modular Matrix
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

  /** 
   * Cofactor Expansion along the first row to get the Determinant of a Moduluar Matrix
   *  @param modulo  The modulo of the matrix 
   *  @param matrix  The matrix to find the determinant of
   *  @return Modular Determinant 
   */
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
    // Here we can use Co-factor expansion, take the cofactor and multiply it
    // against a call to this function to get the determinant for the co-factor matrix 
    // with a sufficiently small cofactor matrix (2x2), we'll return back the determinants 
    else {

      // Cofactor matrix is N-1 x N-1
      int cofactor_matrix_size = matrix_size - 1;

      // Iterate across the first row of the matrix, the entries in the first row are the "cofactors"
      // this is referred to as "cofactor expansion along the first row"
      for (int cofactor_index = 0; cofactor_index < matrix_size; cofactor_index++) {
        int[][] cofactor_matrix = new int[cofactor_matrix_size][cofactor_matrix_size];

        // Since this expands cofactors along the first row, we never use Row 0 in our cofactor matrix
        // We then have to iterate across ALL columns in the matrix and only skip the one that corresponds 
        // to which cofactor we are currently working with (column == cofactor_index)
        int cofactor_column = 0;
        for (int row = 1; row < matrix_size; row++) {
          for (int column = 0; column < matrix_size; column++) {
            if (column == cofactor_index) continue;
            cofactor_matrix[row - 1][cofactor_column++] = matrix[row][column];
          }
          cofactor_column = 0;
        }

        // The determinant is the sum of the cofactor expansions:
        //             -1 ^ (n)  *  Co-factor  * Determinant of the Co-factor Matrix 
        determinant += (Math.pow(-1, cofactor_index)) * matrix[0][cofactor_index] * cofModDet(modulo, cofactor_matrix);
      }

    }
    
    // *NOTE* The % operator is NOT Modulo in Java, it is REMAINDER
    //         therefore we have to use a function from the Math lib
    return Math.floorMod(determinant, modulo);
  }

}