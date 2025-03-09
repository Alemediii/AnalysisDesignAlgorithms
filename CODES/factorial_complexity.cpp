#include <iostream>
#include <vector>
#include <algorithm> // for next_permutation

using namespace std;

// Function to print a vector
void printVector(const vector<int>& vec) {
    for (int num : vec) {
        cout << num << " ";
    }
    cout << endl;
}

// Recursive function to generate all permutations
void generatePermutations(vector<int>& elements, int start) {
    if (start == elements.size() - 1) {
        printVector(elements);
        return;
    }
    
    for (int i = start; i < elements.size(); ++i) {
        swap(elements[start], elements[i]);
        generatePermutations(elements, start + 1);
        swap(elements[start], elements[i]); // backtrack
    }
}

int main() {
    vector<int> elements = {1, 2, 3};

    cout << "All permutations of the set are:\n";
    generatePermutations(elements, 0);
    
    return 0;
}
