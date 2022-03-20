#include <bits/stdc++.h>
using namespace std;

map<char, pair<int, int>> directions {
	{'N', {-1, 0}}, {'S', {1, 0}}, {'E', {0, 1}}, {'W', {0, -1}}
};

bool fence[4003][4003];
bool visited[4003][4003];
int maxX = 2001, maxY = 2001;
int minX = 2001, minY = 2001;

void floodFill(int i, int j) {
    if (i < minX || i > maxX || j < minY || j > maxY || visited[i][j] || fence[i][j]) {
        return;
    }
    visited[i][j] = true;
    int dx[] = {-1, 0, 0, 1};
    int dy[] = {0, -1, 1, 0};
    for (int k = 0; k < 4; k++) {
        floodFill(i + dx[k], j + dy[k]);
    }
}

int main() {
    freopen("gates.in", "r", stdin);
    freopen("gates.out", "w", stdout);

    int n;
    cin >> n;

    string path;
    cin >> path;

    int x = 2001, y = 2001;

    for (int i = 0; i < n; i++) {
        fence[x + directions[path[i]].first][y + directions[path[i]].second] = true;
        fence[x + 2 * directions[path[i]].first][y + 2 * directions[path[i]].second] = true;
        x += 2 * directions[path[i]].first;
        y += 2 * directions[path[i]].second;
        minX = min(minX, x);
        minY = min(minY, y);
        maxX = max(maxX, x);
        maxY = max(maxY, y);
    }

    minX--;
    minY--;
    maxX++;
    maxY++;

    int result = 0;
    for (int i = minX; i <= maxX; i++) {
        for (int j = minY; j <= maxY; j++) {
            if (!visited[i][j] && !fence[i][j]) {
                floodFill(i, j);
                result++;
            }
        }
    }

    cout << result - 1 << endl;

    return 0;
}
