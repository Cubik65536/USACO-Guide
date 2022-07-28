#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using vi = vector<int>;

const int MAX_N = 20;
const int MOD = 1e9 + 7;

ll dp[1 << MAX_N][MAX_N];
vi go_to[MAX_N];

int main() {
    int n;
	int m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int start, end;
		cin >> start >> end;
		go_to[--end].push_back(--start);
	}
	
	dp[1][0] = 1;
	for (int s = 2; s < 1 << n; s++) {
		if ((s & (1 << 0)) == 0) {
			continue;
        }

		if ((s & (1 << (n - 1))) && s != ((1 << n) - 1)) {
			continue;
        }

		for (int end = 0; end < n; end++) {
			if ((s & (1 << end)) == 0) {
				continue;
            }
			
			int prev = s - (1 << end);
			for (int j : go_to[end]) {
				if ((s & (1 << j))) {
					dp[s][end] += dp[prev][j];
					dp[s][end] %= MOD;
				}
			}	
		}
	}

	cout << dp[(1 << n) - 1][n - 1] << endl;

    return 0;
}
