#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const int MAXN = 2e5 + 5;

int n;
int q;
int ar[MAXN];
vector<ll> ipsEven(MAXN), ipsOdd(MAXN), psEven(MAXN), psOdd(MAXN);

void updatePrefix (int index) {
	for (int i = index; i < n; i++) {
		if ((i + 1) % 2 == 0) {
			psEven[i + 1] = psEven[i] + ar[i];
			ipsEven[i + 1] = ipsEven[i] + ar[i] * (i + 1);
			psOdd[i + 1] = psOdd[i];
			ipsOdd[i + 1] = ipsOdd[i];
		} else {
			psOdd[i + 1] = psOdd[i] + ar[i];
			ipsOdd[i + 1] = ipsOdd[i] + ar[i] * (i + 1);
			psEven[i + 1] = psEven[i];
			ipsEven[i + 1] = ipsEven[i];
		}
	}
}

int main () {
    int t;
    cin >> t;

    for (int testCase = 1; testCase <= t; testCase++) {
        cin >> n >> q;

        for (int i = 0; i < n; i++) {
            cin >> ar[i];
        }

        updatePrefix(0);

        ll result = 0;

        while (q--) {
            char c;
            cin >> c;

            if (c == 'Q') {
                int l, r;
                cin >> l >> r;

                ll cur = 0;
                if (l % 2 == 0) {
                    cur += ipsEven[r] - ipsEven[l - 1];
                    cur -= ipsOdd[r] - ipsOdd[l - 1];
                    cur -= (psEven[r] - psEven[l - 1]) * (l - 1);
                    cur += (psOdd[r] - psOdd[l - 1]) * (l - 1);
                } else {
                    cur += ipsOdd[r] - ipsOdd[l - 1];
                    cur -= ipsEven[r] - ipsEven[l - 1];
                    cur -= (psOdd[r] - psOdd[l - 1]) * (l - 1);
                    cur += (psEven[r] - psEven[l - 1]) * (l - 1);
                }

                result += cur;
                
            } else {
                int u;
                int v;
                cin >> u >> v;
                ar[u - 1] = v;
                updatePrefix(u - 1);

            }

        }

        cout << "Case #" << testCase << ": " << result << endl;

    }

    return 0;
}
