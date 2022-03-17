#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 3000;

vector<vector<int>> adj(MAX_N);
vector<bool> visited(MAX_N);
vector<bool> closed(MAX_N);

int nodes = 0;

void dfs(int u) {
    if (visited[u] || closed[u]) {
        return;
    }

    nodes++;
    visited[u] = true;

    for (int v : adj[u]) {
        if (!visited[v]) {
            dfs(v);
        }
    }
}

int main() {
    freopen("closing.in", "r", stdin);
    freopen("closing.out", "w", stdout);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<int> order(n);
    for (int i = 0; i < n; i++) {
        cin >> order[i];
    }

    dfs(1);

    if (nodes == n) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }

    for (int i = 0; i < n - 1; i++) {
        nodes = 0;
        closed[order[i]] = true;
        fill(visited.begin(), visited.end(), false);

        dfs(order[n - 1]);

        if (nodes == n - i - 1) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}
