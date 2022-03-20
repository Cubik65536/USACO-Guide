#include<bits/stdc++.h>
using namespace std;

const int MAX_N = 2e5 + 5;

int a[MAX_N];

vector<int> children[MAX_N];

void dfs(int v) {
    a[v] = 1;
    for (int u: children[v]) {
        dfs(u);
        a[v] += a[u];
    }
}

int main() {
    int n;
    cin >> n;

    for (int i = 2; i <= n; i++) {
        int boss;
        cin >> boss;
        children[boss].push_back(i);
    }

    dfs(1);

    for (int i = 1; i <= n; i++) {
        cout << a[i] - 1 << " ";
    }
    cout << endl;

    return 0;

}
