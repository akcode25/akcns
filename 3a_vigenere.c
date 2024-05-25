#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
void encrypt()
{
    char pt[128];
    char k[16];
    printf("\nEnter the plaintext: ");
    scanf("%s",pt);
    printf("Enter the key: ");
    scanf("%s",k);
    printf("Ciphertext: ");
    for(int i=0,j=0;i<strlen(pt);i++,j++)
    {
        if(j>=strlen(k))j=0;
        int shift=toupper(k[j])-'A';
        char ch = ((toupper(pt[i])-'A' + shift)%26)+'A';
        printf("%c",ch);
    }

}
void decrypt()
{
    char ct[128];
    char k[16];
    printf("\nEnter the ciphertext: ");
    scanf("%s",&ct);
    printf("Enter the key: ");
    scanf("%s",&k);
    printf("Plaintext: ");
    for(int i=0,j=0;i<strlen(ct);i++,j++)
    {
        if(j>=strlen(k))j=0;
        int shift=toupper(k[j])-'A';
        char ch = ((toupper(ct[i])-'A' - shift + 26)%26)+'A';
        printf("%c",ch);
    }
}
int main()
{
    int choice;
    while(1)
    {
        printf("\n\n1.Encrypt");
        printf("\n2.Decrypt");
        printf("\n3.Exit");
        printf("\nEnter your choice: ");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1:encrypt();break;
            case 2:decrypt();break;
            case 3:exit(0);
            default:printf("Invalid Selection");break;
        }
    }
    return 0;
}







