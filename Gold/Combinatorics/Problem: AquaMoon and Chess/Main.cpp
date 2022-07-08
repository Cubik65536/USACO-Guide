#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const int MAXN = 100010;
const int MOD = 998244353;

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
	for (int i = 1; i <= MAXN; i++) {
		fac[i] = fac[i - 1] * i % MOD;
	}
}

void inverses() {
	inv[0] = 1;
	for (int i = 1; i <= MAXN; i++) {
		inv[i] = binpow(fac[i], MOD - 2, MOD);
	}
}

int main() {
    factorial();
    inverses();

    int t;
    cin >> t;

    while (t--) {
        int n;
        char str[MAXN];
        cin >> n >> str;

        int g_count = 0;
        int zero_count = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == '0') {
                zero_count++;
            } else if (i + 1 < n && str[i + 1] == '1') {
                g_count++;
                i++;
            } else;
        }

        ll result = fac[g_count + zero_count] * inv[zero_count] % MOD * inv[g_count] % MOD;

        cout << result << endl;

    }

    return 0;
}
