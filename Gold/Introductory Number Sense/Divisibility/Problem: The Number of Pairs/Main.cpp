#include <bits/stdc++.h>

using namespace std;

const int MAX = 2e7 + 13;

int main() {
    vector<int> mind(MAX, -1), val(MAX);
    mind[1] = 1;

    for (int i = 2; i < MAX; i++) {
        if (mind[i] == -1) {
            for (int j = i; j < MAX; j += i) {
                if (mind[j] == -1) {
                    mind[j] = i;
                }
            }
        }
    }
    
    for (int i = 2; i < MAX; i++) {
        int j = i / mind[i];
        val[i] = val[j] + (mind[i] != mind[j]);
    }

    int t;
    cin >> t;

    while (t--) {
        int c, d, x;
        cin >> c >> d >> x;

        int result = 0;
        for (int i = 1; i * i <= x; i++) {
            if (x % i != 0) {
                continue;
            }
            int k1 = x / i + d;
            if (k1 % c == 0) {
                result += 1 << val[k1 / c];
            }
            if (i * i == x) {
                continue;
            }
            int k2 = i + d;
            if (k2 % c == 0) {
                result += 1 << val[k2 / c];
            }
        }

        cout << result << endl;
    }

    return 0;

}
