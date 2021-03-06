#include <iostream>
#include <vector>

using namespace std;

struct edge {
  int from, to, c, f;
};

vector<edge> edges;
vector<vector<int>> g;
vector<int> d, q, ptr;
int n, st, fin;

void add(int from, int to, int cap) {
  g[from].push_back((int) edges.size());
  edges.push_back({from, to, cap, 0});
  g[to].push_back((int) edges.size());
  edges.push_back({to, from, 0, 0});
}

bool expath() {
  fill(d.begin(), d.end(), -1);
  d[fin] = 0;
  q[0] = fin;
  int beg = 0, end = 1;
  while (beg < end) {
    int i = q[beg++];
    for (int id : g[i]) {
      const edge &e = edges[id];
      const edge &back = edges[id ^ 1];
      if (back.c > back.f && d[e.to] == -1) {
        d[e.to] = d[i] + 1;
        if (e.to == st) {
          return true;
        }
        q[end++] = e.to;
      }
    }
  }
  return false;
}

int dfs(int v, int w) {
  if (v == fin) {
    return w;
  }
  int &j = ptr[v];
  while (j >= 0) {
    int id = g[v][j--];
    const edge &e = edges[id];
    if (e.c > e.f && d[e.to] == d[v] - 1) {
      int t = dfs(e.to, min(w, e.c - e.f));
      if (t > 0) {
        edges[id].f += t;
        edges[id ^ 1].f -= t;
        return t;
      }
    }
  }
  return 0;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int N, M;
  cin >> N >> M;
  st = 0; fin = N + M + 1;
  n = N + M + 2;
  g.resize(n);
  d.resize(n);
  q.resize(n);
  ptr.resize(n);
  for (int i = 1; i <= N; i++) {
    add(st, i, 1);
  }
  for (int i = 1; i <= M; i++) {
    add(N + i, fin, 1);
  }
  for (int i = 1; i <= N; i++) {
    int t;
    cin >> t;
    while (t--) {
      int j;
      cin >> j;
      add(i, N + j, 1);
    }
  }
  int ans = 0;
  while (expath()) {
    for (int i = 0; i < n; i++) {
      ptr[i] = (int) g[i].size() - 1;
    }
    int big_add = 0;
    while (true) {
      int add = dfs(st, 2);
      if (add == 0) break;
      big_add += add;
    }
    if (big_add == 0) break;
    ans += big_add;
  }
  cout << ans << '\n';
  return 0;
}