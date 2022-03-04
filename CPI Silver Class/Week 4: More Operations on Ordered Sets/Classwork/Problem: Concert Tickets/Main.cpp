#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    multiset<int> tickets;
    for (int i = 0; i < n; i++) {
        int h;
        cin >> h;
        tickets.insert(h);
    }

    for (int i = 0; i < m; i++) {
        int t;
        cin >> t;

        auto ticket = tickets.upper_bound(t);

        if (ticket == tickets.begin()) {
            cout << "-1" << endl;
        } else {
            cout << *(--ticket) << endl;
            tickets.erase(ticket);
        }
    }

    return 0;
}
