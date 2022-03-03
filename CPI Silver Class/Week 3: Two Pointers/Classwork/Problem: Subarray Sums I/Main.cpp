#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, x;
    cin >> n >> x;

    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int sum = 0;
    int result = 0;

    for (int i = 0, j = 0; j < n; j++) {
        sum += a[j];
        while (i <= j && sum > x) {
            sum -= a[i++];
        }
        result += sum == x;
    }

    cout << result << endl;

    return 0;
}
