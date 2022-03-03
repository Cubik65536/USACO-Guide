#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1500;

int prefixSum[26][MAX_N + 1];

int main() {
	int n;
	string garland;
	cin >> n >> garland;

	for (int i = 1; i <= n; i++) {
		int color = garland[i - 1] - 'a';
		prefixSum[color][i]++;
	}

	for (int i = 0; i < 26; i++) {
		for (int j = 1; j <= n; j++) {
			prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i][j];
		}
	}
	
	int q;
	cin >> q;

	for (int i = 0; i < q; i++) {
		int maxRepaint;
		char color;

		cin >> maxRepaint >> color;
		int colorIndex = color - 'a';
		
		int l = 1, r = 1, koyomity = 1;
		while (r <= n) {
			int c_count = prefixSum[colorIndex][r] - prefixSum[colorIndex][l - 1] + maxRepaint;
			if (c_count < r - l + 1) {
				l++;
			} else {
				koyomity = max(koyomity, r - l + 1);
				r++;
			}
		}
		cout << koyomity << endl;
	}

    return 0;
}
