import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {
	void solve() {
		int[] a = new int[21];
		for (int i = 1; i <= 20; i++) a[i] = i;
		for (int i = 0; i < 10; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			while (x < y) {
				int t = a[x];
				a[x] = a[y];
				a[y] = t;
				++x;
				--y;
			}
		}
		for (int i = 1; i <= 20; i++) out.print(a[i] + " ");
	}
	
	FastScanner in;
	PrintWriter out;
	
	void run() {
		in = new FastScanner();
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
 
	class FastScanner {
		BufferedReader br;
		StringTokenizer st;
 
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in), 32768);
			st = null;
		}
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
 
	public static void main(String[] args) {
		new Main().run();
	}
}
