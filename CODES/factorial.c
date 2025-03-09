#include <stdio.h>

int factorial(int N) {
    int f = 1; // Result variable
    double value;
    if (N == 0) {
        f = 1; // Base case
    } else {
        f = N * factorial(N - 1); // Recursive case
        value = f;
    }
    return f;
}

int main() {
    printf("%d\n", factorial(5)); // Use %d to print an integer
    return 0;
}
