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
    System.out.println();

    //String result = AESCipher.AESEncryptBlock(plaintext_block, encryption_key);
    //System.out.println(result);
    AESUnitTests();
  }

  /** 
   * Basic unit tests based on Lab 5 Instructions
   */
  static void AESUnitTests() {
    // Test Values, expected values can be based on inputs since most are in Lab 5
    String test_key_hex = "5468617473206D79204B756E67204675";
    String test_plaintext = "54776F204F6E65204E696E652054776F";
    String exp_ciphertext = "29C3505F571420F6402299B31A02D73A";

    String add_key_test_hex = "54776F204F6E65204E696E652054776F";
    String nibble_sub_test_hex = "001F0E543C4E08596E221B0B4774311A";
    String shift_rows_test_hex = "63C0AB20EB2F30CB9F93AF2BA092C7A2";
    String mix_column_test_hex = "632FAFA2EB93C7209F92ABCBA0C0302B";

    String exp_result_addkey = nibble_sub_test_hex;
    String exp_result_nsub = shift_rows_test_hex;
    String exp_result_srows = mix_column_test_hex;
    String exp_result_mcols = "BA75F47A84A48D32E88D060E1B407D5D";

    // Test Add Key Operation in AES 
    int[][] state_addkey_result = AESCipher.AESAddKey(AESCipher.makeHexMatrix(add_key_test_hex), AESCipher.makeHexMatrix(test_key_hex));
    Boolean state_addkey_correct = AESCipher.flattenHexMatrix(state_addkey_result).equals(exp_result_addkey);
    System.out.println("State XOR: " + state_addkey_correct);
    AESCipher.printMatrix(state_addkey_result);
    System.out.println();
    
    // Test Nibble Sub Operation in AES 
    int[][] nibble_sub_result = AESCipher.AESNibbleSub(AESCipher.makeHexMatrix(nibble_sub_test_hex));
    Boolean state_nsub_correct = AESCipher.flattenHexMatrix(nibble_sub_result).equals(exp_result_nsub);
    System.out.println("Nibble Sub: " + state_nsub_correct);
    AESCipher.printMatrix(nibble_sub_result);
    System.out.println();

    // Test Shift Rows Operation in AES
    int[][] shift_rows_result = AESCipher.AESShiftRow(AESCipher.makeHexMatrix(shift_rows_test_hex));
    Boolean state_srows_correct = AESCipher.flattenHexMatrix(shift_rows_result).equals(exp_result_srows);
    System.out.println("Shift Rows: " + state_srows_correct);
    AESCipher.printMatrix(shift_rows_result);
    System.out.println();

    // Test Mix Column Operation in AES 
    int[][] mix_column_result = AESCipher.AESMixColumns(AESCipher.makeHexMatrix(mix_column_test_hex));
    Boolean state_mcols_correct = AESCipher.flattenHexMatrix(mix_column_result).equals(exp_result_mcols);
    System.out.println("Mix Column: " + state_mcols_correct);
    AESCipher.printMatrix(mix_column_result);
    System.out.println();

    // Test Full Encryption of a Block
    String cipher_result = AESCipher.AESEncryptBlock(test_plaintext, test_key_hex);
    Boolean aes_correct = cipher_result.equals(exp_ciphertext);
    System.out.println("AES Cipher: " + aes_correct);
    System.out.println(cipher_result);
  }

}