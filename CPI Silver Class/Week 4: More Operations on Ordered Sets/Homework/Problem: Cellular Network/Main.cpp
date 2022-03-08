#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int cities[n];
    for (int i = 0; i < n; i++) {
        cin >> cities[i];
    }

    set<int> towers;
    int tower;
    for (int i = 0; i < m; i++) {
        cin >> tower;
        towers.insert(tower);
    }

    int r = 0;
    for (int i = 0; i < n; i++) {
        int distance = 2e9 + 1;
        auto closestTower = towers.lower_bound(cities[i]);
        if (closestTower != towers.end()) {
            distance = *closestTower - cities[i];
        }
        if (closestTower != towers.begin()) {
            distance = min(distance, cities[i] - *(--closestTower));
        }
        r = max(r, distance);
    }

    cout << r << endl;

    return 0;
}
