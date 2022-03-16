#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1e5 + 10;
vector<int> adj[MAX_N];
int color[MAX_N];

void dfs(int u, int c = 1) {
    color[u] = c;
    for (int v : adj[u]) {
        if (!color[v]) {
            dfs(v, 3 - c);
        } else if (color[v] != 3 - c) {
            cout << "IMPOSSIBLE" << endl;
            exit(0);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        u--, v--;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 0; i < n; i++) {
        if (!color[i]) {
            dfs(i);
        }
    }

    for (int i = 0; i < n; i++) {
        cout << color[i] << " ";
    }
    cout << endl;

    return 0;
}
