/** 
 * Implementation of Lab 4
 * Handles input and testing for AESCipher.java
 * @author Miguel Nistal 
 */

import java.util.Scanner;

class DriverAES {

  /** 
   * Main expects input redirection for handling input
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String user_key = input.nextLine();
    System.out.println(user_key);
    input.close();

    AESCipher MyCipher = new AESCipher();
    String[] Result = MyCipher.aesRoundKeys(user_key);
  }
}