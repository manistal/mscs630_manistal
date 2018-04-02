/** 
 * Implementation of Lab 4
 * Implementation of AES128 encryption cipher 
 * @author Miguel Nistal 
 */

import java.util.Arrays;

class AESCipher {

  /* Size in Bytes of the AES128 Blocks */
  private static final int BLOCK_BYTES = 16;

  /* Size in Bytes of the AES128 Keys */
  private static final int KEY_BYTES = 16;

  /* Order of the Square Key/Block Matrices */
  private static final int MX_ORDER = 4; 

  /* Number of Round Keys to Generate */
  private static final int KEY_ROUNDS = 11;

  /** 
   * Static representation of of Rijndael SBox for AES
   *  https://en.wikipedia.org/wiki/Rijndael_S-box 
   */
  public static final char[] AES_SBOX = {
      0x63, 0x7C, 0x77, 0x7B, 0xF2, 0x6B, 0x6F, 0xC5, 0x30, 0x01, 0x67, 0x2B, 0xFE, 0xD7, 0xAB, 0x76,
      0xCA, 0x82, 0xC9, 0x7D, 0xFA, 0x59, 0x47, 0xF0, 0xAD, 0xD4, 0xA2, 0xAF, 0x9C, 0xA4, 0x72, 0xC0,
      0xB7, 0xFD, 0x93, 0x26, 0x36, 0x3F, 0xF7, 0xCC, 0x34, 0xA5, 0xE5, 0xF1, 0x71, 0xD8, 0x31, 0x15,
      0x04, 0xC7, 0x23, 0xC3, 0x18, 0x96, 0x05, 0x9A, 0x07, 0x12, 0x80, 0xE2, 0xEB, 0x27, 0xB2, 0x75,
      0x09, 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A, 0xA0, 0x52, 0x3B, 0xD6, 0xB3, 0x29, 0xE3, 0x2F, 0x84,
      0x53, 0xD1, 0x00, 0xED, 0x20, 0xFC, 0xB1, 0x5B, 0x6A, 0xCB, 0xBE, 0x39, 0x4A, 0x4C, 0x58, 0xCF,
      0xD0, 0xEF, 0xAA, 0xFB, 0x43, 0x4D, 0x33, 0x85, 0x45, 0xF9, 0x02, 0x7F, 0x50, 0x3C, 0x9F, 0xA8,
      0x51, 0xA3, 0x40, 0x8F, 0x92, 0x9D, 0x38, 0xF5, 0xBC, 0xB6, 0xDA, 0x21, 0x10, 0xFF, 0xF3, 0xD2,
      0xCD, 0x0C, 0x13, 0xEC, 0x5F, 0x97, 0x44, 0x17, 0xC4, 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73,
      0x60, 0x81, 0x4F, 0xDC, 0x22, 0x2A, 0x90, 0x88, 0x46, 0xEE, 0xB8, 0x14, 0xDE, 0x5E, 0x0B, 0xDB,
      0xE0, 0x32, 0x3A, 0x0A, 0x49, 0x06, 0x24, 0x5C, 0xC2, 0xD3, 0xAC, 0x62, 0x91, 0x95, 0xE4, 0x79,
      0xE7, 0xC8, 0x37, 0x6D, 0x8D, 0xD5, 0x4E, 0xA9, 0x6C, 0x56, 0xF4, 0xEA, 0x65, 0x7A, 0xAE, 0x08,
      0xBA, 0x78, 0x25, 0x2E, 0x1C, 0xA6, 0xB4, 0xC6, 0xE8, 0xDD, 0x74, 0x1F, 0x4B, 0xBD, 0x8B, 0x8A,
      0x70, 0x3E, 0xB5, 0x66, 0x48, 0x03, 0xF6, 0x0E, 0x61, 0x35, 0x57, 0xB9, 0x86, 0xC1, 0x1D, 0x9E,
      0xE1, 0xF8, 0x98, 0x11, 0x69, 0xD9, 0x8E, 0x94, 0x9B, 0x1E, 0x87, 0xE9, 0xCE, 0x55, 0x28, 0xDF,
      0x8C, 0xA1, 0x89, 0x0D, 0xBF, 0xE6, 0x42, 0x68, 0x41, 0x99, 0x2D, 0x0F, 0xB0, 0x54, 0xBB, 0x16
  };
  
