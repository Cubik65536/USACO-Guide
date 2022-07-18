#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using vi = vector<int>;

ll dp[1000000 + 1];

int main() {
    int n, x;
    cin >> n >> x;

    vi c(n);
    for (int i = 0; i < n; i++) {
        cin >> c[i];
    }

    for (int i = 0; i <= x; i++) {
        // dp[i] = LLONG_MAX;
        dp[i] = INT_MAX;
    }

    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= x; j++) {
            if (j - c[i - 1] >= 0) {
                dp[j] = min(dp[j], dp[j - c[i - 1]] + 1);
            }
        }
    }

    // cout << ((dp[x] == LLONG_MAX) ? -1 : dp[x]) << endl;
    cout << ((dp[x] == INT_MAX) ? -1 : dp[x]) << endl;

    return 0;
}
