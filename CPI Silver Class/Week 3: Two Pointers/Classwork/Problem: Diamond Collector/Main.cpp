#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("diamond.in", "r", stdin);
	freopen("diamond.out", "w", stdout);

    int n, k;
    cin >> n >> k;

    int diamonds[n];
    for (int i = 0; i < n; i++) {
        cin >> diamonds[i];
    }

    sort(diamonds, diamonds + n);
    
    int maxDiamondFirst[n];
    for (int i = 0, j = 0; i < n; i++) {
         while (j < n && diamonds[j] - diamonds[i] <= k) {
            j++;
        }
        maxDiamondFirst[i] = j - i;
    }

    int maxDiamondSecond[n + 1];
    maxDiamondSecond[n] = 0;
    for (int i = n - 1; i >= 0; i--) {
        maxDiamondSecond[i] = max(maxDiamondFirst[i], maxDiamondSecond[i + 1]);
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
        result = max(result, maxDiamondFirst[i] + maxDiamondSecond[i + maxDiamondFirst[i]]);
    }

    cout << result << endl;

    return 0;
}
