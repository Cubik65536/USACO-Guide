#include <bits/stdc++.h>
using namespace std;

bool connected[200][200];
vector<bool> visited;

int n;

int dfs(int v) {
    visited[v] = true;

    int cows = 0;

    for (int i = 0; i < n; i++) {
        if (visited[i] || !connected[v][i]) {
            continue;
        }
        visited[i] = true;
        cows += dfs(i) + 1;
    }

    return cows;
}

int main() {
    freopen("moocast.in", "r", stdin);
    freopen("moocast.out", "w", stdout);

    cin >> n;
    vector<int> x(n), y(n), p(n);

    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i] >> p[i];
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
			int sumDist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
			int hip = p[i] * p[i];
            if (sumDist <= hip) {
                connected[i][j] = true;
            }
        }
    }

    int result = 0;

    for (int i = 0; i < n; i++) {
        visited.assign(n, false);
        result = max(result, dfs(i) + 1);
    }

    cout << result << endl;

    return 0;
}
