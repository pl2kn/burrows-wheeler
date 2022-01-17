import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

  private static final int R = 256;

  public static void encode() {
    char[] positions = new char[R];
    for (char i = 0; i < R; i++) {
      positions[i] = i;
    }
    while (!BinaryStdIn.isEmpty()) {
      char c = BinaryStdIn.readChar();
      char previousC = positions[0];
      for (char i = 1; i < R; i++) {
        if (previousC == c) {
          positions[0] = c;
          BinaryStdOut.write((char) (i - 1));
          break;
        }
        char currentC = positions[i];
        positions[i] = previousC;
        previousC = currentC;
      }
    }
    BinaryStdOut.close();
  }

  public static void decode() {
    char[] positions = new char[R];
    for (char i = 0; i < R; i++) {
      positions[i] = i;
    }
    while (!BinaryStdIn.isEmpty()) {
      char position = BinaryStdIn.readChar();
      char tempC = positions[position];
      BinaryStdOut.write(tempC);
      for (char i = position; i > 0; i--) {
        positions[i] = positions[i - 1];
      }
      positions[0] = tempC;
    }
    BinaryStdOut.close();
  }

  public static void main(String[] args) {
    if (args[0].equals("-")) {
      encode();
    } else if (args[0].equals("+")) {
      decode();
    } else {
      throw new IllegalArgumentException("Illegal command line argument");
    }
  }
}
