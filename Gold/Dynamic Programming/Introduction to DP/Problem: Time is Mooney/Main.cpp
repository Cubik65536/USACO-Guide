#include <bits/stdc++.h>

using namespace std;

using vi = vector<int>;

int main() {
    freopen("time.in", "r", stdin);
    freopen("time.out", "w", stdout);

    int n, m, c;
    cin >> n >> m >> c;

    vi earn(n);
	for (int i = 0; i < n; i++) {
		cin >> earn[i];
	}

    vector<vi> adj(n);
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        u--; v--;
        adj[u].push_back(v);
    }

    vector<vector<int>> dp(1001, vector<int>(n, -1));
    dp[0][0] = 0;

    int result = 0;
    for (int day = 0; day < 1000; day++) {
        for (int city = 0; city < n; city++) {
            if (dp[day][city] == -1) continue;
            for (int u: adj[city]) {
                dp[day + 1][u] = max(dp[day + 1][u], dp[day][city] + earn[u]);
            }
        }
        result = max(result, dp[day][0] - (c * day * day));
    }

    cout << result << endl;

    return 0;
}
