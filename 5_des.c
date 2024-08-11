#include<stdio.h>
int IP[] = {2,6,3,1,4,8,5,7};     //initial permutation
int IP_inv[] = {4,1,3,5,7,2,8,6}; //inverse ip

int S0[4][4] = {
    {0,1,2,3},
    {1,2,3,0},
    {2,3,0,1},
    {3,0,1,2}
};

int S1[4][4] = {
    {3,2,1,0},
    {2,1,0,3},
    {1,0,3,2},
    {0,3,2,1}
};

int ip (int pt) {
    int res = 0;
    for (int i=0; i < 8; i++)
        res |= ((pt >> (8 - IP[i])) & 1) << (7 - i);
    return res;
}

int ip_inv (int ct) {
    int res = 0;
    for (int i=0; i < 8; i++)
        res |= ((ct >> (8 - IP_inv[i])) & 1) << (7 - i);
    return res;
}

int s_box_sub (int val, int s_box[4][4]) {   //S-box substitution
    int row = ((val & 0b1000) >> 2) | (val & 0b0001);
    int col = (val & 0b0110) >> 1;
    return s_box[row][col];
}

int main() {
    int pt = 0b11010110;
    printf("Plaintext: %x\n", pt);
    int ct = ip(pt);
    printf("Ciphertext; %x\n", ct);

    int val = 0b1101;
    int sboxres = s_box_sub(val, S0);
    printf("S-boz result: %x\n", sboxres);

    int dt = ip_inv(ct);
    printf("Decrypted text: %x\n",dt);

    return 0;
}


/*
//dont matter
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
*/
