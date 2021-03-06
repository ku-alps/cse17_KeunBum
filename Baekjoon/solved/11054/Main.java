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
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }
      int[] u = new int[n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          if (a[j] < a[i]) {
            u[i] = Math.max(u[i], u[j] + 1);
          }
        }
      }
      int[] v = new int[n];
      for (int i = n - 1; i >= 0; i--) {
        for (int j = n - 1; j > i; j--) {
          if (a[j] < a[i]) {
            v[i] = Math.max(v[i], v[j] + 1);
          }
        }
      }
      int ans = 1;
      for (int i = 0; i < n; i++) {
        ans = Math.max(ans, u[i] + v[i] + 1);
      }
      out.println(ans);
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