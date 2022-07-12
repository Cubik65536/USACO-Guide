#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const ll MAXN = 300500;
const ll MOD = 1e9 + 7;

ll fac[MAXN];
ll inv[MAXN];

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

void factorial() {
	fac[0] = 1;
	for (int i = 1; i < MAXN; i++) {
		fac[i] = fac[i - 1] * i % MOD;
	}
}

void inverses() {
	inv[0] = 1;
	for (int i = 1; i < MAXN; i++) {
		inv[i] = binpow(fac[i], MOD - 2, MOD);
	}
}

ll C(int n, int k) {
    if (k > n) {
        return 0;
    }
    return fac[n] * inv[k] % MOD * inv[n - k] % MOD;
}

int main() {
    factorial();
    inverses();

    int t;
    cin >> t;

    while (t--) {
        int n, m, k;
        cin >> n >> m >> k;
        vector<ll> a(n);
        for (ll &e : a) {
            cin >> e;
        }

        sort(a.begin(), a.end());

        ll result = 0;

        for (int i = 0; i < n; i++) {
            int l = i + 1, r = upper_bound(a.begin(), a.end(), a[i] + k) - a.begin();
            result = (result + C(r - l, m - 1)) % MOD;
        }

        cout << result << endl;

    }

    return 0;
}
