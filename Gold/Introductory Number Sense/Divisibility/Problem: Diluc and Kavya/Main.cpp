#include <bits/stdc++.h>

using namespace std;

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;
        vector<char> str(n);
        for (char &c : str) {
            cin >> c;
        }

        int d_num = 0, k_num = 0;
        vector<int> max_prefix;
        unordered_map<int, unordered_map<int, int>> prev_ratios;

        for (char c : str) {
            if (c == 'D') {
                d_num++;
            } else {
                k_num++;
            }

            int ratio = gcd(d_num, k_num);
            int d_ratio = d_num / ratio;
            int k_ratio = k_num / ratio;
            max_prefix.push_back(++prev_ratios[d_ratio][k_ratio]);
        }

        for (int i = 0; i < n - 1; i++) {
            cout << max_prefix[i] << " ";
        }

        cout << max_prefix.back() << endl;
    }

    return 0;

}
