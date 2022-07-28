#include <bits/stdc++.h>

using namespace std;

const int MAX_N = 500;

int dp[MAX_N + 2][MAX_N + 2];

int main() {
    string s;
    cin >> s;
    
    for (int end = 0; end <= s.size(); end++) {
        for (int start = 0; start < s.size() - end; start++) {
            dp[start][start + end] = dp[start + 1][start + end] + 1;
            for (int k = start + 1; k <= start + end; k++) {
                if (s[k] == s[start]) {
                    dp[start][start + end] = min(dp[start][start + end], dp[start + 1][k - 1] + dp[k + 1][start + end]);
                }
            }
        }
    }

    cout << dp[0][s.size() - 1] << endl;

    return 0;
}
