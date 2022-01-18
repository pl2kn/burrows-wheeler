import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

  public static void transform() {
    String inputString = BinaryStdIn.readString();
    CircularSuffixArray csa = new CircularSuffixArray(inputString);
    int length = inputString.length();
    for (int i = 0; i < length; i++) {
      if (csa.index(i) == 0) {
        BinaryStdOut.write(i);
        break;
      }
    }
    for (int i = 0; i < length; i++) {
      int lastIndex = (csa.index(i) - 1 + length) % length;
      BinaryStdOut.write(inputString.charAt(lastIndex));
    }
    BinaryStdOut.close();
  }

  public static void inverseTransform() {
    int first = BinaryStdIn.readInt();
    String lastColumn = BinaryStdIn.readString();
    int radix = 256;
    int length = lastColumn.length();
    char[] firstColumn = new char[length];
    int[] count = new int[radix + 1];
    int[] next = new int[length];
    for (int i = 0; i < length; i++) {
      count[lastColumn.charAt(i) + 1]++;
    }
    for (int r = 0; r < radix; r++) {
      count[r + 1] += count[r];
    }
    for (int i = 0; i < length; i++) {
      int position = count[lastColumn.charAt(i)]++;
      firstColumn[position] = lastColumn.charAt(i);
      next[position] = i;
    }
    for (int i = 0; i < length; i++) {
      BinaryStdOut.write(firstColumn[first]);
      first = next[first];
    }
    BinaryStdOut.close();
  }

  public static void main(String[] args) {
    if (args[0].equals("-")) {
      transform();
    } else if (args[0].equals("+")) {
      inverseTransform();
    } else {
      throw new IllegalArgumentException("Illegal command line argument");
    }
  }
}
