#include<stdio.h>
#include<string.h>

int main() {
    int k[3][3] = {               //for en
        {17, 17, 5},
        {21, 18, 21},
        {2, 2, 19}
    };
    int ki[3][3] = {              //for decrp
        {4, 9, 15},
        {15, 17, 6},
        {24, 0, 17}
    };

    int i, j, t=0, a[20], b[20];  //arrays store num form of chars
    char msg[20];

    printf ("Enter 3 char plaintext (in caps): ");
    scanf ("%s",msg);
    for (i=0; i<3; i++)
        a[i] = msg[i] - 65;      //pt chars to nums (A=0,..,Z=25)

    //ENCRYPTION
    for (i=0; i<3; i++){
        t = 0;
        for (j=0; j<3; j++)
            t += (k[i][j] * a[j]);
        b[i] = t % 26;            //range 0-25
    }
    printf("Ciphertext: ");
    for (i=0; i<3; i++)
        printf("%c", b[i] +65);  // num values back to chars

    //DECRYPTION
    for (i=0; i<3; i++) {
        t = 0;
        for (j=0; j<3; j++)
            t += (ki[i][j] * b[j]);
        a[i] = t % 26;
    }
    printf("\nPlaintext: ");
    for (i=0; i<3; i++)
        printf("%c", a[i] +65);

    return 0;
}


    // int a[3][3]=
    // {
    //     {6,24,1},
    //     {13,16,10},
    //     {20,17,15}
    // };
    // int b[3][3]=
    // {
    //     {8,5,10},
    //     {21,8,21},
    //     {21,12,8}
    // };



