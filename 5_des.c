#include<stdio.h>
// Initial permutation (IP) table
int IP[] = {2, 6, 3, 1, 4, 8, 5, 7};
// Inverse initial permutation (IP^-1) table
int IP_inverse[] = {4, 1, 3, 5, 7, 2, 8, 6};
// S-boxes
int S0[4][4] = {
    {1, 0, 3, 2},
    {3, 2, 1, 0},
    {0, 2, 1, 3},
    {3, 1, 3, 2}
};
int S1[4][4] = {
    {0, 1, 2, 3},
    {2, 0, 1, 3},
    {3, 0, 1, 0},
    {2, 1, 0, 3}
};
// Function to perform initial permutation
int ip(int plaintext) {
    int result = 0;
    for (int i = 0; i < 8; i++) {
        result |= ((plaintext >> (8 - IP[i])) & 1) << (7 - i);
    }
    return result;
}
// Function to perform inverse initial permutation
int inverse_ip(int ciphertext) {
    int result = 0;
    for (int i = 0; i < 8; i++) {
        result |= ((ciphertext >> (8 - IP_inverse[i])) & 1) << (7 - i);
    }
    return result;
}
// Function to perform S-box substitution
int s_box_substitution(int value, int s_box[4][4]) {
    int row = ((value & 0b1000) >> 2) | (value & 0b0001);
    int col = (value & 0b0110) >> 1;
    return s_box[row][col];
}
int main() {
    int plaintext = 0b11010110;
    printf("Plain Text: %x\n", plaintext);
    int ciphertext = ip(plaintext);
    printf("Cipher Text: %x\n", ciphertext);

    // Example of S-box substitution
    int val = 0b1101; // Example value
    int sboxres = s_box_substitution(val, S0);
    printf("S-box result: %x\n", sboxres);

    int decrypted_text = inverse_ip(ciphertext);
    printf("Decrypted Text: %x\n", decrypted_text);
    return 0;
}
