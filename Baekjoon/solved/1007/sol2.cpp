#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const int N = 20;

int n;
int x[N];
int y[N];
ll ans;

void Dfs(int depth, int balance, ll vx, ll vy) {
  if (depth == n) {
    if (balance == 0) ans = min(ans, vx * vx + vy * vy);
    return;
  }
  Dfs(depth + 1, balance, vx + x[depth], vy + y[depth]);
  if (balance > 0) Dfs(depth + 1, balance - 1, vx - x[depth], vy - y[depth]);
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout << fixed << setprecision(17);
  int tt;
  cin >> tt;
  while (tt--) {
    cin >> n;
    for (int i = 0; i < n; i++) {
      cin >> x[i] >> y[i];
    }
    ans = (ll) 1e18;
    Dfs(0, n / 2, 0LL, 0LL);
    cout << sqrt(ans) << '\n';
  }
  return 0;
}
