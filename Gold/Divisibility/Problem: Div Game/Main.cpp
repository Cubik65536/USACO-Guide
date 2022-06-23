#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int main() {
    ll N;
    cin >> N;

    int result = 0;

    for (ll i = 2; i * i <= N; i++) {
        int exp = 0;
        while (N % i == 0) {
            N /= i;
            exp++;
        }
        for (int j = 1; exp - j >= 0; j++) {
            exp -= j;
            result++;
        }
    }

    if (N > 1) {
        result++;
    }

    cout << result << endl;

    return 0;
}
