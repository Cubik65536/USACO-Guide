#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int sign(int x) {
    return x % 2 == 0 ? 1 : -1;
}

ll llabs(int x) {
    return x < 0 ? -x : x;
}

set<ll> F;

ll solve(ll sumA) {
    ll result = LLONG_MAX;
    auto f = F.lower_bound(sumA);
    if (f != F.end()) {
        result = min(result, llabs(sumA - *f));
    }
    if (f != F.begin()) {
        f--;
        result = min(result, llabs(sumA - *f));
    }
    return result;
}

int main() {
    int n, m, q;
    cin >> n >> m >> q;

    ll a[100005];
    ll sumA = 0;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        sumA += a[i] * sign(i - 1);
    }

    ll b[100005];
    ll sumB = 0;
    for (int i = 1; i <= n; i++) {
        cin >> b[i];
        sumB += b[i] * sign(i);
    }

    F.insert(sumB);

    for (int i = n + 1; i <= m; i++) {
        cin >> b[i];
        sumB += b[i - n];
        sumB *= -1;
        sumB += b[i] * sign(n);
        F.insert(sumB);
    }

    cout << solve(-sumA) << endl;

    while (q--) {
        int l, r;
        ll x;
        cin >> l >> r >> x;
        if ((r - l + 1) % 2 == 1) {
            if (l % 2 == 1)
                sumA += x;
            else
                sumA -= x;
        }
        cout << solve(-sumA) << endl;
    }
}
