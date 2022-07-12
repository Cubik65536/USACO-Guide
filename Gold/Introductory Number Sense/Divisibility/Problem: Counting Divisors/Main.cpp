#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    for (int m = 0; m < n; m++) {
        int x;
        cin >> x;

        int divisors_num = 0;
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                divisors_num += i * i == x ? 1 : 2;
            }
        }
        cout << divisors_num << endl;
    }

    return 0;
}
