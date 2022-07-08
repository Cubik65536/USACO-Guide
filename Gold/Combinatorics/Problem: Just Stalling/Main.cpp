#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int n, a[20], b[20];

int count_available(int x) {
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    if (x <= b[i]) {
      cnt ++;
    }
  }
  return cnt;
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (int i = 0; i < n; i++) {
      cin >> b[i];
    }

    sort(a, a + n);

    ll result = 1;
    for (int i = n - 1; i >= 0; i--) {
        result *= count_available(a[i]) - (n - i - 1);
    }

    cout << result << endl;

    return 0;
}
