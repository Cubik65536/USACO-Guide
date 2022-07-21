#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const int MAX_N = 1000;
const int MOD = 1e9 + 7;

bool grid[MAX_N][MAX_N];
ll dp[MAX_N][MAX_N];

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string line;
        cin >> line;
        for (int j = 0; j < n; j++) {
            if (line[j] == '.') {
                grid[i][j] = true;
            } else {
                grid[i][j] = false;
            }
        }
    }

    dp[0][0] = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!grid[i][j]) {
                dp[i][j] = 0;
                continue;
            }
            if (i > 0) {
                dp[i][j] += dp[i - 1][j];
            }
            if (j > 0) {
                dp[i][j] += dp[i][j - 1];
            }
            dp[i][j] %= MOD;
        }
    }

    cout << dp[n - 1][n - 1] << endl;

    return 0;
}
