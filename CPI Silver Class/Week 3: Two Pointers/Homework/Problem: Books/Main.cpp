#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, t;
    cin >> n >> t;

    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int result = 0;
    for (int i = 0, j = -1; i < n; i++) {
        while (j + 1 < n && a[j + 1] <= t) {
            t -= a[++j];
        }
        result = max(result, j - i + 1);
        if (i - 1 == j) {
            j++;
        } else {
            t += a[i];
        }
    }

    cout << result << endl;

    return 0;
}
