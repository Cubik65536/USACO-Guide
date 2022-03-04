#include <bits/stdc++.h>
using namespace std;

#define milkTime first
#define cowsNum second

int main() {
    freopen("pairup.in", "r", stdin);
    freopen("pairup.out", "w", stdout);

    int n;
    cin >> n;

    vector<pair<int, int>> pairs;
    for (int i = 0; i < n; i++) {
        int cowsNum, milkTime;
        cin >> cowsNum >> milkTime;
        pairs.push_back(pair<int, int>(milkTime, cowsNum));
    }

    sort(pairs.begin(), pairs.end());

    int result = 0;
    for (int i = 0, j = n - 1; i <= j;) {
        int numPaired = min(pairs[i].cowsNum, pairs[j].cowsNum);
        if (i == j) {
            numPaired /= 2;
        }
        result = max(result, pairs[i].milkTime + pairs[j].milkTime);
        pairs[i].cowsNum -= numPaired;
        pairs[j].cowsNum -= numPaired;

        if (pairs[i].cowsNum == 0) {
            i++;
        }
        if (pairs[j].cowsNum == 0) {
            j--;
        }
    }

    cout << result << endl;

    return 0;
}
