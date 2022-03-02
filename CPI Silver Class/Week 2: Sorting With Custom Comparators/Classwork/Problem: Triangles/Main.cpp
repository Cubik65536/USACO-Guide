#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7; 
const int mxN = 1e5 + 10; 
const int mxA = 2e4 + 3; 

int n; 
array<int, 3> triangles[mxN]; 
int solution[mxN][2]; 

int main() {
	freopen("triangles.in", "r", stdin); 
	freopen("triangles.out", "w", stdout); 	

	cin >> n; 

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2; j++) {
			cin >> triangles[i][j]; 
			triangles[i][j] += 10000; 
		}
		triangles[i][2] = i; 
	}
	
	for (int t = 0; t < 2; t++) {
		vector<vector<array<int, 2>>> process(mxA); 

		for (int i = 0; i < n; i++) {
			process[triangles[i][0]].push_back({triangles[i][1], triangles[i][2]}); 
		}

		for (int i = 0; i < mxA; i++) {
			if (!process[i].size()) {
                continue; 
            }

			sort(process[i].begin(), process[i].end()); 

			int sum = 0; 
			for (int j = 1; j < process[i].size(); j++) {
				sum += process[i][j][0] - process[i][0][0]; 
			}
			solution[process[i][0][1]][t] = sum;

			for (int j = 1; j < process[i].size(); j++) {
				sum += (process[i][j][0] - process[i][j - 1][0]) * (2 * j - (int)process[i].size()); 
				solution[process[i][j][1]][t] = sum; 
			}

		}

		for (int i = 0; i < n; i++) {
			swap(triangles[i][0], triangles[i][1]); 
		}
	}

	int result = 0; 
	for (int i = 0; i < n; i++) {
		result = (result + 1LL * solution[i][0] * solution[i][1]) % MOD;  
	}

	cout << result << endl;

    return 0;
}
