#include <bits/stdc++.h>
using namespace std;

using ll = long long;
using llPair = pair<ll, ll>;

int main() {
    int n;
    cin >> n;

    vector<llPair> tasks(n);
    for (int i = 0; i < n; i++) {
        cin >> tasks[i].first >> tasks[i].second;
    }

    sort(tasks.begin(), tasks.end());

    ll result = 0;
    ll time = 0;
    for (int i = 0; i < n; i++) {
        time += tasks[i].first;
        result += tasks[i].second - time;
    }

    cout << result << endl;

    return 0;
}
