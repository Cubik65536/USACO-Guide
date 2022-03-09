#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    vector<pair<int, int>> movies;
    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        movies.push_back(make_pair(b, a));
    }

    sort(movies.begin(), movies.end());

    int result = 0;
    multiset<int> endTimes;
    for (int i = 0; i < k; i++) {
        endTimes.insert(0);
    }

    for (int i = 0; i < n; i++) {
        int time = movies[i].second;
        auto it = endTimes.upper_bound(time);
        if (it != begin(endTimes)) {
            endTimes.erase(--it);
            endTimes.insert(movies[i].first);
            result++;
        }
    }

    cout << result << endl;

    return 0;
}
