#include <bits/stdc++.h>

using namespace std;

using pii = pair<int, int>;

const int MOD = 1e9 + 7;

int main() {
    freopen("help.in", "r", stdin);
    freopen("help.out", "w", stdout);

    int n;
    cin >> n;

    vector<pii> v(n);
    for (int i = 0; i < n; i++) {
        cin >> v[i].first >> v[i].second;
    }

    vector<int> over(2 * n + 1), po2(n);

    po2[0] = 1;
    for (int i = 1; i < n; i++) {
        po2[i] = 2 * po2[i - 1] % MOD;
    }

    for (int i = 0; i < n; i++) {
        over[v[i].first]++;
        over[v[i].second]--;
    }

    for (int i = 1; i <= 2 * n; i++) {
        over[i] += over[i - 1];
    }

    int result = 0;

    for (int i = 0; i < n; i++) {
        result += po2[n - 1 - over[v[i].first - 1]];
        result %= MOD;
    }

    cout << result << endl;

    return 0;
}
