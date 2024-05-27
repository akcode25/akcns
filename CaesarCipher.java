

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CaesarCipher {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        System.out.println("Enter any String:");
        String str = br.readLine();
        System.out.println("Enter the key:");
        int key = sc.nextInt();
        
        String encryptedString = processString(str, key, true);
        System.out.println("Encrypted string is: " + encryptedString);
        
        String decryptedString = processString(encryptedString, key, false);
        System.out.println("Decrypted string is: " + decryptedString);
    }
    public static String processString(String str, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int direction = encrypt ? 1 : -1;

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                ch = (char) ('A' + (ch - 'A' + direction * key + 26) % 26);
            } else if (Character.isLowerCase(ch)) {
                ch = (char) ('a' + (ch - 'a' + direction * key + 26) % 26);
            }
            result.append(ch);
        }
        return result.toString();
    }
}






/*
import java.util.*;
class CeaserCipher {
    static String encrypt (String s, int key){
        String ans="";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i); 
            char add= '.';
            if(Character.isUpperCase(c))
                add= (char)('A'+(c-'A'+key)%26);
            else if (Character.isLowerCase(c))
                add=(char)('a'+(c-'a'+key)%26);
            else 
                add=c;
            ans+=add;
        }
        return ans;
    }

    static String decryp(String s, int key){
        return encrypt(s, 26-key);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plaintext: ");
        String pt= sc.nextLine();
        System.out.println("Enter the key: ");
        int key= sc.nextInt();
        sc.close();
        String en=encrypt(pt, key);
        System.out.println("Encrypted text is: "+en);
        System.out.println("The decrypted msg is: "+decryp(en, key));
    }

}
*/

/* 

// akruti

import java.util.Scanner;

public class CaesarCipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String process(String text, int shift, boolean encrypt) {
        text = text.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int pos = ALPHABET.indexOf(c);
            if (pos != -1) {
                int newPos = (encrypt ? pos + shift : pos - shift) % 26;
                if (newPos < 0) newPos += 26;
                result.append(ALPHABET.charAt(newPos));
            } else {
                result.append(c); // Handle non-alphabetic characters
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string for encryption: ");
        String message = sc.next();
        System.out.println("Enter the shift key: ");
        int shiftKey = sc.nextInt();
        String encrypted = process(message, shiftKey, true);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + process(encrypted, shiftKey, false));
        sc.close();
    }
}
*/

