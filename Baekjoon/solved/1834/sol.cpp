#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long n;
  cin >> n;
  cout << (n - 1) * n / 2 * (n + 1) << '\n';
  return 0;
}
