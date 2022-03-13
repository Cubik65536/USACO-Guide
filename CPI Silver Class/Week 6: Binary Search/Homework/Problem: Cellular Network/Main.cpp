#include <bits/stdc++.h>
using namespace std;

int rightLeastTower(vector<int> towers, int city) {
    int low = 0, high = towers.size();
    while (low < high) {
        int mid = (low + high) / 2;
        if (towers[mid] >= city) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
    return low;
}

int main() {
    int n, m;
    cin >> n >> m;

    vector<int> a;
    for (int i = 0; i < n; i++) {
        int city;
        cin >> city;
        a.push_back(city);
    }

    vector<int> b;
    for (int i = 0; i < m; i++) {
        int tower;
        cin >> tower;
        b.push_back(tower);
    }

    int minimumR = 0;
    for (int i = 0; i < n; i++) {
        int rightTower = rightLeastTower(b, a[i]);
        int leftTower = rightTower - 1;

        int minimumRForThisCity = INT_MAX;

        if (rightTower < m) {
            minimumRForThisCity = min(minimumRForThisCity, b[rightTower] - a[i]);
        }
        if (leftTower >= 0) {
            minimumRForThisCity = min(minimumRForThisCity, a[i] - b[leftTower]);
        }

        minimumR = max(minimumR, minimumRForThisCity);

    }

    cout << minimumR << endl;
 
    return 0;
}
