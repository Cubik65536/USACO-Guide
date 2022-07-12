#include <bits/stdc++.h>

using namespace std;

using ll = long long;

ll inc_exc[] = { -1, +1, -1, +1, -1, +1 };

struct cow {
    int n;
    int flavors[5];
};

cow cows[50000];

bool operator< (const cow &a, const cow &b) {
    for (int i = 0; i < 5; i++) {
        if (a.flavors[i] < b.flavors[i]) return true;
        if (a.flavors[i] > b.flavors[i]) return false;
    }
    return false;
}

cow get_subset(cow &c, int x) {
    cow result = { 0, { 0, 0, 0, 0, 0 } };
    for (int i = 0; i < 5; i++) {
        if ((1 << i) & x) {
            result.flavors[result.n++] = c.flavors[i];
        }
    }
    return result;
}

int main() {
    freopen("cowpatibility.in", "r", stdin);
    freopen("cowpatibility.out", "w", stdout);

    ll n;
    cin >> n;

    map<cow, int> subsets;
    for (int i = 0; i < n; i++) {
        cows[i].n = 5;
        for (int j = 0; j < 5; j++) {
            cin >> cows[i].flavors[j];
        }
        sort(cows[i].flavors, cows[i].flavors + 5);
        for (int x = 1; x < 32; x++) {
            subsets[get_subset(cows[i], x)]++;
        }
    }

    ll result = n * (n - 1) / 2;
    for (auto &p : subsets) {
        result -= inc_exc[p.first.n] * p.second * (p.second - 1) / 2;
    }

    cout << result << endl;

    return 0;
}
