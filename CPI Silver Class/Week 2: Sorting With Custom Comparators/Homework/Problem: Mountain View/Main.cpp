#include <bits/stdc++.h>
using namespace std;

struct Mountain {
	int s, e;
};

bool mountainComparator(const Mountain& mountain1, const Mountain& mountain2) {
    if (mountain1.s != mountain2.s) {
        return mountain1.s < mountain2.s;
    } else {
        return mountain2.e < mountain1.e;
    }
}

int main() {
    freopen("mountains.in", "r", stdin);
    freopen("mountains.out", "w", stdout);

    int n;
    cin >> n;

    vector<Mountain> mountains;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        int s = x - y;
        int e = x + y;
        mountains.push_back({s, e});
    }

    sort(mountains.begin(), mountains.end(), mountainComparator);

    int maximum = INT_MIN;
    int result = 0;

    for (int i = 0; i < n; i++) {
        if (mountains[i].e > maximum) {
            maximum = mountains[i].e;
            result++;
        }
    }

    cout << result << endl;

    return 0;
}
