#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int main() {
    int n;
    cin >> n;

    int p[n];
    for (int i = 0; i < n; i++) {
        cin >> p[i];
    }

    sort(p, p + n);

    int median = p[n / 2];

    ll result = 0;
    for (int i = 0; i < n; i++) {
        result += abs(p[i] - median);
    }

    cout << result << endl;

    return 0;
}
