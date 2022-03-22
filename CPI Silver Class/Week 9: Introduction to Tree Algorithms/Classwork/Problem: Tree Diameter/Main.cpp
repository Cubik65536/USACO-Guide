#include<bits/stdc++.h>
using namespace std;

const int MAX_N = 200001;

vector<int> adj[MAX_N];
int f[MAX_N], g[MAX_N];

int result;

void dfs(int v, int parent) {
    vector<int> childList;
    
    for (int child : adj[v])
	if (child != parent) {
        dfs(child, v);
        f[v] = max(f[v], f[child] + 1);
        childList.push_back(f[child]);
	}
    
    result = max(result, f[v]);
    
    sort(childList.begin(), childList.end());
    if (childList.size() >= 2) {
        g[v] = 2 + childList[childList.size() - 1] + childList[childList.size() - 2];
        result = max(result, g[v]);
    }
}

int main() {
    int n;
    cin >> n;

    int a, b;
    for (int i = 1; i < n; i++) {
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    dfs(1, -1);

    cout << result << endl;

    return 0;
}
