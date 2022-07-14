#include <bits/stdc++.h>

using namespace std;

const int MAX_N = 1e5 + 5;

int dp[MAX_N][25][3];
int a[MAX_N];

int main() {
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);
    
    int n, k;
    cin >> n >> k;

    for (int i = 0; i < n; i++) {
        char c;
        cin >> c;
        if (c == 'H') {
            a[i] = 0;
        } else if (c == 'P') {
            a[i] = 1;
        } else {
            a[i] = 2;
        }
    }

	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= k; j++) {
			for (int k = 0; k < 3; k++) {
				if (k == a[i]) dp[i][j][k]++;
				dp[i + 1][j + 1][0] = max(dp[i + 1][j + 1][0], dp[i][j][k]);
				dp[i + 1][j + 1][1] = max(dp[i + 1][j + 1][1], dp[i][j][k]);
				dp[i + 1][j + 1][2] = max(dp[i + 1][j + 1][2], dp[i][j][k]);
				dp[i + 1][j][k] = max(dp[i + 1][j][k], dp[i][j][k]);
			}
		}
	}


    int result = 0;
    for (int i = 0; i < 3; i++) {
        result = max(result, dp[n - 1][k][i]);
    }

    cout << result << endl;

    return 0;
}
