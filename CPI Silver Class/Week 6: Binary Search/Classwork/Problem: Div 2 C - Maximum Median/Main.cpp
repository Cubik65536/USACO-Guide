#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int n, k;
int a[200005];

ll numOps(ll m) {
	ll result = 0;
	for (int i = n / 2; i < n; i++)
		result += max(0LL, m - a[i]);
	return result;
}

int main() {
    cin >> n >> k;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    sort(a, a + n);

    ll left = 1, right = 2000000000;
    while (left < right) {
        ll m = (left + right + 1) / 2;
        if (numOps(m) <= k) {
			left = m;
        } else {
			right = m - 1;
        }
    }

    cout << left << endl;

    return 0;
}
