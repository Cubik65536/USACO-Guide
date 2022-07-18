#include <bits/stdc++.h>

using namespace std;

using vi = vector<int>;

const int MAX_N = 100;
const int MAX_SUM = 1e5;

bool dp[MAX_N + 1][MAX_SUM + 1];

int main() {
    int n;
    cin >> n;

    vi x(n);
    for (int i = 0; i < n; i++) {
        cin >> x[i];
    }

    dp[0][0] = true;

    for (int i = 1; i <= n; i++) {
        for (int current_sum = 0; current_sum <= MAX_SUM; current_sum++) {
            dp[i][current_sum] = dp[i - 1][current_sum];
            int prev_sum = current_sum - x[i - 1];
            if (prev_sum >= 0 && dp[i - 1][prev_sum]) {
                dp[i][current_sum] = true;
            }
        }
    }

    vi possible = vi();
    for (int sum = 1; sum <= MAX_SUM; sum++) {
        if (dp[n][sum]) {
            possible.push_back(sum);
        }
    }

    cout << possible.size() << endl;

    for (int sum : possible) {
        cout << sum << " ";
    }
    cout << endl;

    return 0;
}
