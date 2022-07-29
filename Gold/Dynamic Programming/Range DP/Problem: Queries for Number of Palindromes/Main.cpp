#include <iostream>

using namespace std;

const int MAX_N = 5000 + 1;

string s;
int string_len, q, dp[MAX_N][MAX_N];
int is_palindrome[MAX_N][MAX_N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> s;
    string_len = s.size();

    for (int i = 0; i < string_len; i++) {
        dp[i][i] = 1;
        is_palindrome[i][i] = 1;
        is_palindrome[i + 1][i] = 1;
    }

    for (int len = 2; len <= string_len; len++) {
        for (int start = 0; start <= string_len - len; start++) {
            is_palindrome[start][start + len - 1] = is_palindrome[start + 1][start + len - 2] & s[start] == s[start + len - 1];
            dp[start][start + len - 1] = dp[start][start + len - 2] + dp[start + 1][start + len - 1] -
                                         dp[start + 1][start + len - 2] + is_palindrome[start][start + len - 1];
        } 
    }

    cin >> q;

    while (q--) {
        int l, r;
        cin >> l >> r;
        cout << dp[--l][--r] << "\n";
    }

    return 0;
}
