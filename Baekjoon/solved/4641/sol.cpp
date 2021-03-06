#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  while (true) {
    vector<int> a;
    vector<bool> was(200, false);
    while (true) {
      int t;
      cin >> t;
      if (t == -1) return 0;
      if (t == 0) break;
      was[t] = true;
      a.push_back(t);
    }
    int ans = 0;
    for (int x : a) {
      ans += (int) was[x + x];
    }
    cout << ans << '\n';
  }
  return 0;
}