#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 100005;

vector<int> child[MAX_N];
vector<int> parent[MAX_N];
bool childSeen[MAX_N];
bool parentSeen[MAX_N];

void dfsChild(int node) {
    childSeen[node] = true;
    for (int c : child[node]) {
        if (!childSeen[c]) {
            dfsChild(c);
        }
    }
}

void dfsParent(int node) {
    parentSeen[node] = true;
    for (int p : parent[node]) {
        if (!parentSeen[p]) {
            dfsParent(p);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        child[u].push_back(v);
        parent[v].push_back(u);
    }

    dfsChild(1);
    dfsParent(1);

    for (int i = 1; i <= n; i++) {
        if (!childSeen[i]) {
            cout << "NO" << endl << "1 " << i << endl;
            return 0;
        }
        if (!parentSeen[i]) {
            cout << "NO" << endl << i << " 1" << endl;
            return 0;
        }
    }

    cout << "YES" << endl;

    return 0;
}
