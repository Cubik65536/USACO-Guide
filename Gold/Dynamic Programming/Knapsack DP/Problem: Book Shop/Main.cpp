#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using vi = vector<int>;

const int MAX_N = 1000 + 1;
const int MAX_X = 100000 + 1;

int dp[MAX_N][MAX_X];

int main() {
    int n, x;
    cin >> n >> x;

    vi h(n);
    for (int i = 0; i < n; i++) {
        cin >> h[i];
    }

    vi s(n);
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }

    for (int i = 1; i <= n; i++) {
        int current_cost = h[i - 1];
        int current_pages = s[i - 1];
        for (int j = 1; j <= x; j++) {
            dp[i][j] = dp[i - 1][j];
            if (current_cost <= j) {
                dp[i][j] = max(dp[i][j], dp[i - 1][j - current_cost] + current_pages);
            }
        }
    }

    cout << dp[n][x] << endl;

    return 0;
}
