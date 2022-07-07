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

int main() {
    int t;
    cin >> t;

    while (t--) {
        int a, b;
        cin >> a >> b;
        cout << binpow(a, b, MOD) << endl;
    }
}
