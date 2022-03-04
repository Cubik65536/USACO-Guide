#include <bits/stdc++.h>
using namespace std;

int main() {
    int x, n;
    cin >> x >> n;

    set<int> lights;
    lights.insert({0, x});

    multiset<int> distances;
    distances.insert(x);

    while (n--) {
        int p;
        cin >> p;

        auto light = lights.upper_bound(p);
        auto distance = prev(light);

        int v1 = *light;
        int v2 = *distance;

        distances.erase(distances.find(v1 - v2));
        lights.insert(p);
        distances.insert(v1 - p);
        distances.insert(p - v2);

        auto result = prev(distances.end());
        if (n == 0) cout << *result << endl;
        else cout << *result << " ";
    }

    return 0; 
}
