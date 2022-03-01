#include <bits/stdc++.h>

using namespace std;

long solve(vector<long> nums) {
    long maxSum = nums[0];

    long minimumPrefixSum = 0;
    long currentPrefixSum = 0;

    for (int i = 0; i < nums.size(); i++) {
        currentPrefixSum += nums[i];
        maxSum = max(maxSum, currentPrefixSum - minimumPrefixSum);
        minimumPrefixSum = min(minimumPrefixSum, currentPrefixSum);
    }

    return maxSum;
}

int main() {
    int n;
    cin >> n;

    vector<long> nums(n);
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    cout << solve(nums) << endl;

    return 0;

}
