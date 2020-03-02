import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    TaskA solver = new TaskA();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int[] a = new int[21];
      for (int i = 0; i < 21; i++) {
        a[i] = i;
      }
      for (int i = 0; i < 10; i++) {
        int b = in.nextInt();
        int e = in.nextInt();
        while (b <= e) {
          int t = a[b];
          a[b] = a[e];
          a[e] = t;
          b++;
          e--;
        }
      }
      for (int i = 1; i < 20; i++) {
        out.print(a[i] + " ");
      }
      out.println(a[20]);
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