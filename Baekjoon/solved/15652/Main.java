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
    static PrintWriter out;
    static int n, m;
    static int[] v;
    public void solve(int testNumber, InputReader in, PrintWriter _out) {
      out = _out;
      n = in.nextInt();
      m = in.nextInt();
      v = new int[n + 1];
      dfs(0, 0);
    }
    private void dfs(int x, int y) {
      if (x == m) {
        for (int i = 0; i < m; i++) {
          out.print((i > 0 ? " " : "") + v[i]);
        }
        out.println();
        return;
      }
      for (int i = y; i < n; i++) {
        v[x] = i + 1;
        dfs(x + 1, i);
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