#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using vi = vector<int>;

const int MOD = 998244353;

ll pow_mod(ll base, ll exp) {
    base %= MOD;
    ll result = 1;
    while (exp > 0) {
        if (exp % 2 == 1) {
            result = result * base % MOD;
        }
        base = base * base % MOD;
        exp /= 2;
    }
    return result;
}

ll mod_inv(ll n) {
	return pow_mod(n, MOD - 2);
}

ll frac_total(ll num, ll denom) {
	return ((num % MOD) * mod_inv(denom)) % MOD;
}

int main() {
    int n;
    cin >> n;

    vector<vi> children(n);
    unordered_map<int, int> wanter_num;

    for (int c = 0; c < n; c++) {
        int k;
        cin >> k;
        while (k--) {
            int a;
            cin >> a;
            wanter_num[a]++;
            children[c].push_back(a);
        }
    }

    ll result = 0;
    for (const vi& child : children) {
        for (const int& i : child) {
            int num = wanter_num[i];
            ll denom = n * n * child.size();
            result = (result + frac_total(num, denom)) % MOD;
        }
    }

    cout << result << endl;

    return 0;
}
