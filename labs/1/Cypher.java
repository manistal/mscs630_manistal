import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

class Cypher {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    while (input.hasNext()) {
      int[] encoded_string = encodeString(input.nextLine());
      for (int idx = 0; idx < encoded_string.length; idx++) {


      }
    }
  }

  protected static int[] encodeString(String plaintext) {
    plaintext = plaintext.toUpperCase();
    int[] output = new int[plaintext.length()];

    for (int idx = 0; idx < plaintext.length(); idx++) {
      char current_char = plaintext.charAt(idx);
      int ascii_value = (int)current_char;
      int cypher_value = ascii_value - 65;

      if (ascii_value == 32) {
        cypher_value = 26;
      }

      output[idx] = cypher_value;
    }

    return output;
  }

}