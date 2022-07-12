#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const int MAX_N = 501;
const int MOD = 998244353;

int c[MAX_N][MAX_N], dp[MAX_N][MAX_N];

int add(int x, int y) {
    x += y;
    if (x >= MOD) {
        x -= MOD;
    }
    return x;
}

int mul(int x, int y) {
    return 1ll * x * y % MOD;
}

int main() {
    int n, x;
    cin >> n >> x;

    for (int i = 0; i <= n; i++) {
        c[i][0] = c[i][i] = 1;
        for (int j = 1; j < i; j++) {
            c[i][j] = add(c[i - 1][j], c[i - 1][j - 1]);
        }
    }

    dp[n][0] = 1;
    for (int i = n; i > 1; i--) {
        for (int j = 0; j < x; j++) {
            if (!dp[i][j]) {
                continue;
            }
            int pw = 1, nj = min(x, j + i - 1);
            for (int k = i; k >= 0; k--) {
                dp[k][nj] = add(dp[k][nj], mul(dp[i][j], mul(c[i][k], pw)));
                pw = mul(pw, nj - j);
            }
        }
    }

    int result = 0;
    for (int i = 0; i <= x; i++) {
        result = add(result, dp[0][i]);
    }
    cout << result << endl;

    return 0;
}
