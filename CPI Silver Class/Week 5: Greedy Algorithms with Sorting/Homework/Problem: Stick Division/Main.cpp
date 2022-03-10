#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int main() {
    int x, n;
    cin >> x >> n;

    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < n; i++) {
        int d;
        cin >> d;
        pq.push(d);
    }

    ll result;
    for (int i = 1; i < n; i++) {
        int a = pq.top();
        pq.pop();
        int b = pq.top();
        pq.pop();
        pq.push(a + b);
        result += a + b;
    }

    cout << result << endl;

    return 0;
}
