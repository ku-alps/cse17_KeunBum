import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {
	void solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n + 1];
		for (int i = 0; i < n; i++) a[i] = in.nextInt();
		int[] b = new int[m + 1];
		for (int i = 0; i < m; i++) b[i] = in.nextInt();
		a[n] = b[m] = (int) 1e9;
		int p_a = 0, p_b = 0;
		while (p_a < n || p_b < m) {
			if (a[p_a] < b[p_b]) {
				out.print(a[p_a] + " ");
				++p_a;
			} else {
				out.print(b[p_b] + " ");
				++p_b;
			}	
		}
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

		public String nextLn() {
			try {
				return br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}	
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
