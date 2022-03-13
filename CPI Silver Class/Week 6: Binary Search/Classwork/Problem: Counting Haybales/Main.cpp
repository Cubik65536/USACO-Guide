#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("haybales.in", "r", stdin);
    freopen("haybales.out", "w", stdout);

    int n, q;
    cin >> n >> q;

    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    sort(a, a + n);

    while (q--) {
        int left, right;
        cin >> left >> right;
        cout << upper_bound(a, a + n, right) - lower_bound(a, a + n, left) << endl;
    }
 
    return 0;
}
