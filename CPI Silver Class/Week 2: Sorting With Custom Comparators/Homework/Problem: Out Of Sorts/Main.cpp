#include <bits/stdc++.h>
using namespace std;

struct Entry {
    int index, value;
};

int main() {
    freopen("sort.in", "r", stdin);
    freopen("sort.out", "w", stdout);

    int n;
    cin >> n;

    Entry entries[n];
    for (int i = 0; i < n; i++) {
        entries[i].index = i;
        cin >> entries[i].value;
    }

    sort(entries, entries + n, [](Entry a, Entry b) {
        return a.value < b.value || (a.value == b.value && a.index < b.index);
    });
    
    int result = 0;
    for (int i = 0; i < n; i++) {
        result = max(result, entries[i].index - i);
    }

    cout << result + 1 << endl;

    return 0;

}
