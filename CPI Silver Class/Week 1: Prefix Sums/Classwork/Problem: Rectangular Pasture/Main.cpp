#include <bits/stdc++.h>

using namespace std;

const int MAXN = 2505;

using ll = long long;
using pii = pair<int, int>;

#define X first
#define Y second

int pre[MAXN][MAXN];

int getSum(int x1, int y1, int x2, int y2) {
    return pre[x2][y2] - pre[x1 - 1][y2] - pre[x2][y1 - 1] + pre[x1 - 1][y1 - 1];
}

int main() {
    int n;
    cin >> n;

    pii cowCoordinates[MAXN];

    for(int i = 0; i < n; i++) {
		cin >> cowCoordinates[i].X >> cowCoordinates[i].Y;
    }

	for(int t = 0; t < 2; t++) {
		sort(cowCoordinates, cowCoordinates + n);
		for(int i = 0; i < n; i++){
			cowCoordinates[i].X = i + 1;
			swap(cowCoordinates[i].X, cowCoordinates[i].Y);
		}
	}

	for(int i = 0; i < n; i++) {
		pre[cowCoordinates[i].X][cowCoordinates[i].Y]++;
    }

	for(int i = 1; i <= n; i++) {
		for(int j = 1; j <= n; j++) {
			pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
        }
    }

	ll result = 1;
	for(int i = 0; i < n; i++){
		for(int j = i; j < n; j++){
			int x1 = min(cowCoordinates[i].X, cowCoordinates[j].X);
			int x2 = max(cowCoordinates[i].X, cowCoordinates[j].X);
			result += getSum(1, i + 1, x1, j + 1) * getSum(x2, i + 1, n, j + 1);
		}
	}

    cout << result << endl;

    return 0;

}
