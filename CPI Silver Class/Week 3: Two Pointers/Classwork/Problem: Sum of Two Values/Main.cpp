#include <bits/stdc++.h>
using namespace std;

#define index first
#define value second

int main() {
    int n, x;
    cin >> n >> x;

    vector<pair<int,int>> a;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        a.push_back(make_pair(i + 1, x));
    }

    sort(a.begin(), a.end(), [](const pair<int,int>& a, const pair<int,int>& b) {
        return a.value < b.value;
    });

    for (int i = 0, j = n - 1; i < j;) {
        if (a[i].value + a[j].value < x) {
            i++;
        } else if (a[i].value + a[j].value > x) {
            j--;
        } else {
            cout << a[i].index << " " << a[j].index << endl;
            return 0;
        }
    }

    cout << "IMPOSSIBLE" << endl;

    return 0;

}
