#include <bits/stdc++.h>
using namespace std;

struct Lifeguard {
    int time;
    int id;
    bool isStart;
};

bool lifeguardComparator(const Lifeguard& lifeguard1, const Lifeguard& lifeguard2) {
    return lifeguard1.time < lifeguard2.time;
}

int main() {
    freopen("lifeguards.in", "r", stdin);
    freopen("lifeguards.out", "w", stdout);

    int n;
	cin >> n;

    vector<Lifeguard> lifeguards;

    for (int i = 0; i < n; i++) {
        int start, end;
        cin >> start >> end;
        lifeguards.push_back({start, i, true});
        lifeguards.push_back({end, i, false});
    }

    sort(lifeguards.begin(), lifeguards.end(), lifeguardComparator);

    set<int> activeLifeguards;

    int totoalTime = 0;
    vector<int> aloneTime(n, 0);
    int prevTime = 0;

    for (auto lifeguard : lifeguards) {
        int currentTime = lifeguard.time;

        if (activeLifeguards.size() > 0) {
            totoalTime += currentTime - prevTime;
        }

        if (activeLifeguards.size() == 1) {
            aloneTime[*activeLifeguards.begin()] += currentTime - prevTime;
        }

        if (lifeguard.isStart) {
            activeLifeguards.insert(lifeguard.id);
        } else {
            activeLifeguards.erase(lifeguard.id);
        }

        prevTime = currentTime;

    }

    int minimumAloneTime = INT_MAX;
    for (int i = 0; i < n; i++) {
        minimumAloneTime = min(minimumAloneTime, aloneTime[i]);
    }

    cout << totoalTime - minimumAloneTime << endl;

    return 0;

}
