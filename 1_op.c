#include<stdio.h>
#include<string.h>

// a-z: 97-122, A-Z: 65-90

int main() {
    char str[]="hello world";
    printf("original string: %s",str);
    char str1[11], str2[11], str3[11];
    int i, len= strlen(str);

    printf ("\nASCII values after AND operation with 127:\n");
    for (i=0; i<len; i++) {
        str1[i] = str[i] & 127;
        printf("%c = %d \n", str[i], str1[i]);
    }

    printf ("\nASCII values after OR operation with 127:\n");
    for (i=0; i<len; i++) {
        str2[i] = str[i] | 127;
        printf("%c = %d \n", str[i], str2[i]);
    }

    printf ("\nASCII values after XOR operation with 127:\n");
    // for (i=0; i<len; i++) {
    for (int i = 0; str[i] != '\0'; i++) {
        str3[i] = str[i] ^ 127;
        printf("%c = %d \n", str[i], str3[i]);
    }
}