  /** 
   * Static representation of AES Key Scheduling
   * https://en.wikipedia.org/wiki/Rijndael_key_schedule
   */
  public static final char[] AES_RCON = {
    0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a, 
    0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39, 
    0x72, 0xe4, 0xd3, 0xbd, 0x61, 0xc2, 0x9f, 0x25, 0x4a, 0x94, 0x33, 0x66, 0xcc, 0x83, 0x1d, 0x3a, 
    0x74, 0xe8, 0xcb, 0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8, 
    0xab, 0x4d, 0x9a, 0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef, 
    0xc5, 0x91, 0x39, 0x72, 0xe4, 0xd3, 0xbd, 0x61, 0xc2, 0x9f, 0x25, 0x4a, 0x94, 0x33, 0x66, 0xcc, 
    0x83, 0x1d, 0x3a, 0x74, 0xe8, 0xcb, 0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 
    0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a, 0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3, 
    0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39, 0x72, 0xe4, 0xd3, 0xbd, 0x61, 0xc2, 0x9f, 0x25, 0x4a, 0x94, 
    0x33, 0x66, 0xcc, 0x83, 0x1d, 0x3a, 0x74, 0xe8, 0xcb, 0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 
    0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a, 0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35, 
    0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39, 0x72, 0xe4, 0xd3, 0xbd, 0x61, 0xc2, 0x9f, 
    0x25, 0x4a, 0x94, 0x33, 0x66, 0xcc, 0x83, 0x1d, 0x3a, 0x74, 0xe8, 0xcb, 0x8d, 0x01, 0x02, 0x04, 
    0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a, 0x2f, 0x5e, 0xbc, 0x63, 
    0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39, 0x72, 0xe4, 0xd3, 0xbd, 
    0x61, 0xc2, 0x9f, 0x25, 0x4a, 0x94, 0x33, 0x66, 0xcc, 0x83, 0x1d, 0x3a, 0x74, 0xe8, 0xcb, 0x8d
  };

  /* Substitutes inByte with the Rijndael SBox Value */
  static int aesSBox(int inByte) {
    return (int) AES_SBOX[inByte];
  }

  /* Returns the Rijndael Round Constant */
  static int aesRCon(int inRound) {
    return (int) AES_RCON[inRound];
  }

  /** 
   * Function that treats input string like a byte array and returns the corresponding byte
   *  Each character in a java string is a nibble, so we need to return a full byte 
   *  @param inString  String to index into
   *  @param index     index of the byte to retrieve from the string
   *  @return          Byte value, corresponds to two characters in string 
   */
  static int getByte(String inString, int index) {
    // Ending and Starting indicies for Java substring
    // *Note* Strings are made up of pairs of bytes, need to get two entries in the string
    int start_index = index * 2;
    int end_index = (index * 2) + 2;

    // Adjust for bounds overflow, just in case 
    if (start_index > inString.length()) start_index = inString.length();
    if (end_index > inString.length()) end_index = inString.length();

    // Grab the string and return the type converted to an 8 bit int
    String byte_string = inString.substring(start_index, end_index);
    return Integer.parseInt(byte_string, 16);
  }

  /** 
   * Construct 128Bit Column Major Key Matrix
   *  @param inKey 128bit Hex String representing a key 
   *  @return      4x4 matrix of bytes of key, in *column-major* order
   */
  static int[][] makeHexMatrix(String inKey) {
    int[][] key_matrix = new int[MX_ORDER][MX_ORDER];
    for (int idx = 0; idx < KEY_BYTES; idx++) {
      key_matrix[idx % MX_ORDER][idx / MX_ORDER] = getByte(inKey, idx);
    }
    return key_matrix;
  }

  /**
   * Util function to flatten Matrix result of Key Rounds 
   * @param roundKeymatrix 4x11 matrix of round keys to flatten
   * @return               String[11] of Hex Round Keys
   */
  static String[] flattenRoundKeyMatrix(int[][] roundKeyMatrix) {
    String[] round_keys = new String[KEY_ROUNDS];
    Arrays.fill(round_keys, "");

    for (int key_round = 0; key_round < KEY_ROUNDS; key_round++) {
      for (int column = 0; column < MX_ORDER; column++) {
        for (int row = 0; row < MX_ORDER; row++) {
          int integer_key = roundKeyMatrix[row][(key_round * MX_ORDER) + column];          
          round_keys[key_round] += String.format("%02X", integer_key);
        }
      } 
    }

    return round_keys;
  }

  static String flattenHexMatrix(int[][] hexMatrix) {
    String hex_result = "";
    for (int column = 0; column < MX_ORDER; column++) {
      for (int row = 0; row < MX_ORDER; row++) {
        hex_result += String.format("%02X", hexMatrix[row][column]);
      }
    } 
    return hex_result;
  }

  /** 
   * Gets the 11 AES Round Keys as a Hex String Array 
   * @param inKey the String hexidecimal representation of an AES key 
   * @return 11 Round Keys in String hexidecimal representation 
   */
  static String[] aesRoundKeys(String inKey) {
    int[][] key_matrix = makeHexMatrix(inKey);
    int[][] round_matrix = new int[MX_ORDER][MX_ORDER * KEY_ROUNDS];

    // Iterate column by column for each column major matrix of round keys
    //  total number of iterations is the 4 columns per round x 11 key rounds
    for (int column = 0; column < MX_ORDER * KEY_ROUNDS; column++) {
      int current_round = column / MX_ORDER;
      Boolean new_round = ((column % MX_ORDER) == 0);
      Boolean first_round = (current_round == 0);

      // The first key round is equal to the input key 
      if (first_round) {
        for (int row = 0; row < MX_ORDER; row++) {
          round_matrix[row][column] = key_matrix[row][column];
        }
      }
      // The first new round (excluding the zeroth), is given by 
      //  the transformation of column xor'd with the previous round
      else if (new_round) {
        int[] temp_array = new int[MX_ORDER];

        temp_array[0] = aesRCon(current_round) ^ aesSBox(round_matrix[1][column - 1]);
        temp_array[1] = aesSBox(round_matrix[2][column - 1]);
        temp_array[2] = aesSBox(round_matrix[3][column - 1]);
        temp_array[3] = aesSBox(round_matrix[0][column - 1]);

        for (int row = 0; row < MX_ORDER; row++) {
          round_matrix[row][column] = round_matrix[row][column - 4] ^ temp_array[row];
        }
      }
      // The remaining rounds are xor'd with the same word in the previous round
      else {
        for (int row = 0; row < MX_ORDER; row++) {
          round_matrix[row][column] = round_matrix[row][column - 4] ^ round_matrix[row][column - 1];
        }
      }
    }

    // Return the flattened round key array
    return flattenRoundKeyMatrix(round_matrix);
  }

