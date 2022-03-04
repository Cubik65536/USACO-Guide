#include <bits/stdc++.h>
using namespace std;

struct node { int P, S, A, L; } val0 {0, 0, 0, 1}, val1{1, 1, 1, 1};

node operator+(const node& a, const node& b) {
	return { a.P == a.L ? a.L + b.P : a.P,
			 b.S == b.L ? b.L + a.S : b.S, 
			 max(max(a.A, b.A), a.S + b.P),
			 a.L + b.L};
}

template<typename T, size_t N>
class SegmentTree {
private:
	T tree[4 * N], dval;
	function<T(const T&, const T&)> merge;

	void build(int t, int tl, int tr) {
		if (tl == tr) {
			tree[t] = dval;
			return;
		}
		build(t << 1, tl, (tl + tr) >> 1);
		build(t << 1 | 1, ((tl + tr) >> 1) + 1, tr);
		tree[t] = merge(tree[t << 1], tree[t << 1 | 1]);
	} 

	void update(int i, T v, int t, int tl, int tr) {
		if (tl == tr) {
			tree[t] = v;
			return;
		}
		if (i <= (tl + tr) >> 1) 
			update(i, v, t << 1, tl, (tl + tr) >> 1);
		else 
			update(i, v, t << 1 | 1, ((tl + tr) >> 1) + 1, tr);
		tree[t] = merge(tree[t << 1], tree[t << 1 | 1]);
	}

	T query(int l, int r, int t, int tl, int tr) {
		if (r < tl || tr < l)
			return dval;
		if (l <= tl && tr <= r)
			return tree[t];
		return merge(query(l, r, t << 1, tl, (tl + tr) >> 1), query(l, r, t << 1 | 1, ((tl + tr) >> 1) + 1, tr));
	}

public:
	SegmentTree(function<T(const T&, const T&)> merge, T dval = 0) : merge(merge), dval(dval) {
		build();
	}

	inline void build() { build(1, 0, N - 1); }

	inline void update(int i, T v) { update(i, v, 1, 0, N - 1); }

	inline T query(int l, int r) { return query(l, r, 1, 0, N - 1); }
};

string S;
int Q;
SegmentTree<node, 200005> ST0 ([](const node& a, const node& b) { return a + b; }, val0);
SegmentTree<node, 200005> ST1 ([](const node& a, const node& b) { return a + b; }, val0);

int main() {
	cin >> S;
	for (int i = 0; i < S.size(); i++) {
		if (S[i] == '0') {
			ST0.update(i, val1);
			ST1.update(i, val0);
		}
		else if (S[i] == '1') {
			ST0.update(i, val0);
			ST1.update(i, val1);
		}
	}
	cin >> Q;
	while (Q--) {
		int x; cin >> x; x--;
		if (S[x] == '0') {
			ST0.update(x, val0);
			ST1.update(x, val1);
			S[x] = '1';
		}
		else if (S[x] == '1') {
			ST1.update(x, val0);
			ST0.update(x, val1);
			S[x] = '0';
		}
		cout << max(ST0.query(0, S.size() - 1).A, ST1.query(0, S.size() - 1).A) << ' ';
	}
}
