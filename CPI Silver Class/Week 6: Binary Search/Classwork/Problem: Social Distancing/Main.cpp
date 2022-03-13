#include <bits/stdc++.h>
using namespace std;

#define f first
#define s second
using ll = long long;

const int maxN = 1e5 + 10;

int n, m;
pair<ll, ll> cows[maxN];

bool works(ll d) {
	ll last = -1e18; 

	for (int i = 0, j = 0; i < n; i++) {
		while (j < m && last + d > cows[j].s) {
			j++; 
		}
		if (j == m) {
            return false;
        } 
		last = max(last + d, cows[j].f); 
	}

	return true; 
}

int main() {
    freopen("socdist.in", "r", stdin);
    freopen("socdist.out", "w", stdout); 

	cin >> n >> m; 

	for (int i = 0; i < m; i++) {
		cin >> cows[i].f >> cows[i].s;
	}

	sort(cows, cows + m);

	ll low = 1, high = 1e18 + 1; 

	while (low + 1 < high) {
		ll mid = (low + high) / 2; 
		if (works(mid)) {
			low = mid; 
		} else {
			high = mid; 
		}
	}

	cout << low << endl;

    return 0;
}
