#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    double a[n + 1], b[n + 1];
    for (int i = 1; i <= n; i++) {
        cin >> a[i] >> b[i];
        a[i] -= 1.0;
        b[i] -= 1.0;
    }

    sort(a + 1, a + n + 1, greater<double>());
    sort(b + 1, b + n + 1, greater<double>());

    for (int i = 1; i <= n; i++) {
        a[i] += a[i - 1];
        b[i] += b[i - 1];
    }

    double result = 0.0;
    for (int na = 0, nb = 0; na <= n; na++) {
        while (nb <= n && min(a[na] - nb, b[nb] - na) <= min(a[na] - (nb + 1), b[nb + 1] - na)) {
            nb++;
        }
        result = max(result, min(a[na] - nb, b[nb] - na));
    }

    cout << fixed << setprecision(4) << result << endl;

    return 0;
}
