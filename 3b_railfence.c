#include<stdio.h>
#include<string.h>
void main() {
    int i,j,k,l;
    char a[20],c[20],d[20];
    printf("Enter the input string : ");
    gets(a);
    l=strlen(a);
    //Ciphering
    for(i=0,j=0;i<l;i++) {
        if(i%2==0)
        c[j++]=a[i];
    }
    for(i=0;i<l;i++) {
        if(i%2==1)
        c[j++]=a[i];
    }
    c[j]='\0';
    printf("Cipher text after applying rail fence : %s\n",c);
    //Deciphering
    if(l%2==0) 
        k=l/2;
    else 
        k=(l/2)+1;
    for(i=0,j=0;i<k;i++,j+=2)
        d[j]=c[i];
    for(i=k,j=1;i<l;i++,j+=2)
        d[j]=c[i];
    d[l]='\0';
    printf("\nText after decryption : ");
    printf("%s",d);
}





















