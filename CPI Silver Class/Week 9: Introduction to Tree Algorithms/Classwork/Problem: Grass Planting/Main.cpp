#include<bits/stdc++.h>
using namespace std;

int edges[100002];

int main() {
	freopen("planting.in", "r", stdin);
    freopen("planting.out", "w", stdout);

	int n;
    cin >> n;

	int result = 0;
	for (int i = 0;i < n - 1;i++) {
		int temp1, temp2;
		cin >> temp1 >> temp2;
		edges[temp2]++;
		edges[temp1]++;
		result = max(result, edges[temp2]);
		result = max(result, edges[temp1]);
	}

	cout << result + 1 << endl;

    return 0;
}
