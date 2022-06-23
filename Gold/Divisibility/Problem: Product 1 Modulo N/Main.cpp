#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int main() {
    int N;
    cin >> N;

    vector<ll> coprimes;

    for (int i = 1; i < N; i++) {
        if (gcd(N, i) == 1) {
            coprimes.push_back(i);
        }
    }

    int num_coprimes = coprimes.size();
    vector<ll> prefix_mod(num_coprimes);
    prefix_mod[0] = 1;
    for (int i = 1; i < num_coprimes; i++) {
        prefix_mod[i] = (prefix_mod[i - 1] * coprimes[i]) % N;
    }

    int result = 1;
    for (int i = 0; i < num_coprimes; i++) {
        if (prefix_mod[i] == 1) {
            result = i + 1;
        }
    }

    cout << result << endl;

    for (int i = 0; i < result; i++) {
        cout << coprimes[i] << " ";
    }
    cout << endl;

    return 0;
}
