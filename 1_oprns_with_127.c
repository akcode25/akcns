#include<stdio.h>
#include<string.h>

// a-z: 97-122, A-Z: 65-90

int main(){
	char str[]="hello world";
	printf(str);
	
	char str1[11],str2[11],str3[11];
	int i,len;
	len=strlen(str);

	printf("\nAfter applying AND operator, corresponding ASCII values:\n");
	for(i=0;i<len;i++){
		str1[i]=str[i] & 127;
		printf("%c = %d \n",str[i],str1[i]);
	}

	printf("\nAfter applying OR operator, corresponding ASCII values:\n");	
	for(i=0;i<len;i++){
		str2[i]=str[i] | 127;
		printf("%c = %d \n",str[i],str2[i]);
	}

	printf("\nAfter applying XOR operator, corresponding ASCII values:\n");	
	for(i=0;i<11;i++){
		str3[i]=str[i] ^ 127;
		printf("%c = %d \n",str[i],str3[i]);
	}
}