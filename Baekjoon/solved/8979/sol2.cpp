#include <iostream>
#include <tuple>

using namespace std;

tuple<int, int, int> a[1234];

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    int x, y, z, w;
    cin >> x >> y >> z >> w;
    a[x] = {y, z, w};
  }
  int ans = 1;
  for (int i = 1; i <= n; i++) {
    if (a[i] > a[k]) ans++;
  }
  cout << ans << '\n';
  return 0;
}