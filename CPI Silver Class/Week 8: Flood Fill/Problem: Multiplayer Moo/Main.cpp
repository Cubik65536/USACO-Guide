#include <bits/stdc++.h>
using namespace std;

using pii = pair<int, int>;
using vi = vector<int>;

bool ckmax(int &a, const int &b) { return b > a ? a = b, 1 : 0; }

template <class F> struct y_combinator_result {
	F f;
	template <class T> explicit y_combinator_result(T &&f) : f(forward<T>(f)) {}
	template <class... Args> decltype(auto) operator()(Args &&...args) {
		return f(ref(*this), forward<Args>(args)...);
	}
};
template <class F> decltype(auto) y_combinator(F &&f) {
	return y_combinator_result<decay_t<F>>(forward<F>(f));
}

const int dx[] = {0, 0, -1, 1};
const int dy[] = {-1, 1, 0, 0}; 
const int MAX = 1e6 + 1; 

vi inComp[MAX]; 

int main() {
	freopen("multimoo.in", "r", stdin); 
	freopen("multimoo.out", "w", stdout); 

	int n; 
	cin >> n; 
	vector<vi> grid(n, vi(n)); 
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> grid[i][j]; 
		}
	}

	vector<vector<bool>> visited(n, vector<bool>(n));
	vi comps; 
	vi compColor; 
	vector<vi> id(n, vi(n)); 
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				int sz = 0; 
				y_combinator([&](auto floodfill, int x, int y) -> void {
					visited[x][y] = 1; 
					id[x][y] = comps.size(); 
					sz++; 
					for (int k = 0; k < 4; k++) {
						auto X = x + dx[k], Y = y + dy[k]; 
						if (X >= 0 && X < n && Y >= 0 && Y < n && grid[X][Y] == grid[x][y] && !visited[X][Y]) {
							floodfill(X, Y); 
						}
					}
				})(i, j); 
				comps.push_back(sz); 
				compColor.push_back(grid[i][j]); 
			}
		}
	}

	cout << *max_element(comps.begin(), comps.end()) << endl;

	vi allColors; 
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			allColors.push_back(grid[i][j]);
			inComp[grid[i][j]].push_back(id[i][j]); 
		}
	}
	sort(allColors.begin(), allColors.end()); 
	allColors.resize(unique(allColors.begin(), allColors.end()) - allColors.begin()); 
	for (auto &x : allColors) {
		sort(inComp[x].begin(), inComp[x].end()); 
		inComp[x].resize(unique(inComp[x].begin(), inComp[x].end()) - inComp[x].begin()); 
	}

	vector<pii> edges; 
	vector<vi> adj(comps.size());

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i < n - 1 && grid[i][j] != grid[i + 1][j]) {
				edges.push_back(minmax(grid[i][j], grid[i + 1][j])); 
				adj[id[i][j]].push_back(id[i + 1][j]); 
				adj[id[i + 1][j]].push_back(id[i][j]); 
			}
			if (j < n - 1 && grid[i][j] != grid[i][j + 1]) {
				edges.push_back(minmax(grid[i][j], grid[i][j + 1])); 
				adj[id[i][j]].push_back(id[i][j + 1]); 
				adj[id[i][j + 1]].push_back(id[i][j]); 
			}
	 	}
	}

	sort(edges.begin(), edges.end()); 
	edges.resize(unique(edges.begin(), edges.end()) - edges.begin()); 
	for (auto &x : adj) {
		sort(x.begin(), x.end()); 
		x.resize(unique(x.begin(), x.end()) - x.begin()); 
	}

	int ans = 0; 
	for (auto edge : edges) {
        int x = edge.first, y = edge.second;
		set<int> visitedited; 
		int cur = 0; 
		auto dfs = y_combinator([&](auto dfs, int comp) -> void {
			visitedited.insert(comp); 
			cur += comps[comp]; 
			for (auto &v : adj[comp]) {
				if ((compColor[v] == x || compColor[v] == y) && !visitedited.count(v)) {
					dfs(v); 
				}
			}
		}); 
		for (auto &v : inComp[x]) {
			if (!visitedited.count(v)) {
				dfs(v); 
				ckmax(ans, cur); 
				cur = 0; 
			}
		}
		for (auto &v : inComp[y]) {
			if (!visitedited.count(v)) {
				dfs(v); 
				ckmax(ans, cur); 
				cur = 0; 
			}
		}
	}

	cout << ans << endl;

    return 0;
}
