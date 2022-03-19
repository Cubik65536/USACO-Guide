#include<bits/stdc++.h>
using namespace std;

const int MAX_N = 1005;

int n;

char grid[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N];

int currentArea = 0;
int currentPerimeter = 0;

void floodFill(int i, int j) {
    if (i < 0 || i >= n || j < 0 || j >= n) {
        currentPerimeter++;
        return;
    }

    if (visited[i][j]) {
        return;
    }

    if (grid[i][j] == '.') {
        currentPerimeter++;
        return;
    }

    visited[i][j] = true;

    if (grid[i][j] == '#') {
        currentArea++;
    }
    floodFill(i + 1, j);
    floodFill(i - 1, j);
    floodFill(i, j + 1);
    floodFill(i, j - 1);
}

int main() {
    freopen("perimeter.in", "r", stdin);
    freopen("perimeter.out", "w", stdout);

    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    int area = 0;
    int perimeter = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!visited[i][j] && grid[i][j] == '#') {
                floodFill(i, j);
                if (area == currentArea) {
                    perimeter = min(perimeter, currentPerimeter);
                } else if (area < currentArea) {
                    area = currentArea;
                    perimeter = currentPerimeter;
                }
                currentArea = 0;
                currentPerimeter = 0;
            }
        }
    }

    cout << area << " " << perimeter << endl;

    return 0;
}
