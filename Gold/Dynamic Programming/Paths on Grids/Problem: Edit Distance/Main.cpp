#include <bits/stdc++.h>

using namespace std;

using vi = vector<int>;

int main() {
    string text1, text2;
    cin >> text1 >> text2;

    int n = text1.size(), m = text2.size();

    vector<vi> dp(n + 1, vi(m + 1, INT32_MAX));
    dp[0][0] = 0;

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            if (i != 0) {
                dp[i][j] = min(dp[i][j], dp[i - 1][j] + 1);
            }
            if (j != 0) {
                dp[i][j] = min(dp[i][j], dp[i][j - 1] + 1);
            }
            if (i != 0 && j != 0) {
				int new_cost = dp[i - 1][j - 1] + (text1[i - 1] != text2[j - 1]);
				dp[i][j] = min(dp[i][j], new_cost);
			}
        }
    }

    cout << dp[n][m] << endl;

    return 0;
}
