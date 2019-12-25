import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Task solver = new Task();
    solver.solve(1, in, out);
    out.close();
  }
  static class Task {
    static final int inf = (int) 1e9;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();
      int[] a = new int[n + 1];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }
      int[] b = new int[m + 1];
      for (int i = 0; i < m; i++) {
        b[i] = in.nextInt();
      }
      int ia = 0, ib = 0;
      a[n] = b[m] = inf;
      while (ia < n || ib < m) {
        if (a[ia] > b[ib]) {
          out.print(b[ib++] + " ");
        } else {
          out.print(a[ia++] + " ");
        }
      }
    }
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;
    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }
    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }
    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}