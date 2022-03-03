#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 9;

int main() {
    int n, d;
    cin >> n >> d;

    int blocks[n];
    for (int i = 0; i < n; i++) {
        cin >> blocks[i];
    }

    sort(blocks, blocks + n);

    int result = 1;
    for (int i = 0, j = 0; i < n; i++) {
        while (j < n - 1 && blocks[j + 1] - blocks[i] <= d) {
            j++;
        }
        int dist = j - i + 1;
        result = (result * 1LL * dist) % MOD;
    }

    cout << result << endl;

    return 0;
}
