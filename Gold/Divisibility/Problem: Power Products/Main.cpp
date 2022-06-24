#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using pi = pair<int, int>;

int k;

vector<pi> factor(int number) {
    map<int, int> factors;
    for (int i = 2; i * i <= number; i++) {
        while (number % i == 0) {
            number /= i;
            factors[i]++;
        }
    }
    if (number > 1) {
        factors[number]++;
    }
    vector<pi> prime_factorization;
    for (pi primes: factors) {
        if (primes.second % k > 0) {
            prime_factorization.push_back({primes.first, primes.second % k});
        }
    }
    return prime_factorization;
}

vector<pi> find_factor_inverse(vector<pi> prime_factorization) {
    int prime_number = prime_factorization.size();
    vector<pi> factor_inverse(prime_number);
    for (int i = 0; i < prime_number; i++) {
        factor_inverse[i].first = prime_factorization[i].first;
        factor_inverse[i].second = k - prime_factorization[i].second;
    }
    return factor_inverse;
}

int main() {
    int n;
    cin >> n >> k;

    map<vector<pi>, int> factor_frequency;
    vector<int> array(n);
    for (int i = 0; i < n; i++) {
        cin >> array[i];
        factor_frequency[factor(array[i])]++;
    }

    ll result = 0;
    for (int i = 0; i < n; i++) {
        if (factor(array[i]) == find_factor_inverse(factor(array[i]))) {
            result += factor_frequency[factor(array[i])] - 1;
        } else {
            result += factor_frequency[find_factor_inverse(factor(array[i]))];
        }
    }

    cout << result / 2 << endl;

    return 0;

}
