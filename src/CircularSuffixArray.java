import java.util.Arrays;

public class CircularSuffixArray {

  private final String string;
  private final CircularSuffix[] circularSuffixes;

  private class CircularSuffix implements Comparable<CircularSuffix> {

    private final int index;

    public CircularSuffix(int index) {
      this.index = index;
    }

    @Override
    public int compareTo(CircularSuffix other) {
      for (int i = 0; i < length(); i++) {
        char c1 = string.charAt((i + index) % length());
        char c2 = string.charAt((i + other.index) % length());
        if (c1 > c2) {
          return 1;
        }
        if (c1 < c2) {
          return -1;
        }
      }
      return 0;
    }
  }

  public CircularSuffixArray(String s) {
    if (s == null) {
      throw new IllegalArgumentException();
    }
    string = s;
    int length = s.length();
    circularSuffixes = new CircularSuffix[length];
    for (int i = 0; i < length; i++) {
      circularSuffixes[i] = new CircularSuffix(i);
    }
    Arrays.sort(circularSuffixes);
  }

  public int length() {
    return string.length();
  }

  public int index(int i) {
    if (i < 0 || i >= length()) {
      throw new IllegalArgumentException();
    }
    return circularSuffixes[i].index;
  }

  public static void main(String[] args) {
    CircularSuffixArray csa = new CircularSuffixArray("ABRACADABRA!");
    System.out.println(csa.index(11));
  }
}
