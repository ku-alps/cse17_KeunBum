#include <bits/stdc++.h>

using namespace std;

class BInt {
public:
  const static int LEN = 8;
  const static int SYSTEM = (int) 1e8;
  vector<int> a;
  BInt() {
    *this = BInt("");
  }
  BInt(string s) {
    int n = (int) s.size();
    for (int i = n - 1; i >= 0; i -= LEN) {
      int foo = 0;
      int e = 1;
      for (int j = 0; i - j >= 0 && j < LEN; j++, e *= 10) {
        foo += (s[i - j] - '0') * e;
      }
      push(foo);
    }
  }
  BInt operator*(const BInt& y) const {
    BInt z;
    const BInt& x = *this;
    int n = (int) x.size();
    int m = (int) y.size();
    vector<int> carry(n + m, 0);
    int last = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i + j >= (int) z.size()) {
          z.push(0);
        }
        long long foo = (z[i + j] + ((long long) x[i]) * y[j] + carry[i + j]);
        carry[i + j] = 0;
        carry[i + j + 1] += foo / SYSTEM;
        z[i + j] = foo % SYSTEM;
        last = i + j + 1;
      }
    }
    if (carry[last] > 0) {
      z.push(carry[last]);
    }
    return z;
  }
  void push(int n) {
    a.push_back(n);
  }
  int& operator[](size_t index) {
    return a[index];
  }
  const int& operator[](size_t index) const {
    return a[index];
  }
  size_t size() const noexcept {
    return a.size();
  }
  friend istream& operator>>(istream& stream, BInt& bint);
};

string to_string(const BInt& bint) {
  string z = "";
  int n = (int) bint.size();
  for (int i = n - 1; i >= 0; i--) {
    string foo = to_string(bint.a[i]);
    int m = (int) foo.size();
    string bar = string(bint.LEN - m, '0');
    if (i < n - 1) {
      z += bar;
    }
    z += foo;
  }
  return z;
}

istream& operator>>(istream& stream, BInt& bint) {
  string s;
  stream >> s;
  bint = BInt(s);
  return stream;
}

ostream& operator<<(ostream& stream, const BInt& bint) {
  return stream << to_string(bint);
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  BInt a, b;
  cin >> a >> b;
  cout << a * b << '\n';
  return 0;
}
