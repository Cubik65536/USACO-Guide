#include <bits/stdc++.h>
using namespace std;

using ld = long double;

int n;

bool canMeet(vector<ld>& coordinates, vector<ld>& speed, ld time) {
    ld maxLeft = 0.0000;
    ld minRight = 2e9;

    for (int i = 0; i < n; i++) {
        ld positionLeft, positionRight;
        ld currentPosition = coordinates[i];
        ld currentSpeed = speed[i];
        positionLeft = currentPosition - currentSpeed * time;
        positionRight = currentPosition + currentSpeed * time;
        maxLeft = max(maxLeft, positionLeft);
        minRight = min(minRight, positionRight);
    }

    if (minRight < maxLeft) {
        return false;
    }

    return true;
}

int main() {
    cin >> n;

    vector<ld> coordinates(n);
    for (int i = 0; i < n; i++) {
        cin >> coordinates[i];
    }

    vector<ld> speed(n);
    for (int i = 0; i < n; i++) {
        cin >> speed[i];
    }

    ld left = 0.0000;
    ld right = 1e9;

    const ld eps = 1e-9;

    while ((left + eps) < right) {
        ld mid = (left + right) / 2;
        if (canMeet(coordinates, speed, mid)) {
            right = mid;
        } else {
            left = mid;
        }
    }

    cout << setprecision(18) << left << endl;

    return 0;
}
