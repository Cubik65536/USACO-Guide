#include<bits/stdc++.h>
using namespace std;

bool visited[101][101][101];
int x, y, k, m, result;

void floodFill(int currentX, int currentY, int currentK) {
	if (visited[currentX][currentY][currentK] || currentK > k) {
        return;
    }
    
	visited[currentX][currentY][currentK] = true;

	result = min(result, abs(m - (currentX + currentY)));

	floodFill(x, currentY, currentK + 1);
	floodFill(currentX, y, currentK + 1);

	floodFill(0, currentY, currentK + 1);
	floodFill(currentX, 0, currentK + 1);

	int leftoverX = (currentX + currentY > y ? currentX + currentY - y : 0);
	int leftoverY = (currentY + currentX > x ? currentY + currentX - x : 0);

	floodFill(leftoverX, min(y, currentY + currentX), currentK + 1);
	floodFill(min(x, currentX + currentY), leftoverY, currentK + 1);

}

int main () {
	freopen("pails.in", "r", stdin);
	freopen("pails.out", "w", stdout);

	cin >> x >> y >> k >> m;

	result = m;

	floodFill(0, 0, 0);

	cout << result << endl;

    return 0;
}