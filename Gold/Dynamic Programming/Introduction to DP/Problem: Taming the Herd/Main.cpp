#include <bits/stdc++.h>

using namespace std;

using vi = vector<int>;

int main() {
    freopen("taming.in", "r", stdin);
	freopen("taming.out", "w", stdout);

    int n;
    cin >> n;

    vi a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    vector<vi> range_result(n, vi(n));
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (j) {
				range_result[i][j] = range_result[i][j - 1] + (a[j] == j - i ? 0 : 1);
			} else {
				range_result[i][j] = (a[j] == j - i ? 0 : 1);
			}
        }
    }

    vector<vi> dp(n + 1, vi(n, INT_MAX));
    for (int i = 1; i <= n; i++) {
        for (int j = i - 1; j < n; j++) {
            if (!j) {
				if (a[j] == 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = 1;
				}
				continue;
			}

            if (dp[i][j - 1] != INT32_MAX) {
				dp[i][j] = dp[i][j - 1] + 1;
			}

			if (a[j] && dp[i - 1][j - 1] != INT32_MAX) {
				dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + 1);
			}

			if (j - a[j] - 1 >= 0 && dp[i - 1][j - a[j] - 1] != INT32_MAX) {
				dp[i][j] = min(dp[i][j], dp[i - 1][j - a[j] - 1] + range_result[j - a[j]][j]);
			}

			if (j - a[j] == 0 && i == 1) {
				dp[i][j] = min(dp[i][j], range_result[j - a[j]][j]);
			}
        }
    }

    for (int i = 1; i <= n; i++) {
        cout << dp[i][n - 1] << endl;
    }

    return 0;
}
