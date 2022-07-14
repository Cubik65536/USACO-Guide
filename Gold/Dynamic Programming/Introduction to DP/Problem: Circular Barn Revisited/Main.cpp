#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const int MAX_N = 100 + 5;
const int MAX_K = 7 + 5;

int main() {
    freopen("cbarn2.in", "r", stdin);
    freopen("cbarn2.out", "w", stdout);

    int N, K;
    cin >> N >> K;

    ll a[MAX_N];
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }

    ll dp[MAX_K][MAX_N];
    ll result = LLONG_MAX;

    for (int i = 0; i < N; i++) {
        memset(dp, 0x3F, sizeof(dp));
        dp[0][N] = 0;
        for (int k = 1; k <= K; k++) {
            for (int j = 0; j < N; j++) {
                long long val = 0;
                for (int l = j + 1; l <= N; l++) {
                    val += a[l - 1] * (l - j - 1);
                    dp[k][j] = min(dp[k][j], val + dp[k - 1][l]);
                }
            }
        }
        result = min(result, dp[K][0]);
        rotate(a, a + 1, a + N);
    }

    cout << result << endl;

    return 0;
}
