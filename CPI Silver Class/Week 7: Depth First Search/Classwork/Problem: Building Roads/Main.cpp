#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1e5 + 10;
vector<int> adj[MAX_N];
bool visited[MAX_N];

void dfs(int u) {
    visited[u] = true;
    for (int v : adj[u]) {
        if (!visited[v]) {
            dfs(v);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        u--; v--;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<int> results;
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i);
            results.push_back(i);
        }
    }

    cout << results.size() - 1 << endl;
    for (int i = 0; i < results.size() - 1; i++) {
        cout << results[i] + 1 << " " << results[i + 1] + 1 << endl;
    }

    return 0;
}
