#include <bits/stdc++.h>
using namespace std;

using ll = long long;

struct RoomStayTime {
	int t1, t2;
	int idx;
};

bool compare(const RoomStayTime& a, const RoomStayTime& b) {
	return ((a.t1 < b.t1) || (a.t1 == b.t1 && a.t2 < b.t2));
}

int main() {
    int n;
    cin >> n;

    vector<RoomStayTime> v(n);
    for (int i = 0; i < n; i++) {
        cin >> v[i].t1 >> v[i].t2;
        v[i].idx = i;
    }

    sort(v.begin(), v.end(), compare);

    int lastRoom = 0;
    vector<int> roomIndex(n);
    priority_queue<pair<int, int>> pq;

    for (int i = 0; i < n; i++) {
        if (pq.empty()) {
            lastRoom++;
            pq.push(make_pair(-v[i].t2, lastRoom));
            roomIndex[v[i].idx] = lastRoom;
        } else {
            auto minimum = pq.top();
            if (-minimum.first < v[i].t1) {
                pq.pop();
				pq.push(make_pair(-v[i].t2, minimum.second));
				roomIndex[v[i].idx] = minimum.second;
            } else {
                lastRoom++;
                pq.push(make_pair(-v[i].t2, lastRoom));
                roomIndex[v[i].idx] = lastRoom;
            }
        }
    }

    cout << lastRoom << endl;
    for (int i = 0; i < n; i++) {
        cout << roomIndex[i] << " ";
    }
    cout << endl;

    return 0;
}
