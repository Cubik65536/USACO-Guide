#include <bits/stdc++.h>
using namespace std;

using ll = long long;
using pll = pair<ll, ll>;

#define X first
#define Y second

bool sortx(pll a, pll b) {
    return a.X < b.X;
}
bool sorty(pll a, pll b) {
    return a.Y < b.Y;
}

int main(void) {
    freopen("split.in", "r", stdin);
    freopen("split.out", "w", stdout);

    int n;
	cin >> n;

    pll cows[50005];
	for (int i = 0; i < n; i++) {
		cin >> cows[i].X >> cows[i].Y;
    }

    pll m = {INT_MAX, INT_MAX}, M = {0, 0};
	for (int i = 0; i < n; i++) {
		m.X = min(m.X, cows[i].X);
		m.Y = min(m.Y, cows[i].Y);
		M.X = max(M.X, cows[i].X);
		M.Y = max(M.Y, cows[i].Y);
	}

	ll result = LLONG_MAX;	

	sort(cows, cows + n, sortx);

	multiset<int> L, R;

	for (int i = 0; i < n; i++) {
		R.insert(cows[i].Y);
    }

	for (int i = 0; i < n - 1; i++) {
		L.insert(cows[i].Y);
		R.erase(R.lower_bound(cows[i].Y));

		if (cows[i].X == cows[i + 1].X) {
			continue;
        }

		ll left_width = cows[i].X - cows[0].X;
		ll left_height = *L.rbegin() - *L.begin();

		ll right_width = cows[n - 1].X - cows[i + 1].X;
		ll right_height = *R.rbegin() - *R.begin();

		result = min(result, left_width * left_height + right_width * right_height);
	}

	sort(cows, cows + n, sorty);

	multiset<int> U, D;

	for (int i = 0; i < n; i++) {
		U.insert(cows[i].X);
    }

	for (int i = 0; i < n - 1; i++) {
		D.insert(cows[i].X);
		U.erase(U.lower_bound(cows[i].X));

		if (cows[i].Y == cows[i + 1].Y) {
			continue;
        }

		ll down_width = cows[i].Y - cows[0].Y;
		ll down_height = *D.rbegin() - *D.begin();

		ll up_width = cows[n - 1].Y - cows[i + 1].Y;
		ll up_height = *U.rbegin() - *U.begin();

		result = min(result, down_width * down_height + up_width * up_height);
	}

	cout << (M.X - m.X) * (M.Y - m.Y) - result << endl;

    return 0;
}