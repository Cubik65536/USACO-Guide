#include<bits/stdc++.h>
using namespace std;

int n, m;

vector<vector<bool>> visited;

vector<int> dx = {0, 0, -1, 1};
vector<int> dy = {1, -1, 0, 0};

void floodFill(int i, int j) {
    visited[i][j] = true;
    for (int dir = 0; dir < 4; dir++) {
        int x = i + dx[dir];
        int y = j + dy[dir];
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
            continue;
        }
        floodFill(x, y);
    }
}

int main() {
    cin >> n >> m;

    visited.resize(n, vector<bool>(m, false)); 

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            char c;
            cin >> c;
            if (c == '#') {
                visited[i][j] = true;
            } else {
                visited[i][j] = false;
            }
        }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (!visited[i][j]) {
                result++;
                floodFill(i, j);
            }
        }
    }

    cout << result << endl;

    return 0;
}