  static String AESEncrypt(String pTextHex, String inKeyHex) {
    int[][] key_matrix = makeHexMatrix(inKeyHex);
    printMatrix(key_matrix);

    return new String();
  }


  // AES FUNCTIONS (LAB 5)
  // ===================================
  static int[][] AESStateXOR(int[][] sHex, int[][] keyHex) {
    int[][] result_matrix = new int[MX_ORDER][MX_ORDER];

    for (int row = 0; row < MX_ORDER; row++) {
      for (int column = 0; column < MX_ORDER; column++) {
        result_matrix[row][column] = sHex[row][column] ^ keyHex[row][column];
      }
    }

    return result_matrix;
  }

  static int[][] AESNibbleSub(int[][] inState) {
    int[][] result_matrix = new int[MX_ORDER][MX_ORDER];

    for (int row = 0; row < MX_ORDER; row++) {
      for (int column = 0; column < MX_ORDER; column++) {
        result_matrix[row][column] = aesSBox(inState[row][column]);
      }
    }

    return result_matrix;
  }

  static int[][] AESShiftRow(int[][] inState) {
    int[][] result_matrix = new int[MX_ORDER][MX_ORDER];

    for (int row = 0; row < MX_ORDER; row++) {
      for (int column = 0; column < MX_ORDER; column++) {
        int old_column = (column + row) % MX_ORDER; // Rotate the column value, but wrap
        result_matrix[row][column] = inState[row][old_column];
      }
    }

    return result_matrix;
  }

  static int AESGMult(int lhs, int rhs) {
    int ret_value = 0;
    Boolean lhs_high_bit = false;
    Boolean rhs_low_bit = false;

    for (int idx = 0; idx < 8; idx++) {
      lhs_high_bit = ((lhs & 0x80) == 0x80);
      rhs_low_bit = ((rhs & 0x01) == 0x01);

      if (rhs_low_bit) {
        ret_value ^= lhs;
      } 
      lhs <<= 1;

      if (lhs_high_bit) {
        lhs ^= 0x1B;
      }
      rhs >>= 1;
    }

    // Only dealing with bytes, wrap the result on 256 (1 Byte of data)
    return Math.floorMod(ret_value, 256); 
  }

  static int[] AESMixColumn(int[] inCol) {
    int[] result_column = new int[MX_ORDER];

    result_column[0] = AESGMult(inCol[0], 2) ^ AESGMult(inCol[1], 3) ^ AESGMult(inCol[2], 1) ^ AESGMult(inCol[3], 1); 
    result_column[1] = AESGMult(inCol[0], 1) ^ AESGMult(inCol[1], 2) ^ AESGMult(inCol[2], 3) ^ AESGMult(inCol[3], 1); 
    result_column[2] = AESGMult(inCol[0], 1) ^ AESGMult(inCol[1], 1) ^ AESGMult(inCol[2], 2) ^ AESGMult(inCol[3], 3); 
    result_column[3] = AESGMult(inCol[0], 3) ^ AESGMult(inCol[1], 1) ^ AESGMult(inCol[2], 1) ^ AESGMult(inCol[3], 2); 

    return result_column;
  }

  static int[][] AESMixColumns(int[][] inState) {
    int[][] result_matrix = new int[MX_ORDER][MX_ORDER]; 

    for (int column = 0; column < MX_ORDER; column++) {
      int[] column_array = new int[MX_ORDER];

      for (int row = 0; row < MX_ORDER; row++) {
        column_array[row] = inState[row][column];
      }
      
      int[] mixed_column = AESMixColumn(column_array);

      for (int row = 0; row < MX_ORDER; row++) {
        result_matrix[row][column] = mixed_column[row];
      }
    }

    return result_matrix;
  }

  // END AES FUNCTIONS (LAB 5)
  // ===================================

  /** *DEBUG* Uses STDOUT To print matrix */
  static void printMatrix(int[][] inMatrix) {
    for (int row = 0; row < inMatrix.length; row++) {
      for (int column = 0; column < inMatrix[row].length; column++) {
        System.out.print(String.format("%02X", inMatrix[row][column]) + " | ");
      }
      System.out.println();
    }
    System.out.println();
  } 

}