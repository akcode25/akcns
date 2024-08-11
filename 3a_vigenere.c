#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

void encrypt(){
    char pt[128], k[16];
    printf("\nEnter plaintext: ");
    scanf("%s",pt);
    printf("Enter key: ");
    scanf("%s",k);
    printf("Ciphertext is: ");
    for (int i=0,j=0; i < strlen(pt); i++,j++) {
        if (j >= strlen(k))
            j=0;
        // int shift = toupper(k[j])-'A';
        // char ch = ((toupper(pt[i])-'A' + shift) % 26) + 'A';
        char ch = (((toupper(pt[i])-'A') + (toupper(k[j])-'A')) % 26) + 'A';
        printf("%c", ch);
    }
}
void decrypt() {
    char ct[128], k[16];
    printf("\nEnter the ciphertext: ");
    scanf("%s",&ct);
    printf("Enter the key: ");
    scanf("%s",&k);
    printf("Plaintext is: ");
    for (int i=0,j=0; i < strlen(ct); i++,j++) {
        if (j >= strlen(k))
            j=0;
        // int shift = toupper(k[j])-'A';
        // char ch = ((toupper(ct[i])-'A' - shift+26 ) % 26) + 'A';
        char ch = (((toupper(ct[i])-'A') - (toupper(k[j])-'A')+26 ) % 26) + 'A';
        printf("%c", ch);
    }
}
int main() {
    int choice;
    while(1) {
        printf("\n\n1.Encrypt\n2.Decrypt\n3.Exit\nEnter your choice: ");
        scanf("%d", &choice);
        switch(choice) {
            case 1: encrypt(); break;
            case 2: decrypt(); break;
            case 3: exit(0);
            default: printf("Invalid"); break;
        }
    }
    return 0;
}

