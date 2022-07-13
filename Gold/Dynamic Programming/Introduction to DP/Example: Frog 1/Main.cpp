#include <bits/stdc++.h>

using namespace std;

const int MAX_N = 1e5;

int h[MAX_N + 1];
int dp[MAX_N + 1];

int main() {
    int n;
    cin >> n;
    for  (int i = 1; i <= n; i++) {
        cin >> h[i];
    }

    dp[1] = 0;
    for (int i = 2; i <= n; i++) {
        dp[i] = INT32_MAX;
    }

    for (int i = 1; i <= n; i++) {
        if (i + 1 <= n) {
            dp[i + 1] = min(dp[i + 1], dp[i] + abs(h[i + 1] - h[i]));
        }
        if (i + 2 <= n) {
            dp[i + 2] = min(dp[i + 2], dp[i] + abs(h[i + 2] - h[i]));
        }
    }

    cout << dp[n] << endl;

    return 0;
}
