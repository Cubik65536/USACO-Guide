#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using vi = vector<int>;

const int MOD = 1e9 + 7;

ll dp[1000000 + 1];

int main() {
    int n, x;
    cin >> n >> x;

    vi c(n);
    for (int i = 0; i < n; i++) {
        cin >> c[i];
    }

    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
        for (int sum = 0; sum <= x; sum++) {
            if (sum - c[i - 1] >= 0) {
                dp[sum] += dp[sum - c[i - 1]];
                dp[sum] %= MOD;
            }
        }
    }

    cout << dp[x] << endl;

    return 0;
}
