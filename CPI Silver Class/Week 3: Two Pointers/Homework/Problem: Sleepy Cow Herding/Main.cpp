#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("herding.in", "r", stdin);
    freopen("herding.out", "w", stdout);

    int n;
    cin >> n;

    int herd[n];
    for (int i = 0; i < n; i++) {
        cin >> herd[i];
    }

    sort(herd, herd + n);

    int total = 0;
    for (int i = 1; i < n; i++) {
        total += herd[i] - herd[i - 1] - 1;
    }

    int minimum = INT_MAX;
    if ((herd[n - 2] - herd[0] == n - 2 && herd[n - 1] - herd[n - 2] > 2) 
        || (herd[n - 1] - herd[1] == n - 2 && herd[1] - herd[0] > 2)) {
        minimum = 2;
    } else {
        for (int i = 0, j = 0; i < n; i++) {
            while (j + 1 < n && herd[j + 1] - herd[i] < n) {
                j++;
            }
            minimum = min(minimum, n - (j - i + 1));
        }
    }

    int maximum = max(total - (herd[1] - herd[0] - 1), total - (herd[n - 1] - herd[n - 2] - 1));

    cout << minimum << endl << maximum << endl;

    return 0;
}
