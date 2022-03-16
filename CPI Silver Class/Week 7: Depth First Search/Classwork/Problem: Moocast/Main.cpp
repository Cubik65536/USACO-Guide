#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1005;

int x[MAX_N], y[MAX_N], parent[MAX_N], sz[MAX_N];
vector<pair<int, pair<int, int>>> edges;

int distance(int i, int j){
	return (x[j] - x[i]) * (x[j] - x[i]) + (y[j] - y[i]) * (y[j] - y[i]);
}

int find(int node) {
    while (node != parent[node]) {
        node = parent[node];
    }
    return node;
}

bool merge(int node1, int node2) {
    node1 = find(node1);
    node2 = find(node2);
    if (node1 == node2) {
        return false;
    }
    if (sz[node1] < sz[node2]) {
        sz[node1] += sz[node2];
        parent[node2] = parent[node1];
    } else {
        sz[node2] += sz[node1];
        parent[node1] = parent[node2];
    }
    return true;
}

int main() {
    freopen("moocast.in", "r", stdin);
    freopen("moocast.out", "w", stdout);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
        parent[i] = i;
        sz[i] = 1;
    }

    for (int i = 0; i < n; i++) {
		for(int j = 0; j < i; j++) {
			edges.push_back(make_pair(distance(i, j), make_pair(i, j)));
		}
	}
    
	sort(edges.begin(), edges.end());

    int result = 0;
    int numComponents = n;
    for (auto edge : edges) {
        if (merge(edge.second.first, edge.second.second)) {
            result = edge.first;
            if (--numComponents == 1) {
                break;
            }
        }
    }

    cout << result << endl;

    return 0;
}
