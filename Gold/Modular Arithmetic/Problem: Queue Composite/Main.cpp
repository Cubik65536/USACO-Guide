#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using pll = pair<ll, ll>;

const ll MOD = 998244353;

int main() {
    int q;
    cin >> q;

    deque<pll> queue;

    while (q--) {
        int ty;
        cin >> ty;
        if (ty == 0) {
            ll a, b;
            cin >> a >> b;
            queue.emplace_back(a, b);
        } else if (ty == 1) {
            queue.pop_front();
        } else {
            ll result;
            cin >> result;
            for (int i = 0; i < (int) queue.size(); i++) {
                ll a, b;
                tie(a, b) = queue[i];
                result = (result * a + b) % MOD;
            }
            cout << result << endl;
        }
    }

    return 0;
}
