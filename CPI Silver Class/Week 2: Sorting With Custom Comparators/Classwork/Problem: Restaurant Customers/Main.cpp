#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector< pair<int, int> > customers;
    pair<int, int> customer;

    for (int i = 0; i < n; i++) {
        cin >> customer.first;
        customer.second = 1;
        customers.push_back(customer);
        cin >> customer.first;
        customer.second = -1;
        customers.push_back(customer);
    }

    sort(customers.begin(), customers.end());

    int currentCustomer = 0;
    int result = 0;
    for (auto c : customers) {
        currentCustomer += c.second;
        result = max(result, currentCustomer);
    }

    cout << result << endl;

}
