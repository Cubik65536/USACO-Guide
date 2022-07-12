#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const ll MOD = 1e9 + 7;

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

// With Bitwise operations

ll binpow_with_bitwise(ll x, ll n, ll m) {
    assert(n >= 0);
    x %= m;
    ll result = 1;
    while (n > 0) {
        if (n & 1) {
            result = result * x % m;
        }
        x = x * x % m;
        n >>= 1;
    }
    return result;
}

int main() {
    ll n, m;
    cin >> n >> m;
    cout << "binpow: " << endl << binpow(n, m, MOD) << endl;
    cout << "binpow_with_bitwise: " << endl << binpow_with_bitwise(n, m, MOD) << endl;
    return 0;
}
