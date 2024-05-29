#include<stdio.h>
#include<string.h>
void main() {
    int i, j, k, l;
    char str[20], ct[20], dt[20];
    printf("Enter the input string: ");
    scanf("%s",str); //gets(str);
    l = strlen(str);

    //ciphering
    for (i=0,j=0; i<l; i++)
        if (i % 2 == 0) ct[j++] = str[i];
    for (i=0; i<l; i++)
        if (i % 2 == 1) ct[j++] = str[i];
    ct[j]='\0';                             //last character of a string
    printf("Ciphertext: %s",ct);

    if (l % 2 == 0) k = l/2;
    else k = (l/2) + 1;

    //deciphering
    for (i=0,j=0; i<k; i++, j+=2)
        dt[j] = ct[i];             //1st rail deciphered (1st half: 0 to k)
    for (i=k,j=1; i<l; i++, j+=2)
        dt[j] = ct[i];             //2nd rail deciphered (2nd half: k to l)
    dt[l]='\0';
    printf("\nDecrypted text: %s",dt);
}
