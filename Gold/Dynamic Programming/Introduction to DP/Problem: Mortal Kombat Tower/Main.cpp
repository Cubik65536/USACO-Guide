#include <bits/stdc++.h>

using namespace std;

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }

        vector<vector<int>> dp(2, vector<int>(n + 1, 1e9));

        dp[1][0] = 0;

        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = min(dp[0][i + 1], dp[1][i] + a[i]);
            dp[1][i + 1] = min(dp[1][i + 1], dp[0][i]);
            if (i + 2 <= n) {
                dp[0][i + 2] = min(dp[0][i + 2], dp[1][i] + a[i] + a[i + 1]);
                dp[1][i + 2] = min(dp[1][i + 2], dp[0][i]);
            }
        }

        cout << min(dp[0][n], dp[1][n]) << endl;
    }

    return 0;
}
