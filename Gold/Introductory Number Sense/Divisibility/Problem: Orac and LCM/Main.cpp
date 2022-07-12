#include <bits/stdc++.h>

using namespace std;

using ll = long long;

ll current_gcd, second_gcd;

void restore_invariant() {
    ll g = gcd(current_gcd, second_gcd);
    tie(current_gcd, second_gcd) = make_pair(g, current_gcd / g * second_gcd);
}

int main() {
    int n;
    cin >> n >> current_gcd >> second_gcd;
    restore_invariant();

    for (int i = 2; i < n; i++) {
        ll x;
        cin >> x;
        second_gcd = gcd(second_gcd, x);
        restore_invariant();
    }

    cout << second_gcd << endl;

    return 0;
}
