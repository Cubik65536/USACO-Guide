#include <bits/stdc++.h>

using namespace std;

const int MAX_VAL = 1e6;

int occ_num[MAX_VAL + 1];

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        occ_num[x]++;
    }

    for (int possible_gcd = MAX_VAL; possible_gcd > 0; possible_gcd--) {
        int div_num = 0;
        for (int j = possible_gcd; j <= MAX_VAL; j += possible_gcd) {
            div_num += occ_num[j];
        }
        if (div_num >= 2) {
            cout << possible_gcd << endl;
            return 0;
        }
    }
}
