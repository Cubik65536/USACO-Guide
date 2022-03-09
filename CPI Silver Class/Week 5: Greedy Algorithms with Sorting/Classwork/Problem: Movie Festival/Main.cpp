#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<pair<int, int>> movies;
    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        movies.push_back(make_pair(b, a));
    }

    sort(movies.begin(), movies.end());

    int result = 0;
    int current = 0;
    for (int i = 0; i < n; i++) {
        if (movies[i].second >= current) {
            result++;
            current = movies[i].first;
        }
    }

    cout << result << endl;

    return 0;
}
