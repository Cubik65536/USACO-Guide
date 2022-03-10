#include <bits/stdc++.h>
using namespace std;

using ll = long long;
using iiPair = pair<int, int>;

int main() {
    int a, b, c;
    cin >> a >> b >> c;

    int m;
    cin >> m;

    vector<iiPair> v;
    for (int i = 0; i < m; i++) {
        int val;
        string type;
        cin >> val >> type;
        if (type == "USB") {
            v.push_back(make_pair(val, 0));
        } else {
            v.push_back(make_pair(val, 1));
        }
    }

    sort(v.begin(), v.end());

    ll equipped = 0;
    ll cost = 0;

    for (auto mouse : v) {
        if (mouse.second == 0) {
            if (a) {
                a--;
                equipped++;
                cost += mouse.first;
            } else if (c) {
                c--;
                equipped++;
                cost += mouse.first;
            }
        } else {
            if (b) {
                b--;
                equipped++;
                cost += mouse.first;
            } else if (c) {
                c--;
                equipped++;
                cost += mouse.first;
            }
        }
    }

    cout << equipped << " " << cost << endl;

    return 0;
}
