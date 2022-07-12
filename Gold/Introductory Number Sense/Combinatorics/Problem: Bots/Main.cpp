#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using pii = pair<int, int>;

const int MOD = 1e9 + 7;

ll binpow(ll x, ll n, ll m) {
    assert(n >= 0);
    x %= m;
    ll result = 1;
    while (n > 0) {
        if (n % 2 == 1) {
            result = result * x % m;
        }
        x = x * x % m;
        n /= 2;
    }
	return result;
}

ll mod_inv(ll n) {
    return binpow(n, MOD - 2, MOD);
}

int main() {
    int n;
    cin >> n;

    pii result_binom{n * 2 + 2, n + 1};

    ll result = 1;
    for (int i = result_binom.first; i > result_binom.first - result_binom.second; i--) {
		result = result * i % MOD;
	}
	for (int i = 1; i <= result_binom.second; i++) {
		result = result * mod_inv(i) % MOD;
	}

    cout << result - 1 << endl;

    return 0;

}
