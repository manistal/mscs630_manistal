/** 
 * Implementation of Lab 4
 * Handles input and testing for AESCipher.java
 * @author Miguel Nistal 
 */

import java.util.Scanner;

class DriverAES {

  /** Driver to test Round Key generation for AES */
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String user_key = input.nextLine();
    input.close();

    String[] RoundKeys = AESCipher.AESRoundKeys(user_key);
    for (int index = 0; index < RoundKeys.length; index++) {
      System.out.println(RoundKeys[index]);
    }

  }
}