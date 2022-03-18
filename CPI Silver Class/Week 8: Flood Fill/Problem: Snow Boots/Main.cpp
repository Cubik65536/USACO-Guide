#include<bits/stdc++.h>
using namespace std;

int N, B;
int f[255], s[255], d[255];
bool visited[255][255];

int result = INT_MAX;

void floodFill(int n, int b) {
    if (visited[n][b]) {
        return;
    }

    visited[n][b] = true;

    if (n == N) {
        result = min(result, b);
    }
    if (s[b] < f[n]) {
        return;
    }

    for (int i = n + 1; i <= N && i <= n + d[b]; i++) {
        floodFill(i, b);
    }
    for (int i = b + 1; i <= B; i++) {
        floodFill(n, i);
    }
    
}

int main() {
    freopen("snowboots.in", "r", stdin);
    freopen("snowboots.out", "w", stdout);

    cin >> N >> B;

    for (int i = 1; i <= N; i++) {
        cin >> f[i];
    }
    for (int i = 0; i < B; i++) {
        cin >> s[i] >> d[i];
    }

    floodFill(1, 0);

    cout << result << endl;

    return 0;
}
