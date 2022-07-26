#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
	int longestCommonSubsequence(string text1, string text2) {
		int dp[text1.size() + 1][text2.size() + 1];
		
        for (int i = 0; i < text1.size(); i++) {
            for (int j = 0; j < text2.size(); j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i < text1.size(); i++) {
			if (text1[i] == text2[0]) {
                dp[i][0] = 1;
            }
			if (i != 0) {
                dp[i][0] = max(dp[i][0], dp[i - 1][0]);
            }
		}
		for (int i = 0; i < text2.size(); i++) {
			if (text1[0] == text2[i]) {
                dp[0][i] = 1;
            }
			if (i != 0) {
                dp[0][i] = max(dp[0][i], dp[0][i - 1]);
            }
		}

        for (int i = 1; i < text1.size(); i++) {
            for (int j = 1; j < text2.size(); j++) {
                if (text1[i] == text2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

		return dp[text1.size() - 1][text2.size() - 1];
	}
};

int main() {
    string text1, text2;
    cin >> text1 >> text2;

    int result = Solution().longestCommonSubsequence(text1, text2);

    cout << result << endl;

    return 0;
}
