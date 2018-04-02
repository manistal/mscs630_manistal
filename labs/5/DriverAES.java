/** 
 * Implementation of Lab 4
 * Handles input and testing for AESCipher.java
 * @author Miguel Nistal 
 */

import java.util.Scanner;

class DriverAES {

  /** Driver to test of AES Implementation  Encryption */
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String encryption_key = input.nextLine();
    String plaintext_block = input.nextLine();
    input.close();

    System.out.println(" Key: " + encryption_key);
    System.out.println(" P:   " + plaintext_block);

  }
}