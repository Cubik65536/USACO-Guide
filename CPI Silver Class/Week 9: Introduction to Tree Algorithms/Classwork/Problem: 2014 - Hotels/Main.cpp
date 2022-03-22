#include<bits/stdc++.h>
using namespace std;

using ll = long long;

const int MAX_N = 5005;

vector<int> adj[MAX_N];
int total[MAX_N], current[MAX_N], pre[MAX_N];

ll result;

int dfs1(int v, int parent = -1, int d = 0) {
    total[d]++;
    int result = d;
    for (int u : adj[v]) {
        if (u != parent) {
            result = max(result, dfs1(u, v, d + 1));
        }
    }
    return result;
}

int dfs2(int v, int parent, int d = 1) {
    current[d]++;
    int result = d;
    for (int u : adj[v]) {
        if (u != parent) {
            result = max(result, dfs2(u, v, d + 1));
        }
    }
    return result;
}

int main() {
    int n;
    cin >> n;

    if (n < 4) {
        cout << 0 << endl;
        return 0;
    }

    for (int i = 1; i < n; i++) {
        int a, b;
        cin >> a >> b;
        a--; b--;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for(int i = 0; i < n; i++){
        int m = adj[i].size();
		int d1 = dfs1(i);
		for(int v: adj[i]){
			int d2 = dfs2(v, i);
			for(int d = 1; d <= d2; d++){
				result += pre[d] * current[d] * (total[d] - pre[d] - current[d]);
				pre[d] += current[d];
				current[d] = 0;
			}
		}
		for(int d = 0; d <= d1; d++){
			total[d] = 0;
			pre[d] = 0;
			current[d] = 0;
		}
	}

    cout << result << endl;

    return 0;
}
