#include <bits/stdc++.h>
using namespace std;

const double INF = 1e9;
const int MAX_N = 100020;

struct edge {
    int v, c;
};

struct coeff {
    double k;
    int x;
};
 
vector<edge> graph[MAX_N];
coeff coeffs[MAX_N];
bool visited[MAX_N];
vector<int> lastVisited;

bool invalid = false;

double x;
 
void dfs(int v, int parent) {
    visited[v] = true;
    lastVisited.push_back(v);
    for (auto [u, c] : graph[v]) {
        if (u != parent) {
            if (!visited[u]) {
                coeffs[u] = {c - coeffs[v].k, -coeffs[v].x};
                dfs(u, v);
            } else {
                coeff newCoeff = {c - coeffs[v].k, -coeffs[v].x};
                if (newCoeff.x != coeffs[u].x) {
                    double newX = (coeffs[u].k - newCoeff.k) / (newCoeff.x - coeffs[u].x);
                    if (x == INF) {
                        x = newX;
                    } else if (fabs(x - newX) > 1e-8) {
                        invalid = true;
                    }
                } else if (fabs(newCoeff.k - coeffs[u].k) > 1e-8) {
                    invalid = true;
                }
            }
        }
    }
}
 
 
int main() {
    int n, m;
    cin >> n >> m;
 
    for (int i = 0; i < m; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        graph[a].push_back({b, c});
        graph[b].push_back({a, c});
    }
    for (int i = 1; i <= n; i++) {
        coeffs[i] = {0, 0};
    }
    for (int i = 1; i <= n; i++) {
        if (visited[i] == 0) {
            coeffs[i] = {0, 1};
            x = INF;
            dfs(i, -1);
            if (invalid) {
                break;
            }
            for (int v : lastVisited) {
                visited[v] = 0;
            }
            if (x < INF) {
                coeffs[i].k = x;
                coeffs[i].x = 0;
                dfs(i, -1);
            } else {
                vector<double> seenCoeffs;
                for (int v : lastVisited) {
                    seenCoeffs.push_back(coeffs[v].k * -coeffs[v].x);
                }
                sort(seenCoeffs.begin(), seenCoeffs.end());
                coeffs[i].k = seenCoeffs[seenCoeffs.size() / 2];
                coeffs[i].x = 0;
                dfs(i, -1);
            }
            lastVisited.clear();
        }
    }

    if (invalid) {
        cout << "NO" << endl;
    } else {
        cout << "YES" << endl;
        for (int i = 1; i <= n; i++) {
            cout << fixed << setprecision(14) << coeffs[i].k << ' ';
        }
        cout << endl;
    }
}
