#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const ll MOD = 1e9 + 7;

ll expo(ll base, ll pow) {
    ll result = 1;
    while (pow) {
        if (pow & 1) {
            result = result * base % MOD;
        }
        base = base * base % MOD;
        pow >>= 1;
    }
    return result;
}

ll x[100001], k[100001];

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x[i] >> k[i];
    }

    ll div_cnt = 1, div_sum = 1, div_prod = 1, div_cnt2 = 1;

    for (int i = 0; i < n; i++) {
        div_cnt = div_cnt * (k[i] + 1) % MOD;
		div_sum = div_sum * (expo(x[i], k[i] + 1) - 1) % MOD * expo(x[i] - 1, MOD - 2) % MOD;
		div_prod = expo(div_prod, k[i] + 1) * expo(expo(x[i], (k[i] * (k[i] + 1) / 2)), div_cnt2) % MOD;
		div_cnt2 = div_cnt2 * (k[i] + 1) % (MOD - 1);
    }

    cout << div_cnt << ' ' << div_sum << ' ' << div_prod << endl;

    return 0;
}
