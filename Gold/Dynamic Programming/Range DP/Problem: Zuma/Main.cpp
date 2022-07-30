#include <bits/stdc++.h>

using namespace std;

const int MAX_N = 500;

int color[MAX_N + 1];
int dp[MAX_N + 1][MAX_N + 1];

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> color[i];
    }

    for (int len = 1; len <= n; len++) {
        for (int start = 0, end = len - 1; end < n; start++, end++) {
            if (len == 1) {
                dp[start][end] = 1;
            } else {
                dp[start][end] = dp[start + 1][end] + 1;
                if (color[start] == color[start + 1]) {
                    dp[start][end] = min(dp[start][end], dp[start + 2][end] + 1);
                }
                for (int match = start + 2; match <= end; match++) {
                    if (color[start] == color[match]) {
                        dp[start][end] = min(dp[start][end], dp[start + 1][match - 1] + dp[match + 1][end]);
                    }
                }
            }
        }
    }

    cout << dp[0][n - 1] << endl;

    return 0;

}
