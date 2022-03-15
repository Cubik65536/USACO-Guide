#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> A;

bool works_right(int start, int rad) {
    int cur = start, nex = 0;
    while (cur < A.back())
    {
        while (nex + 1 < n && A[nex + 1] <= cur + rad)
            nex++;
        if (A[nex] == cur)
        {
            return false;
        }
        cur = A[nex];
        rad -= 2;
    }
    return true;
}

bool works_left(int start, int rad)
{
    for (int &x : A)  {
        x *= -1;
    }
    reverse(A.begin(), A.end());
    bool ans = works_right(-start, rad);
    reverse(A.begin(), A.end());
    for (int &x : A) {
        x *= -1;
    }
    return ans;
}

int main()
{
    freopen("angry.in", "r", stdin);
    freopen("angry.out", "w", stdout);

    cin >> n;

    A.resize(n);

    for (int i = 0; i < n; ++i)
    {
        cin >> A[i];
        A[i] *= 2;
    }

    sort(A.begin(), A.end());

    int low = 0, high = 2e9;
    while (low < high) {
        int mid = low + (high - low) / 2;
        int l = A.front(), r = A.back();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (works_right(m, mid)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (works_left(l, mid)) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }

    cout << fixed << setprecision(1) << low / 2.0 << endl;

    return 0;
}
