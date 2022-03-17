#include <bits/stdc++.h>
using namespace std;

using ll = long long;

const int MAX_N = 100000;

vector<int> adj[MAX_N];

ll c = 0, uc = 0;

void dfs(int node, int parent, bool col) {
    (col ? c : uc)++;
    for (int u: adj[node]) {
        if (u == parent) continue;
        dfs(u, node, !col);
    }
}

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(1, 0, false);

    cout << c * uc - (n - 1) << endl;

    return 0;
}
