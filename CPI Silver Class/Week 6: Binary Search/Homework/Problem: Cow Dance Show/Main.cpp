#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("cowdance.in", "r", stdin);
    freopen("cowdance.out", "w", stdout);

    int n, t;
    cin >> n >> t;

    int d[n];
    for (int i = 0; i < n; i++) {
        cin >> d[i];
    }

    int low = 1, high = n;
    int result = n;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        int time = 0, size = 0, j = 0;
        priority_queue<int> pq;
        while (size < mid && j < n) {
            pq.push(-d[j]);
            size++;
            j++;
        }

        while ((int) pq.size()) {
            time += max(0, -pq.top() - time);
            pq.pop();
            if (j < n) {
                pq.push(-(d[j] + time));
                j++;
            }
        }

        if (time <= t) {
            result = min(result, mid);
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    cout << result << endl;
 
    return 0;
}
