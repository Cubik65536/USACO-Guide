#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const ll MAXN = 1e6;
const ll MOD = 1e9 + 7;

ll fac[MAXN + 1];
ll inv[MAXN + 1];

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

ll choose(int n, int r) {
	return fac[n] * inv[r] % MOD * inv[n - r] % MOD;
}

int main() {
    factorial();
    inverses();

    int n;
    cin >> n;

    while (n--) {
        int a, b;
        cin >> a >> b;
        cout << choose(a, b) << endl;
    }
    

    return 0;

}
